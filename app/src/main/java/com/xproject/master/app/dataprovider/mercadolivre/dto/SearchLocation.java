package com.xproject.master.app.dataprovider.mercadolivre.dto;

import lombok.Data;

@Data
public class SearchLocation{
	private City city;
	private Neighborhood neighborhood;
	private State state;
}