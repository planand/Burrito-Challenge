package com.poc.dataService.dto;

import java.util.function.Function;


/**
 * @author Paul Ngouabeu
 *This class serves as converter between Entity and DTO
 * @param <T>
 * @param <U>
 */
public class Converter<T, U> {

	  private final Function<T, U> fromDto;
	  private final Function<U, T> fromEntity;

	  public Converter(final Function<T, U> fromDto, final Function<U, T> fromEntity) {
	    this.fromDto = fromDto;
	    this.fromEntity = fromEntity;
	  }



	/**
	 * This method takes a DTO and return an entity
	 * @param dto
	 * @return an entity
	 */
	public final U convertFromDto(final T dto) {
	    return fromDto.apply(dto);
	  }

	/**
	 * This method takes a Entity and return an DTO
	 * @param entity
	 * @return a  dto
	 */
	  public final T convertFromEntity(final U entity) {
	    return fromEntity.apply(entity);
	  }

	
	}
