package com.generali.burritoorderingservice.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table
public class Vegetables extends AbstractEntity{
	 
	private static final long serialVersionUID = 1L;

	public enum Value {cabbage, corn, jalapenos}

}
