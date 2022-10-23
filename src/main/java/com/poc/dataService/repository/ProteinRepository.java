package com.poc.dataService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poc.dataService.entity.Protein;

/**
 * @author Paul Ngouabeu
 * This interface maps the Protein model with the DB
 */
@Repository
public interface ProteinRepository extends JpaRepository<Protein, String>{
	
	/**
	 * This method find an Protein table for a given name
	 * @param name
	 * @return Protein
	 */
	@Query("select p from Protein p where p.name=:name")
    Optional<Protein> findByCompleteName(@Param("name") String name);

}
