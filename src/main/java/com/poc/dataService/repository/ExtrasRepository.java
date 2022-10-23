package com.poc.dataService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poc.dataService.entity.Extras;



/**
 * @author Paul Ngouabeu
 * This interface maps the Extras model with the DB
 */
@Repository
public interface ExtrasRepository  extends JpaRepository<Extras, String>{
	
	/**
	 * This method find an Extras table for a given name
	 * @param name
	 * @return Extras
	 */
	@Query("select e from Extras e where e.name=:name")
    Optional<Extras> findByCompleteName(@Param("name") String name);

}
