package com.ptit.qlns.model;

import java.io.Serializable;

import javax.validation.constraints.*;

public class Position implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min=2 , max = 50, message="Size must be between 2 and 50 letters")
	private String name;
	
	private String description;
	
	private int id;
	
	
	public Position() {
		super();
	}

	public Position(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
