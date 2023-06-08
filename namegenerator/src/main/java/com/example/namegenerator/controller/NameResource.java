package com.example.namegenerator.controller;

import com.example.namegenerator.AnimalServiceClient;
import com.example.namegenerator.ScientistServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/names")
class NameResource {

	@Autowired
	private AnimalServiceClient animalServiceClient;
	@Autowired
	private ScientistServiceClient scientistServiceClient;


	@GetMapping(path = "/random")
	public String name() throws Exception {
		String animal = animalServiceClient.randomAnimalName();
		String scientist = scientistServiceClient.randomScientistName();
		String name = (scientist) + "-" + (animal);
		return name;
	}
}