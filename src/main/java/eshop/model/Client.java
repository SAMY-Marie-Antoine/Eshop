package eshop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.mapping.Array;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne{

	private int age;

	private LocalDate dateNaissance;

	
	@OneToMany(mappedBy = "client")
	/*@JoinTable(name = "achats",
	joinColumns = @JoinColumn(name="acheteur"),
	inverseJoinColumns = @JoinColumn(name="produit")
	)
	*/
	//Modifier la classe Client :
	//List<Produit> achats => List<Achat> achats (conserver le @JoinTable) 
	
	//private List<Produit> achat=new ArrayList();
	private List<Achat> achats=new ArrayList();


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
	
	//public List<Produit> getAchat() {
	//	return achat;
	//}


	//public void setAchat(List<Produit> achat) {
	//	this.achat = achat;
	//}
	
	
	public List<Achat> getAchats() {
		return achats;
	}


	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	@Override
	public String toString() {
		return "Client [age=" + age + ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", id=" + id
				+ ", nom=" + nom + ", prenom=" + prenom + "]";
	}






}
