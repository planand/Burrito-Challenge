package com.poc.dataService.dto;

import com.poc.dataService.entity.OrderLine;

public class OrderLineConverter extends Converter<OrderLineDTO, OrderLine> {

	  public OrderLineConverter() {
	    super(OrderLineConverter::convertToEntity, OrderLineConverter::convertToDto);
	  }

	  private static OrderLineDTO convertToDto(OrderLine orderLine) {
	    return new OrderLineDTO(orderLine);
	  }

	  private static OrderLine convertToEntity(OrderLineDTO dto) {
	    return new OrderLine(dto.getOrderLine().getOrders(),dto.getOrderLine().getExtras(), dto.getOrderLine().getTortilla(), dto.getOrderLine().getProtein(), dto.getOrderLine().getSalsa(),dto.getOrderLine().getVegetables());
	  }

	

}
