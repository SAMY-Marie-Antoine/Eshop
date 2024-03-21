package eshop.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;
import eshop.model.Produit;


public class Test {

	public static void main(String[] args) {
	
		Produit produit=new Produit("Cosmétique",200);

		Client c1 = new Client("Potter","Harry", 20,LocalDate.parse("2024-03-21"), new Adresse("2","rue de paris","75000","paris"));
		Fournisseur f1 = new Fournisseur("Demort","Vol", "BMW",new Adresse("2","rue de melun","77000","melun"));
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(c1);
		em.persist(f1);
		em.persist(produit);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
