package com.generali.burritoorderingservice.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//annotation helps to generate a no-argument constructor
@NoArgsConstructor
//annotation helps to generate a constructor with 1 parameter for each field in the class
@AllArgsConstructor
//annotation helps to implement the builder design pattern
//spring stereotype annotation
@Getter
@Setter
@ToString
@Entity
@Table
public class Orders extends AbstractId{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
	  private Set<OrderLine> orderLines;

}
