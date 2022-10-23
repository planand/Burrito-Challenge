package com.poc.dataService.service;

import java.util.List;

import com.poc.dataService.dto.OrderLineDTO;
import com.poc.dataService.entity.OrderLine;

public interface IDataService {
	
	List<OrderLine>  createOrder(List<OrderLineDTO> orderLineDTO);

	
	List<OrderLine> getOrders(String id);
	   
	 

}
