package com.generali.burritoorderingservice.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.generali.burritoorderingservice.constant.BurritoConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.generali.burritoorderingservice.dto.OrderLineDTO;
import com.generali.burritoorderingservice.entity.Extras;
import com.generali.burritoorderingservice.entity.OrderLine;
import com.generali.burritoorderingservice.entity.Orders;
import com.generali.burritoorderingservice.entity.Protein;
import com.generali.burritoorderingservice.entity.Salsa;
import com.generali.burritoorderingservice.entity.Tortilla;
import com.generali.burritoorderingservice.entity.Vegetables;
import com.generali.burritoorderingservice.exception.BurritoBusinessValidation;
import com.generali.burritoorderingservice.repository.OrderLineRepository;
import com.generali.burritoorderingservice.repository.OrderRepository;
import com.generali.burritoorderingservice.validation.IBurritoValidation;


@ExtendWith(MockitoExtension.class)
 public class BurritoServiceImplTest {

	private final static String ORDER_ID="921ca4e8-7925-4758-9ce5-6fa986a09535";

	@Mock
	private OrderRepository orderRepository;

	@Mock
	private OrderLineRepository orderLineRepository;

	@Mock
	private IBurritoValidation iBurritoValidation;

	@InjectMocks
	private BurritoServiceImpl  burritoServiceImpl;

	@Test
	void testCreateOrder() {
		OrderLineDTO order = line();
		List<OrderLineDTO> listOrder = new ArrayList<>();
		listOrder.add(order);
		List<OrderLine> line = burritoServiceImpl.createOrder(listOrder);
		assertThat(line).isNotNull();
	}

	@Test
	 void testGetOrders() {
		Mockito.when(orderRepository.findByOrderId(ORDER_ID)).thenReturn(Optional.of(new Orders()));
		List<OrderLine> orders= burritoServiceImpl.getOrders(ORDER_ID);
		assertThat(orders).isNotNull();
	}




	@Test
	 void testGetOrdersWithBurritoBusinessValidation() {
		BurritoBusinessValidation exception = Assertions.assertThrows(BurritoBusinessValidation.class, () -> {
			Mockito.when(orderRepository.findByOrderId(ORDER_ID)).thenThrow(new BurritoBusinessValidation("Exception message test", HttpStatus.NOT_FOUND));
			burritoServiceImpl.getOrders(ORDER_ID);
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
		OrderLineDTO orderDto = new OrderLineDTO(order);
		return orderDto;

	}

}
