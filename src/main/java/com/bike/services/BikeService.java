package com.bike.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.dao.BikeDao;
import com.bike.dao.FeaturesDao;
import com.bike.model.Bike;
import com.bike.model.Features;

@Service
public class BikeService {
	@Autowired
	BikeDao bdao;
	@Autowired
	FeaturesDao fdao;
	
	public List<Bike> getAllBike(){
		return bdao.findAll();
	}
	
	public Bike getById(int id)
	{
		try {
			return bdao.findById(id).get();
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public Bike insert(Bike b)
	{
		Features f=b.getFeatures();
		Features f1=fdao.save(f);
		b.setFeatures(f1);
		return bdao.save(b);
	}
	public boolean delete(int bid)
	{
		try {
		Bike b=bdao.findById(bid).orElseThrow(EntityNotFoundException::new);
		if(b!=null)
		{
			Features f=b.getFeatures();
			bdao.delete(b);
			fdao.delete(f);
			return true;
		}
		else
			return false;
		}catch (EntityNotFoundException e) {
			return false;
		}
	}
	
	public Bike updatebike(Bike bike)
	{
		try {
			Bike b=bdao.findById(bike.getBid()).get();
			if(b!=null)
				return bdao.save(bike);
			else
				return null;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public List<Features> getAllFeatures()
	{
		return fdao.findAll();
	}
}
