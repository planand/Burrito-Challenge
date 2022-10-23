package com.generali.burritoorderingservice.validation;

import com.generali.burritoorderingservice.dto.OrderLineDTO;
import com.generali.burritoorderingservice.entity.Extras;
import com.generali.burritoorderingservice.entity.Protein;
import com.generali.burritoorderingservice.entity.Salsa;
import com.generali.burritoorderingservice.entity.Tortilla;
import com.generali.burritoorderingservice.entity.Vegetables;

public interface IDataValidation {
	public Protein validateProtein(OrderLineDTO dto);

	public Salsa validateSalsa(OrderLineDTO dto);

	public Tortilla validateTortilla(OrderLineDTO dto);

	public Extras validateExtras(OrderLineDTO dto);

	public Vegetables validateVegetables(OrderLineDTO dto);

}
