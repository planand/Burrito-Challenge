package com.generali.burritoorderingservice.service;

import java.util.List;

import com.generali.burritoorderingservice.dto.OrderLineDTO;
import com.generali.burritoorderingservice.entity.OrderLine;

public interface IDataService {
	
	public List<OrderLine>  createOrder(List<OrderLineDTO> orderLineDTO);

	
	public List<OrderLine> getOrders(String id);
	   
	 

}
