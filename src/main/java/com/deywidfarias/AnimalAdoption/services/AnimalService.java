package com.deywidfarias.AnimalAdoption.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.deywidfarias.AnimalAdoption.entities.Animal;
import com.deywidfarias.AnimalAdoption.repositories.AnimalRepository;
import com.deywidfarias.AnimalAdoption.services.exceptions.DatabaseException;
import com.deywidfarias.AnimalAdoption.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository repository;
	
	public List<Animal> findAll() {
		return repository.findAll();
	}

	public Animal findById(Long id) {
		Optional<Animal> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Animal insert(Animal obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Animal updateStatus(Long id, Animal obj) {
		try {
			Animal entity = repository.getReferenceById(id);
			var status = (obj.getStatus());
			obj = entity;
			obj.setStatus(status);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Animal entity, Animal obj) {
		entity.setNome(obj.getNome());
		entity.setDescricao(obj.getDescricao());
		entity.setImagemUrl(obj.getImagemUrl());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setStatus(obj.getStatus());
		entity.setCategoria(obj.getCategoria());	
	}

}
