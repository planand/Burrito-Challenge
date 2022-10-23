package com.generali.burritoorderingservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generali.burritoorderingservice.dto.OrderLineDTO;
import com.generali.burritoorderingservice.entity.OrderLine;
import com.generali.burritoorderingservice.service.IDataService;

@RestController
@RequestMapping("/orders")
public class DataController {
	
	
	private IDataService iDataService;
	
	public DataController(IDataService iDataService) {
		this.iDataService = iDataService;
	}
	
	

    /**
     * Handles requests to create a order.
     */
    @PostMapping
    public ResponseEntity<List<OrderLine>> create( @RequestBody List<OrderLineDTO> orderLineDTO){
    	 return new ResponseEntity<>(iDataService.createOrder(orderLineDTO), HttpStatus.CREATED);
   
    }
    
    
    /**
     * Handles requests to show a order.
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<OrderLine>> show(@PathVariable String id) {
    	return new ResponseEntity<>(iDataService.getOrders(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Health Check OK",HttpStatus.OK);
    }

}
