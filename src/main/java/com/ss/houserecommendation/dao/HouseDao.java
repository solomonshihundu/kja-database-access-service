package com.ss.houserecommendation.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ss.houserecommendation.model.House;

public interface HouseDao
{
	int insertHouse(UUID id,House house);
	
	default int insertHouse(House house)
	{
		UUID id = UUID.randomUUID();
		return insertHouse(id,house);
				
	}
	
	List<House> selectAllHouses();
	
	Optional<House>selectHouseById(UUID id);
	
	int deleteHouseById(UUID id);
	
	int updateHouseById(UUID id,House house);
	

}
