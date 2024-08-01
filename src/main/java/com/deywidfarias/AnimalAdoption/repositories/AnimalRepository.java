package com.deywidfarias.AnimalAdoption.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deywidfarias.AnimalAdoption.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

}
