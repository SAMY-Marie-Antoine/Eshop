package eshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne{
	
	@Column(name="company",length = 50)
	private String societe;
	
	@OneToMany(mappedBy = "fournisseur")
	private List<Produit> stock = new ArrayList();
	
	public List<Produit> getStock() {
		return stock;
	}

	public void setStock(List<Produit> stock) {
		this.stock = stock;
	}

	public Fournisseur() {}

	public Fournisseur(String nom,String prenom,String societe, Adresse adresse) {
		super(nom,prenom,adresse);
		this.societe = societe;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	@Override
	public String toString() {
		return "Fournisseur [societe=" + societe + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse="
				+ adresse + "]";
	}
	
	

}
