package com.bike.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bike.model.Bike;

@Repository
public interface BikeDao extends JpaRepository<Bike, Integer>{

}
