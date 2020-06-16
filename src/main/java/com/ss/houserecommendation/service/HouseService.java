package com.ss.houserecommendation.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ss.houserecommendation.dao.HouseDao;
import com.ss.houserecommendation.model.House;

@Service
public class HouseService 
{	
	private final HouseDao houseDao;

	@Autowired
	public HouseService(@Qualifier("dummyDao") HouseDao houseDao) 
	{
		this.houseDao = houseDao;
	}
	
	public int insertHouse(House house)
	{
		return houseDao.insertHouse(house);
	}
	
	public List<House> getAllHouses()
	{
		return houseDao.selectAllHouses();
	}
	
	public Optional<House> getHouseById(UUID id)
	{
		return houseDao.selectHouseById(id);
	}
	
	public int deleteHouse(UUID id)
	{
		return houseDao.deleteHouseById(id);
	}
	
	public int updateHouse(UUID id,House houseUpdate)
	{
		return houseDao.updateHouseById(id, houseUpdate);
	}
	
}
