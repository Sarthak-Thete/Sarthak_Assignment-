package com.example.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.Tour;
import com.example.repo.TourRepo;


public class TourService implements ITourService {

	@Autowired
	private TourRepo tour;
	
	public void savePackage(Tour newTour) {
		tour.save(newTour);
		System.out.println("New Tour Added SucessFully");		
	}

	
	public List<TourRepo> getAll() {
		return tour.findAll();	
	}
	
	public Tour getTourByName(String name) {
	    return tour.findTourByName(name);
	}

	
	public void deleteById(int id) {
	    Optional<TourRepo> c = tour.findById(id);
	    c.ifPresent(tour -> tour.deleteById(id));
	}

	
}
