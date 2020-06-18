package com.ss.houserecommendation.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.ss.houserecommendation.model.House;

@Repository("dummyDao")
public class DummyHouseDataAccessService implements HouseDao
{
	
	private static List<House> houseDB = new ArrayList<>();

	@Override
	public int insertHouse(UUID id, House house) {
		houseDB.add(new House(id,house.getName(),house.getImageUrl(),house.getLocation(),house.getDescription(),house.getPrice()));
		return 1; 
	}

	@Override
	public List<House> selectAllHouses() {
		// TODO Auto-generated method stub
		return houseDB;
	}

	@Override
	public Optional<House> selectHouseById(UUID id) {
		
		return houseDB.stream().filter(house -> house.getId().equals(id)).findFirst();
	}

	@Override
	public int deleteHouseById(UUID id) {
		Optional<House> houseVar = selectHouseById(id);
		if(houseVar.isEmpty())
		{
			return 0;
		}
		houseDB.remove(houseVar.get());
		return 1;
	}

	@Override
	public int updateHouseById(UUID id, House houseUpdate) 
	{
		return selectHouseById(id).map(house -> {int indexOfHouseToUpdate = houseDB.indexOf(house);
		if(indexOfHouseToUpdate >= 0) 
		{
			houseDB.set(indexOfHouseToUpdate, new House(id,houseUpdate.getName(),houseUpdate.getImageUrl(),houseUpdate.getLocation()
					,houseUpdate.getDescription(),houseUpdate.getPrice()));
			return 1;
		}
		return 0;
		
		}).orElse(0);
	}

}
