package com.generali.burritoorderingservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//annotation helps to generate a no-argument constructor
@NoArgsConstructor
//annotation helps to generate a constructor with 1 parameter for each field in the class
@AllArgsConstructor
//annotation helps to implement the builder design pattern
//spring stereotype annotation
@ToString
@MappedSuperclass
public abstract class AbstractEntity extends AbstractId implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "name")
	protected String name;

}
