package eshop.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;
import eshop.model.Produit;


public class Test {

	public static void main(String[] args) {
	
		

		Client c1 = new Client("Potter","Harry", 20,LocalDate.parse("2024-03-21"), new Adresse("2","rue de paris","75000","paris"));
		Fournisseur f1 = new Fournisseur("Demort","Vol", "BMW",new Adresse("2","rue de melun","77000","melun"));
		
		Produit produit=new Produit("Cosmétique",200);
		Produit produit2=new Produit("cahier",400);
		
				
		produit.setFournisseur(f1);
		c1.getAchat().add(produit);
		c1.getAchat().add(produit2);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(c1);
		em.persist(f1);
		em.persist(produit);
		em.persist(produit2);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
