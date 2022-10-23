package com.poc.dataService.validation;

import com.poc.dataService.dto.OrderLineDTO;
import com.poc.dataService.entity.Extras;
import com.poc.dataService.entity.Protein;
import com.poc.dataService.entity.Salsa;
import com.poc.dataService.entity.Tortilla;
import com.poc.dataService.entity.Vegetables;

public interface IDataValidation {
	Protein validateProtein(OrderLineDTO dto);

	Salsa validateSalsa(OrderLineDTO dto);

	Tortilla validateTortilla(OrderLineDTO dto);

	Extras validateExtras(OrderLineDTO dto);

	Vegetables validateVegetables(OrderLineDTO dto);

}
