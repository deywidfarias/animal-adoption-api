package com.deywidfarias.AnimalAdoption.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import com.deywidfarias.AnimalAdoption.entities.enums.AnimalStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_animal")
public class Animal implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String imagemUrl;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
	private LocalDate dataNascimento;
	private Integer status;
	private String categoria;
	
	public Animal() {}
		
	public Animal(Long id, String nome, String descricao, String imagemUrl, String categoria, String dataNascimento,
			AnimalStatus status) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imagemUrl = imagemUrl;
		this.categoria = categoria;
		setDataNascimento(dataNascimento);
		setStatus(status);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDataNascimento() {
		return dataNascimento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();
	}

	public void setDataNascimento(String dataNascimento) {
		
		this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public AnimalStatus getStatus() {
		return AnimalStatus.valueOf(status);
	}

	public void setStatus(AnimalStatus animalStatus) {
		if(animalStatus != null)
			this.status = animalStatus.getCode();
	}
	
	public int getIdade() {
		long idade;
		idade = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
		return (int)idade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(id, other.id);
	}
	
}
