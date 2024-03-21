package eshop.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne{
	
	@Column(name="company",length = 50)
	private String societe;
	
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
