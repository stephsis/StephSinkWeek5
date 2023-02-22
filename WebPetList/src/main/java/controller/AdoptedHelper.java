package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Adopted;

/**
 * @author stephaniesink - sisink
 * CIS175 - Spring 2022
 * Feb 20, 2023
 */
public class AdoptedHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebPetListWithAdopted");

	public void insertAdopted(Adopted a) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Adopted> showAllAdopted(){
		EntityManager em = emfactory.createEntityManager();
		List<Adopted> allAdopted = em.createQuery("SELECT a from Adopted a").getResultList();
		return allAdopted;
	}
	
	public Adopted findAdopted(String adoptionToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Adopted> typedQuery = em.createQuery("select sh from Shopper sh where sh.shopperName = :selectedName",Adopted.class);
		typedQuery.setParameter("selectedName", adoptionToLookUp);
		typedQuery.setMaxResults(1);
		Adopted foundAdopted;
		try {
			foundAdopted = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundAdopted = new Adopted(adoptionToLookUp);
		}
		em.close();

		return foundAdopted;
	}

}
