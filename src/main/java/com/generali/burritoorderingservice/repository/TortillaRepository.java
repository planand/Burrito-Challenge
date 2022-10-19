package com.generali.burritoorderingservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generali.burritoorderingservice.entity.Tortilla;


/**
 * @author Paul Ngouabeu
 * This interface maps the Tortilla model with the DB
 */
@Repository
public interface TortillaRepository extends JpaRepository<Tortilla, String>{
	
	/**
	 * This method find an Tortilla table for a given name
	 * @param name
	 * @return Tortilla
	 */
	 @Query("select t from Tortilla t where t.name=:name")
	 Optional<Tortilla> findByCompleteName(@Param("name") String name);

}
