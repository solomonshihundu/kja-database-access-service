package com.ss.houserecommendation.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.houserecommendation.model.House;
import com.ss.houserecommendation.service.HouseService;

@RequestMapping("api/v1/house")
@RestController
public class HouseController {
	
	private final HouseService houseService;

	@Autowired
	public HouseController(HouseService houseService) {
		this.houseService = houseService;
	}
	
	@PostMapping
	public void addHouse(@Validated @NonNull @RequestBody House house)
	{
		houseService.insertHouse(house);
	}
	
	@GetMapping
	public List<House> getAllHouses()
	{
		return houseService.getAllHouses();
	}
	
	@GetMapping(path = "{id}")
	public House getHouseById(@PathVariable("id") UUID id)
	{
		return houseService.getHouseById(id).orElse(null);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteHouseById(@PathVariable("id")UUID id)
	{
		houseService.deleteHouse(id);
	}
	
	@PutMapping(path = "{id}")
	public void updateHouse(@PathVariable("id") UUID id,@Validated @NonNull @RequestBody House houseUpdate)
	{
		houseService.updateHouse(id, houseUpdate);
		
	}

}
