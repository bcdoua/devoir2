package com.douaa.accessoires.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.douaa.accessoires.entities.Accessoire;
import com.douaa.accessoires.entities.Couleur;

public interface AccessoireRepository extends JpaRepository<Accessoire, Long> {

    List<Accessoire> findByDesignation(String designation);
    List<Accessoire> findByDesignationContains(String designation);
    
    /*@Query("select a from Accessoire a where a.designation like %?1 and a.tarif > ?2")
    List<Accessoire> findByDesignationTarif(String designation, Double tarif);*/
    
    @Query("select a from Accessoire a where a.designation like %:designation% and a.tarif > :tarif")
    List<Accessoire> findByDesignationTarif(@Param("designation") String designation,@Param("tarif") Double tarif);
    
    @Query("select a from Accessoire a where a.couleur = ?1") 
    List<Accessoire> findByCouleur (Couleur couleur); 
    
    List<Accessoire> findByCouleurIdCoul(Long id); 
    
    List<Accessoire> findByOrderByDesignationAsc();
    
    @Query("select a from Accessoire a order by a.designation ASC, a.tarif DESC") 
    List<Accessoire> trierAccessoiresDesignationsTarif (); 
    
    

}
