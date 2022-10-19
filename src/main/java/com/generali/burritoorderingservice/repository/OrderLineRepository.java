package com.generali.burritoorderingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generali.burritoorderingservice.entity.OrderLine;
import com.generali.burritoorderingservice.entity.Orders;


/**
 * @author Paul Ngouabeu
 * This interface maps the OrderLine model with the DB
 */
@Repository
public interface OrderLineRepository  extends JpaRepository<OrderLine, String>{
	
	/**
	 * This method find an OrderLine table for a given order
	 * @param Orders
	 * @return list of OrderLine 
	 */
	 @Query("select s from OrderLine s where s.orders=:order")
	 List<OrderLine> findAllOrderLine(@Param("order") Orders order);

}
