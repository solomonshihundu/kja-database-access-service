package com.ss.houserecommendation.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ss.houserecommendation.model.House;

@Repository("postgres_implementation")
public class HouseDataAccessService implements HouseDao
{
	
	private final JdbcTemplate jdbcTemplate;
	
	private String hseNameUpdate = "Gray Ilse";
	private String hseImageUrlUpdate = "http//rjhtgehe";
	private String hseLocationUpdate = "Kahawa";
	private String hseDescriptionUpdate = "A very nice place";
	private String hsePriceUpdate = "125689";
	
	@Autowired
	public HouseDataAccessService(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertHouse(UUID id, House house)
	{
		jdbcTemplate.update("INSERT INTO schema.housedata (id,name,imageurl,location,description,price) VALUES (?, ?, ?, ?, ?, ?)",
				id, hseNameUpdate,hseImageUrlUpdate,hseLocationUpdate,hseDescriptionUpdate,hsePriceUpdate );
		return 1;
	}

	@Override
	public List<House> selectAllHouses()
	{
		//get everything form the table
		final String sqlQuery = "SELECT id,name,imageUrl,location,description,price FROM housedata";
		
		return jdbcTemplate.query(sqlQuery, (resultSet,i) -> {
			return new House(UUID.fromString(resultSet.getString("id"))
					,resultSet.getString("name")
					,resultSet.getString("imageurl")
					,resultSet.getString("location")
					,resultSet.getString("description")
					,resultSet.getString("price"));
		});
		
	}

	@Override
	public Optional<House> selectHouseById(UUID id)
	
	{
		final String sqlQuery = "SELECT id,name,imageUrl,location,description,price FROM housedata WHERE id = ?";
		
		House house = jdbcTemplate.queryForObject(sqlQuery, new Object[] {id},
				(resultSet,i)->{
					return new House(UUID.fromString(resultSet.getString("id"))
							,resultSet.getString("name")
							,resultSet.getString("imageurl")
							,resultSet.getString("location")
							,resultSet.getString("description")
							,resultSet.getString("price"));
				
				});
		return Optional.ofNullable(house);
	}

	@Override
	public int deleteHouseById(UUID id) 
	{
		final String sqlQuery = "DELETE FROM housedata WHERE id = ?";
		jdbcTemplate.update(sqlQuery, id);
		return 1;
	}

	@Override
	public int updateHouseById(UUID id, House house) 
	{
		String updateQuery = "update housedata where id = ?";
		jdbcTemplate.update(updateQuery,house,id);
		return 1;
	}

}
