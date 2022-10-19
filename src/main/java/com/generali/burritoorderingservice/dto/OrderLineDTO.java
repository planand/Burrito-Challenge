package com.generali.burritoorderingservice.dto;



import com.generali.burritoorderingservice.entity.OrderLine;

import lombok.Data;
import lombok.NoArgsConstructor;

//annotation helps to generate a no-argument constructor
@NoArgsConstructor
//annotation helps to generate a constructor with 1 parameter for each field in the class
@Data
public class OrderLineDTO {

	private OrderLine orderLine;
	
	
	public OrderLineDTO (OrderLine orderLine) {
		this.orderLine=orderLine;
	}

}
