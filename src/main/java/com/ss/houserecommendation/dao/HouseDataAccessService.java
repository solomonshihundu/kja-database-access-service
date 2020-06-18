package com.ss.houserecommendation.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.ss.houserecommendation.model.House;

@Repository("postgres")
public class HouseDataAccessService implements HouseDao
{

	@Override
	public int insertHouse(UUID id, House house)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<House> selectAllHouses()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<House> selectHouseById(UUID id)
	
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteHouseById(UUID id) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHouseById(UUID id, House house) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
