package com.desenvortex.animaladoption.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvortex.animaladoption.pet.Pet;
import com.desenvortex.animaladoption.pet.PetRepository;
import com.desenvortex.animaladoption.pet.PetRequestDTO;
import com.desenvortex.animaladoption.pet.PetResponseDTO;

@RestController
@RequestMapping(value = "/pets")
public class PetController {
	
	@Autowired
	PetRepository repository;
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@GetMapping
	public List<PetResponseDTO> getAll() {
		List<PetResponseDTO> foodList = repository.findAll().stream().map(PetResponseDTO::new).toList();
		return foodList;
	}
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PostMapping
	public void saveFood(@RequestBody PetRequestDTO data) {
		Pet foodData = new Pet(data);
		repository.save(foodData);
	}

}
