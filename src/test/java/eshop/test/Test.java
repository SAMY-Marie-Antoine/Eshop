package eshop.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Personne;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
		Personne personne =new Personne("KING", "Blacker");
		Produit produit=new Produit("Cosmétique",200);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(personne);
		em.persist(produit);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
