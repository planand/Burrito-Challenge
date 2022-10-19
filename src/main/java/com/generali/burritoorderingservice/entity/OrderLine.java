package com.generali.burritoorderingservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//annotation helps to generate a no-argument constructor
@NoArgsConstructor
//annotation helps to generate a constructor with 1 parameter for each field in the class
@AllArgsConstructor
//annotation helps to implement the builder design pattern
//spring stereotype annotation
@Entity
@Getter
@Setter
@Table(name="OrderLine")
public class OrderLine extends AbstractId{
	

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	    @OneToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name = "extras_id", nullable = true, referencedColumnName = "id")
	    private Extras extras;
	    
	    @OneToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name = "vegetables_id", referencedColumnName = "id")
	    private Vegetables vegetables;
	    
	    @OneToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name = "salsa_id", referencedColumnName = "id")
	    private Salsa salsa;
	    
	    @OneToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name = "tortilla_id", referencedColumnName = "id")
	    private Tortilla tortilla;
	    
	    @OneToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name = "protein_id", referencedColumnName = "id")
	    private Protein protein;
	    
	    @JsonIgnore
	    @ManyToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name = "orders_id", referencedColumnName = "id")
	    private Orders orders;
	    
	    public OrderLine(Orders orders, Extras extras, Tortilla tortilla, Protein protein, Salsa salsa, Vegetables vegetables) {
	    	this.orders=orders;
			this.extras=extras;
			this.tortilla=tortilla;
			this.protein=protein;
			this.salsa=salsa;
			this.vegetables=vegetables;
		}
	
}
