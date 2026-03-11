package com.douaa.accessoires.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.Max; 
import jakarta.validation.constraints.Min; 
import jakarta.validation.constraints.NotNull; 
import jakarta.validation.constraints.Size; 
import jakarta.validation.constraints.PastOrPresent;


@Entity
public class Accessoire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeAcc;
	
	@NotNull
	@Size (min = 4,max = 15) 
	private String designation;
	
	@Min(value = 10) 
	@Max(value = 10000) 
	private Double tarif;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent 
	private Date dateAjout;
	
	@ManyToOne
	private Couleur couleur;
	
	public Accessoire() {
		super();
	}
	
	public Accessoire(String designation, Double tarif, Date dateAjout) {
		super();
		this.designation = designation;
		this.tarif = tarif;
		this.dateAjout = dateAjout;
	}

	public Long getCodeAcc() {
		return codeAcc;
	}
	public void setCodeAcc(Long codeAcc) {
		this.codeAcc = codeAcc;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getTarif() {
		return tarif;
	}
	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	@Override
	public String toString() {
	    return "Accessoire [codeAcc=" + codeAcc +", designation=" + designation 
	    		+", tarif=" + tarif +", dateAjout=" + dateAjout +"]";
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	
}
