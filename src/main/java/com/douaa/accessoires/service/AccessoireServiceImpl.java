package com.douaa.accessoires.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.douaa.accessoires.entities.Accessoire;
import com.douaa.accessoires.entities.Couleur;
import com.douaa.accessoires.repos.AccessoireRepository;

@Service
public class AccessoireServiceImpl implements AccessoireService{
	
	@Autowired
	AccessoireRepository accessoireRepository;

	@Override
	public Accessoire saveAccessoire(Accessoire a) {
		return accessoireRepository.save(a);
	}

	@Override
	public Accessoire updateAccessoire(Accessoire a) {
		return accessoireRepository.save(a);
	}

	@Override
	public void deleteAccessoire(Accessoire a) {
		accessoireRepository.delete(a);
		
	}

	@Override
	public void deleteAccessoireById(Long id) {
		accessoireRepository.deleteById(id);
	}

	@Override
	public Accessoire getAccessoire(Long id) {
		return accessoireRepository.findById(id).get();
	}

	@Override
	public List<Accessoire> getAllAccessoires() {
		return accessoireRepository.findAll();
	}
	@Override
	public List<Accessoire> findByDesignation(String designation) {
		return accessoireRepository.findByDesignation(designation);
	}

	@Override
	public List<Accessoire> findByDesignationContains(String designation) {
		return accessoireRepository.findByDesignationContains(designation);
	}

	@Override
	public List<Accessoire> findByDesignationTarif(String designation, Double tarif) {
		return accessoireRepository.findByDesignationTarif(designation,tarif);
	}

	@Override
	public List<Accessoire> findByCouleur(Couleur couleur) {
		return accessoireRepository.findByCouleur(couleur);
	}

	@Override
	public List<Accessoire> findByCouleurIdCoul(Long id) {
		return accessoireRepository.findByCouleurIdCoul(id);
	}

	@Override
	public List<Accessoire> findByOrderByDesignationAsc() {
		return accessoireRepository.findByOrderByDesignationAsc();
	}

	@Override
	public List<Accessoire> trierAccessoiresDesignationsTarif() {
		return accessoireRepository.trierAccessoiresDesignationsTarif();
	}

}
