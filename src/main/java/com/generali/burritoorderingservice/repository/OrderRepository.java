package com.generali.burritoorderingservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generali.burritoorderingservice.entity.Orders;


/**
 * @author Paul Ngouabeu
 * This interface maps the Orders model with the DB
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders, String>{
	
	/**
	 * This method find an Orders  for a given id
	 * @param id
	 * @return Orders
	 */
	@Query("select o from Orders o where o.id=:id")
    Optional<Orders> findByOrderId(@Param("id") String id);

}
