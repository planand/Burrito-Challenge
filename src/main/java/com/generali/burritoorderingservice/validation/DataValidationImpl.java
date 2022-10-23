package com.generali.burritoorderingservice.validation;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.generali.burritoorderingservice.constant.DataConstant;
import com.generali.burritoorderingservice.dto.OrderLineDTO;
import com.generali.burritoorderingservice.entity.Extras;
import com.generali.burritoorderingservice.entity.Protein;
import com.generali.burritoorderingservice.entity.Salsa;
import com.generali.burritoorderingservice.entity.Tortilla;
import com.generali.burritoorderingservice.entity.Vegetables;
import com.generali.burritoorderingservice.exception.DataValidationException;
import com.generali.burritoorderingservice.repository.ExtrasRepository;
import com.generali.burritoorderingservice.repository.ProteinRepository;
import com.generali.burritoorderingservice.repository.SalsaRepository;
import com.generali.burritoorderingservice.repository.TortillaRepository;
import com.generali.burritoorderingservice.repository.VegetablesRepository;


/**
 * @author Paul Ngouabeu
 * This class validates the user input and check if data exist in DB as unique
 *
 */
@Component
public class DataValidationImpl implements IDataValidation {

	private ExtrasRepository extrasRepository;

	private VegetablesRepository vegetablesRepository;

	private SalsaRepository salsaRepository;

	private ProteinRepository proteinRepository;

	private TortillaRepository tortillaRepository;

	public DataValidationImpl(ExtrasRepository extrasRepository, VegetablesRepository vegetablesRepository,
							  SalsaRepository salsaRepository, ProteinRepository proteinRepository,
							  TortillaRepository tortillaRepository) {
		this.extrasRepository = extrasRepository;
		this.vegetablesRepository = vegetablesRepository;
		this.salsaRepository = salsaRepository;
		this.proteinRepository = proteinRepository;
		this.tortillaRepository = tortillaRepository;
	}

	/**
	 * This method validates the Protein input.
	 * It checks if the the Protein is null or exist as unique
	 *@return - Protein
	 */
	@Override
	public Protein validateProtein(OrderLineDTO dto) {
		String protein = dto.getOrderLine().getProtein().getName();
		if (DataConstant.isNotNullOrEmpty(protein) ||
				!DataConstant.isValidChoice(Protein.Value.class, protein)) {
			throw new DataValidationException("Protein should be as follow" +
					Arrays.asList(Protein.Value.values()), HttpStatus.BAD_REQUEST);
		}

		Optional<Protein> pr = proteinRepository.findByCompleteName(protein);
		if (pr.isPresent()) {
			return pr.get();
		} else {
			throw new DataValidationException(
					dto.getOrderLine().getProtein().getName() + " dont exist in DB as Protein", HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * This method validates the Salsa input.
	 * It checks if the the Salsa is null or exist as unique
	 *@return - Salsa
	 */
	@Override
	public Salsa validateSalsa(OrderLineDTO dto) {
		if (DataConstant.isNotNullOrEmpty(dto.getOrderLine().getSalsa().getName()) ||
				!DataConstant.isValidChoice(Salsa.Value.class, dto.getOrderLine().getSalsa().getName())) {
			throw new DataValidationException("Salsa should be as follow:" +
					Arrays.asList(Salsa.Value.values()), HttpStatus.BAD_REQUEST);
		}

		Optional<Salsa> ex = salsaRepository.findByCompleteName(dto.getOrderLine().getSalsa().getName());
		if (ex.isPresent()) {
			return ex.get();
		} else {
			throw new DataValidationException(dto.getOrderLine().getSalsa().getName() + " dont exist in DB as Salsa",
					HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * This method validates the Tortilla input.
	 * It checks if the the Tortilla is null or exist as unique
	 *@return - Tortilla
	 */
	@Override
	public Tortilla validateTortilla(OrderLineDTO dto) {
		if (DataConstant.isNotNullOrEmpty(dto.getOrderLine().getTortilla().getName()) ||
				!DataConstant.isValidChoice(Tortilla.Value.class, dto.getOrderLine().getTortilla().getName())) {
			throw new DataValidationException("Tortilla should be as follow:" +
					Arrays.asList(Tortilla.Value.values()), HttpStatus.BAD_REQUEST);
		}

		Optional<Tortilla> to = tortillaRepository.findByCompleteName(dto.getOrderLine().getTortilla().getName());
		if (to.isPresent()) {
			return to.get();
		} else {
			throw new DataValidationException(
					dto.getOrderLine().getTortilla().getName() + " dont exist in DB as Tortilla",
					HttpStatus.BAD_REQUEST);
		}

	}
	
	/**
	 * This method validates the Extras input.
	 * It checks if the the Extras is zero or more 
	 *@param - OrderLineDTO
	 *@return - Extras
	 */
	@Override
	public Extras validateExtras(OrderLineDTO dto) {
		if (dto.getOrderLine().getExtras().getName().equalsIgnoreCase(null) ||
				dto.getOrderLine().getExtras().getName().equalsIgnoreCase("")) {
			return null;
		}
		if(!DataConstant.isValidChoice(Extras.Value.class, dto.getOrderLine().getExtras().getName())) {
			throw new DataValidationException("Extras can only be as follows:" +
					Arrays.asList(Extras.Value.values()), HttpStatus.BAD_REQUEST);
		}

		Optional<Extras> ex = extrasRepository.findByCompleteName(dto.getOrderLine().getExtras().getName());
		if (ex.isPresent()) {
			return ex.get();
		} else {
			throw new DataValidationException(
					dto.getOrderLine().getExtras().getName() + " dont exist in DB as Extras", HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * This method validates the vegetables input.
	 * It checks if the the vegetable is zero or more 
	 *@param - OrderLineDTO
	 *@return - Vegetables
	 */
	@Override
	public Vegetables validateVegetables(OrderLineDTO dto) {
		if (DataConstant.isNotNullOrEmpty(dto.getOrderLine().getVegetables().getName())) {
			return null;
		}

		if(!DataConstant.isValidChoice(Vegetables.Value.class, dto.getOrderLine().getVegetables().getName())) {
			throw new DataValidationException("Vegetables can only be as follows:" +
					Arrays.asList(Vegetables.Value.values()), HttpStatus.BAD_REQUEST);
		}

		Optional<Vegetables> ve = vegetablesRepository.findByCompleteName(dto.getOrderLine().getVegetables().getName());
		if (ve.isPresent()) {
			return ve.get();
		} else {
			throw new DataValidationException(
					dto.getOrderLine().getVegetables().getName() + " dont exist in DB as Vegetable",
					HttpStatus.BAD_REQUEST);
		}
	}

}
