package com.deywidfarias.AnimalAdoption.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.deywidfarias.AnimalAdoption.entities.Animal;
import com.deywidfarias.AnimalAdoption.entities.enums.AnimalStatus;
import com.deywidfarias.AnimalAdoption.repositories.AnimalRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private AnimalRepository animalRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub		
		Animal a1 = new Animal(
				null,
				"Whiskas",
				"Gato de pelagem escura",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Black_cat_in_Pamukkale%2C_Turkey.jpg/800px-Black_cat_in_Pamukkale%2C_Turkey.jpg",
				"Felina",
				"2023-04-02",
				AnimalStatus.DISPONIVEL);
		Animal a2 = new Animal(
				null,
				"Coronel",
				"Cachorro de pelagem escura",
				"https://segredosdomundo.r7.com/wp-content/uploads/2021/09/cachorro-preto-quais-sao-as-principais-racas-e-suas-caracteristicas-1.jpg",
				"Canina",
				"2024-01-29",
				AnimalStatus.DISPONIVEL);
		animalRepository.saveAll(Arrays.asList(a1,a2));
	}
}
