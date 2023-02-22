package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author stephaniesink - sisink
 * CIS175 - Spring 2022
 * Feb 20, 2023
 */

@Entity
public class AdoptionDetails {
	@Id
	@GeneratedValue	
	private int id;
	private String adoptionList;
	private LocalDate adoptedDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Adopted adoptedBy;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<PetList> listOfPets;
	

	public AdoptionDetails(int id, String adoptionList, LocalDate adoptedDate, Adopted adoptedBy, List<PetList> listOfPets) {
		super();
		this.id = id;
		this.adoptedDate = adoptedDate;
		this.adoptedBy = adoptedBy;
		this.listOfPets = listOfPets;
	}
	
	
	public AdoptionDetails(String adoptionList, LocalDate adoptedDate, Adopted adoptedBy, List<PetList> listOfPets) {
		super();
		this.adoptedDate = adoptedDate;
		this.adoptedBy = adoptedBy;
		this.listOfPets = listOfPets;
	}
	
	public AdoptionDetails(String adoptionList, LocalDate adoptedDate, Adopted adoptedBy) {
		super();
		this.adoptedDate = adoptedDate;
		this.adoptedBy = adoptedBy;
	}



	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAdoptionList() {
		return adoptionList;
	}
	public void setAdoptionList(String adoptionList) {
		this.adoptionList = adoptionList;
	}
	
	public LocalDate getAdoptedDate() {
		return adoptedDate;
	}

	public void setAdoptedDate(LocalDate adoptedDate) {
		this.adoptedDate = adoptedDate;
	}
	
	public Adopted getAdoptedBy() {
		return adoptedBy;
	}
	public void setAdoptedBy(Adopted adoptedBy) {
		this.adoptedBy = adoptedBy;
	}
	
	public List<PetList> getListOfPets() {
		return listOfPets;
	}
	public void setListOfPets(List<PetList> listOfPets) {
		this.listOfPets = listOfPets;
	}

}
