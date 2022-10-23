package com.poc.dataService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//lombok annotations
//annotation helps to generate toString(), equals(), hashcode(), getter(), setter()
@Data
//annotation helps to generate a no-argument constructor
@NoArgsConstructor
//annotation helps to generate a constructor with 1 parameter for each field in the class
@AllArgsConstructor
//annotation helps to implement the builder design pattern
//spring stereotype annotation
@ToString
@MappedSuperclass
public class AbstractId implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

		@Id
	    @Column(updatable = false)
		@JsonIgnore
	    protected String id;
		
	   
}
