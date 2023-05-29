package com.example.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Parola;

@Repository
public interface ParolaDAO extends JpaRepository<Parola, Integer>{
	
	@Query(value = "SELECT AVG(conteggio_caratteri) AS avg_caratteri_parola FROM ( SELECT LENGTH(testo_parola) AS conteggio_caratteri FROM parola ) AS conteggio_tabella;", nativeQuery = true)    
	double getNumeroMedioCaratteriPerParola();
	
	@Query(value = "SELECT MAX(conteggio_caratteri) AS caratteri_parola_piu_lunga FROM (SELECT LENGTH(testo_parola) AS conteggio_caratteri FROM parola) AS conteggio_tabella;", nativeQuery = true)	 
	int getNumeroCaratteriParolaPiuLunga();

	@Query(value = "SELECT MIN(conteggio_caratteri) AS caratteri_parola_piu_corta FROM (SELECT LENGTH(testo_parola) AS conteggio_caratteri FROM parola) AS conteggio_tabella;", nativeQuery = true)	 
	int getNumeroCaratteriParolaPiuCorta();
	 
	@Query(value = "SELECT AVG(numero_parole) AS media_parole_per_frase FROM (SELECT COUNT(*) AS numero_parole FROM parola GROUP BY frase_fk_id) AS conteggio_parole;", nativeQuery = true)	 
	double getNumeroMedioParolePerFrase();
	 
	@Query(value = "SELECT testo_parola FROM parola WHERE LENGTH(testo_parola) = (SELECT MAX(LENGTH(testo_parola)) FROM parola );", nativeQuery = true)	 
	ArrayList<String> getContenutoParolaPiuLunga();

	@Query(value = "SELECT testo_parola FROM parola WHERE LENGTH(testo_parola) = (SELECT MIN(LENGTH(testo_parola)) FROM parola );", nativeQuery = true)	 
	ArrayList<String> getContenutoParolaPiuBreve();
	 
	@Query(value = "SELECT COUNT(*) AS numero_parole FROM parola;", nativeQuery = true)	 
	int getNumeroParole();
	

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE parola AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
