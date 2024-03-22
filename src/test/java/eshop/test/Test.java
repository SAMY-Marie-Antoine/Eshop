package eshop.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import eshop.model.Achat;
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
		produit2.setFournisseur(f1);
		
		/*
		 * Modifier la classe Fournisseur : ajouter List<Produit> stock 
		 * Modifier la classe Produit : ajouter List<Achat> ventes 
		 * Ajouter les mappedBy pour n'avoir QUE les tables suivantes : product, person, achat

		 */
		//Dans le main, ne plus utiliser client.getAchats().add(produit) 
		//=> creer des objets Achat et les persist (em.persist() pour insert) à la place 
		
		Achat achat1 = new Achat(10, c1, produit);
		Achat achat2 = new Achat(12, c1, produit2);
		
		c1.getAchats().add(achat1);
         c1.getAchats().add(achat2);
		//List<Achat> lproduit = new ArrayList();
		//lproduit.add(achat2);
		//lproduit.add(achat1);
		
		//c1.setAchats(lproduit);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(c1);
		em.persist(f1);
		em.persist(produit);
		em.persist(produit2);
		em.persist(achat1);
		em.persist(achat2);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
