package com.bike.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bike.model.Features;

@Repository
public interface FeaturesDao extends JpaRepository<Features, Integer>{

}
