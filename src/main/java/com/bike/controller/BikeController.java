package com.bike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bike.model.Bike;
import com.bike.model.Features;
import com.bike.services.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {
	@Autowired
	BikeService service;
	@GetMapping("/allbike")
	public List<Bike> getallBike(){
		return service.getAllBike();
	}
	
	@GetMapping("/{bid}")
	public Bike getbikeById(@PathVariable int bid)
	{
		return service.getById(bid);
	}
	
	@PostMapping("/")
	public Bike insertBike(@RequestBody Bike bike)
	{
		return service.insert(bike);
	}
	@PutMapping("/")
	public Bike updateBike(@RequestBody Bike bike)
	{
		return service.insert(bike);
	}
	@DeleteMapping("/{bid}")
	public boolean deletebyId(@PathVariable int bid)
	{
		return service.delete(bid);
	}
	
	@GetMapping("/allfeatures")
	public List<Features> getallFeatures(){
		return service.getAllFeatures();
	}
}
