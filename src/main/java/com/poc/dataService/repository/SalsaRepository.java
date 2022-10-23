package com.poc.dataService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poc.dataService.entity.Salsa;

/**
 * @author Paul Ngouabeu
 * This interface maps the Salsa model with the DB
 */
@Repository
public interface SalsaRepository extends JpaRepository<Salsa, String>{
	
	/**
	 * This method find an Salsa table for a given name
	 * @param name
	 * @return Salsa
	 */
	@Query("select s from Salsa s where s.name=:name")
	 Optional<Salsa> findByCompleteName(@Param("name") String name);

}
