package com.poc.dataService.service;


import com.poc.dataService.dto.OrderLineDTO;
import com.poc.dataService.entity.*;
import com.poc.dataService.exception.DataValidationException;
import com.poc.dataService.repository.OrderLineRepository;
import com.poc.dataService.repository.OrderRepository;
import com.poc.dataService.validation.IDataValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
 public class DataServiceImplTest {

	private final static String ORDER_ID="921ca4e8-7925-4758-9ce5-6fa986a09535";

	@Mock
	private OrderRepository orderRepository;

	@Mock
	private OrderLineRepository orderLineRepository;

	@Mock
	private IDataValidation iDataValidation;

	@InjectMocks
	private DataServiceImpl dataServiceImpl;

	@Test
	void testCreateOrder() {
		OrderLineDTO order = line();
		List<OrderLineDTO> listOrder = new ArrayList<>();
		listOrder.add(order);
		List<OrderLine> line = dataServiceImpl.createOrder(listOrder);
		assertThat(line).isNotNull();
	}

	@Test
	 void testGetOrders() {
		Mockito.when(orderRepository.findByOrderId(ORDER_ID)).thenReturn(Optional.of(new Orders()));
		List<OrderLine> orders= dataServiceImpl.getOrders(ORDER_ID);
		assertThat(orders).isNotNull();
	}




	@Test
	 void testGetOrdersWithDataBusinessValidation() {
		DataValidationException exception = Assertions.assertThrows(DataValidationException.class, () -> {
			Mockito.when(orderRepository.findByOrderId(ORDER_ID)).thenThrow(new DataValidationException("Exception message test", HttpStatus.NOT_FOUND));
			dataServiceImpl.getOrders(ORDER_ID);
	  });

	  Assertions.assertEquals("Exception message test", exception.getMessage());

	}

	private OrderLineDTO line() {

		OrderLine order = new OrderLine();

		Extras ex = new Extras();
		ex.setId(ORDER_ID);
		ex.setName("avocado");
		order.setExtras(ex);

		Orders or = new Orders();
		or.setId(ORDER_ID);
		order.setOrders(or);

		Protein po = new Protein();
		po.setId(ORDER_ID);
		po.setName("bean");
		order.setProtein(po);

		Salsa sa = new Salsa();
		sa.setId(ORDER_ID);
		sa.setName("hot");
		order.setSalsa(sa);

		Tortilla to = new Tortilla();
		to.setId(ORDER_ID);
		to.setName("corn");
		order.setTortilla(to);

		Vegetables ve = new Vegetables();
		ve.setId(ORDER_ID);
		ve.setName("cabbage");
		order.setVegetables(ve);
		return new OrderLineDTO(order);

	}

}
