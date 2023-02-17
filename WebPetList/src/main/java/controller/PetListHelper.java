package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PetList;

/**
 * @author stephaniesink - sisink CIS175 - Spring 2022 Feb 8, 2023
 */
public class PetListHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPetList");

	public void insertPet(PetList li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<PetList> showAllPets() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<PetList> allPets = em.createQuery("SELECT i from PetList i").getResultList();
		return allPets;

	}

	public void deletePet(PetList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetList> typedQuery = em.createQuery("select li from PetList li where li.animal = :selectedAnimal and li.breed = :selectedBreed", PetList.class);

		typedQuery.setParameter("selectedAnimal", toDelete.getAnimal());
		typedQuery.setParameter("selectedBreed", toDelete.getBreed());

		typedQuery.setMaxResults(1);

		PetList result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public PetList searchForPetById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		PetList found = em.find(PetList.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updatePet(PetList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<PetList> searchForPetByAnimal(String animalType) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetList> typedQuery = em.createQuery("select li from PetList li where li.animal = :selectedAnimal", PetList.class);
		
		typedQuery.setParameter("selectedAnimal", animalType);
		
		List<PetList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<PetList> searchForPetByBreed(String breedName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetList> typedQuery = em.createQuery("select li from PetList li where li.breed = :selectedBreed", PetList.class);
		
		typedQuery.setParameter("selectedBreed", breedName);
		
		List<PetList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
