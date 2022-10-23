package com.poc.dataService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poc.dataService.entity.Vegetables;



/**
 * @author Paul Ngouabeu
 * This interface maps the Vegetables model with the DB
 */
@Repository
public interface VegetablesRepository extends JpaRepository<Vegetables, String>{
	
	
	/**
	 * This method find an Vegetables table for a given name
	 * @param name
	 * @return Vegetables
	 */
	@Query("select v from Vegetables v where v.name=:name")
    Optional<Vegetables> findByCompleteName(@Param("name") String name);

}
