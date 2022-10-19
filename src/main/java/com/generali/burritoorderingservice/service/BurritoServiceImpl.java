package com.generali.burritoorderingservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.generali.burritoorderingservice.constant.BurritoConstant;
import com.generali.burritoorderingservice.dto.OrderLineConverter;
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

/**
 * @author Paul Ngouabeu
 * This class holds the logic of creating the orders in DB.
 */
@Transactional
@Service
public class BurritoServiceImpl implements IBurritoService {

	private OrderRepository orderRepository;

	private OrderLineRepository orderLineRepository;

	private IBurritoValidation iBurritoValidation;

	public BurritoServiceImpl(OrderRepository orderRepository, OrderLineRepository orderLineRepository,
			IBurritoValidation iBurritoValidation) {
		this.orderRepository = orderRepository;
		this.orderLineRepository = orderLineRepository;
		this.iBurritoValidation = iBurritoValidation;
	}

	
	/**
	 * This method returns the list order entered by the user
	 * @param - OrderLineDTO
	 * @return - OrderLine
	 *
	 */
	@Override
	public List<OrderLine> createOrder(List<OrderLineDTO> orderLineDTO) {

		List<OrderLine> theListOrder = new ArrayList<>();
		Orders order = new Orders();
		OrderLineConverter cons = new OrderLineConverter();
		order.setId(BurritoConstant.getUUID());
		Set<OrderLine> orderList = new HashSet<>();
		OrderLine line = cons.convertFromDto(orderLineDTO.get(0));
		orderList.add(line);
		order.setOrderLines(orderList);
		orderRepository.save(order);
		
		for (OrderLineDTO dto : orderLineDTO) {
			Extras extras = iBurritoValidation.validateExtras(dto);
			Vegetables vegetables = iBurritoValidation.validateVegetables(dto);
			Protein protein = iBurritoValidation.validateProtein(dto);
			Salsa salsa = iBurritoValidation.validateSalsa(dto);
			Tortilla tortilla = iBurritoValidation.validateTortilla(dto);
			line.setTortilla(tortilla);
			line.setSalsa(salsa);
			line.setProtein(protein);
			line.setExtras(extras);
			line.setVegetables(vegetables);
			line.setId(BurritoConstant.getUUID());
			line.setOrders(order);
			theListOrder.add(orderLineRepository.save(line));
		}
		return theListOrder;
	}
	
	/**
	 * This method returns the list order for given order id
	 * @param - order id
	 * @return - OrderLine List
	 *
	 */
	@Override
	public List<OrderLine> getOrders(String id) {
		
		Optional<Orders> order = orderRepository.findByOrderId(id);
		if(order.isPresent()) {
			List<OrderLine> orders = orderLineRepository.findAllOrderLine(order.get());
			return orders;
		} else {
			throw new BurritoBusinessValidation(id + " doesn't exist in DB as Order",
					HttpStatus.NOT_FOUND);
		}
	}

}
