package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author stephaniesink - sisink
 * CIS175 - Spring 2022
 * Feb 20, 2023
 */

@Entity
@Table(name = "adopted")
public class Adopted {
	@Id
	@GeneratedValue
	private int id; 
	private String adoptedBy;


	public Adopted() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Adopted(int id, String adoptedBy) {
		super();
		this.id = id;
		this.adoptedBy = adoptedBy;
	}

	
	public Adopted(String adoptedBy) {
		super();
		this.adoptedBy = adoptedBy;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdoptedBy() {
		return adoptedBy;
	}

	public void setAdoptedBy(String adoptedBy) {
		this.adoptedBy = adoptedBy;
	}

	@Override
	public String toString() {
		return "Adobted By: ID = " + id + "; NAME = " + adoptedBy;
	} 

}
