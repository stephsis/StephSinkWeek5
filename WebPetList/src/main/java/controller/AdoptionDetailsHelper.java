package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AdoptionDetails;

/**
 * @author stephaniesink - sisink
 * CIS175 - Spring 2022
 * Feb 20, 2023
 */
public class AdoptionDetailsHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPetListWithAdopted");

	public void insertNewAdoptionDetails(AdoptionDetails a) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<AdoptionDetails> getPets(){
		EntityManager em = emfactory.createEntityManager();
		List<AdoptionDetails> allDetails = em.createQuery("SELECT d FROM AdoptionDetails d").getResultList();
		return allDetails;
	}
	
	public AdoptionDetails searchForAdoptionDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AdoptionDetails found = em.find(AdoptionDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteAdoption(AdoptionDetails toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AdoptionDetails> typedQuery = em.createQuery("SELECT detail from AdoptionDetails detail where detail.id= :selectedId", AdoptionDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		AdoptionDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateAdoption(AdoptionDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
