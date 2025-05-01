package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Tour;

public interface TourRepo extends JpaRepository<TourRepo, Integer> {

	void save(Tour newTour);
	
	public Tour findTourByName(String name);

}
