package com.desenvortex.animaladoption.pet;

public record PetResponseDTO (Long id, String title, String image, Double price) {
	public PetResponseDTO(Pet pet) {
		this(pet.getId(), pet.getTitle(), pet.getImage(), pet.getPrice());
	}
}
