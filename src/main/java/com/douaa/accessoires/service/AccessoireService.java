package com.douaa.accessoires.service;

import java.util.List;

import com.douaa.accessoires.entities.Accessoire;
import com.douaa.accessoires.entities.Couleur;

public interface AccessoireService {
	Accessoire saveAccessoire(Accessoire a);
	Accessoire updateAccessoire(Accessoire a);
	void deleteAccessoire(Accessoire a);
	void deleteAccessoireById(Long id);
	Accessoire getAccessoire(Long id);
	List<Accessoire> getAllAccessoires();
	List<Accessoire> findByDesignation(String designation); 
	List<Accessoire> findByDesignationContains(String designation); 
	List<Accessoire> findByDesignationTarif (String designation, Double tarif); 
	List<Accessoire> findByCouleur (Couleur couleur); 
	List<Accessoire> findByCouleurIdCoul(Long id); 
	List<Accessoire> findByOrderByDesignationAsc(); 
	List<Accessoire> trierAccessoiresDesignationsTarif();
}
