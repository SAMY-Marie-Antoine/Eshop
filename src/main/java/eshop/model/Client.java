package eshop.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne{
	
	private int age;
	
	private LocalDate dateNaissance;
		
	public Client() {}
	

	public Client(String nom,String prenom,int age, LocalDate dateNaissance, Adresse adresse) {
		super(nom,prenom,adresse);
		this.age = age;
		this.dateNaissance = dateNaissance;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [age=" + age + ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", id=" + id
				+ ", nom=" + nom + ", prenom=" + prenom + "]";
	}


	
	
	

}
