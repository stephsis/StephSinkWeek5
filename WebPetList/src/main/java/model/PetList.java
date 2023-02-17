package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author stephaniesink - sisink
 * CIS175 - Spring 2022
 * Feb 8, 2023
 */
@Entity
@Table(name = "pets")
public class PetList {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "Animal")
	private String animal;
	@Column(name = "Breed")
	private String breed;
	
	//no-arg default constructor
	public PetList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constuctor with parameters
	public PetList(String animal, String breed) {
		super();
		this.animal = animal;
		this.breed = breed;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	} 
	
	//helper method 
	public String returnPetInfo() {
		return this.animal + " | " + this.breed;
	}	
	
}
