package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Tour;
import com.example.repo.TourRepo;
import com.example.service.TourService;



@RestController

public class TourController {
	
	@Autowired
	private TourService service;
	
	//http://localhost:5680/add 
	@PostMapping("/add")
	public void addPackage(@RequestBody Tour newPackage) {
		service.savePackage(newPackage);
	}
	
	//http://localhost:5680/all
	@GetMapping("/all")
	public List<TourRepo> getAllTours(){
		return service.getAll();
	}
	
	@GetMapping("/get")
	public Tour getTourByName(@RequestBody String name) {
	    return service.getTourByName(name);
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestBody int id) {
	    service.deleteById(id);
	}

	

}
