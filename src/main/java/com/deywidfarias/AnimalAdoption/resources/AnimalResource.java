package com.deywidfarias.AnimalAdoption.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deywidfarias.AnimalAdoption.entities.Animal;
import com.deywidfarias.AnimalAdoption.services.AnimalService;

@RestController
@RequestMapping(value = "/animals")
public class AnimalResource {

	@Autowired
	private AnimalService service;

	@CrossOrigin(origins="*", allowedHeaders = "*")
	@GetMapping
	public ResponseEntity<List<Animal>> findAll() {
		List<Animal> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@CrossOrigin(origins="*", allowedHeaders = "*")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Animal> findById(@PathVariable Long id) {
		Animal obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PostMapping
	public ResponseEntity<Animal> insert(@RequestBody Animal obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin(origins="*", allowedHeaders = "*")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal obj) {
		obj = service.updateStatus(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
