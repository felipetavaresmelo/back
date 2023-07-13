package com.xproject.master.app.dataprovider.mercadolivre.dto;

import lombok.Data;

@Data
public class SellerAddress{
	private Country country;
	private SearchLocation searchLocation;
	private City city;
	private State state;
	private Integer id;
}