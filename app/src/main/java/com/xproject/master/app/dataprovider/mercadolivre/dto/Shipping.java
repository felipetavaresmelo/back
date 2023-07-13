package com.xproject.master.app.dataprovider.mercadolivre.dto;

import java.util.List;
import lombok.Data;

@Data
public class Shipping{
	private String mode;
	private Boolean freeShipping;
	private List<Object> methods;
	private Boolean localPickUp;
	private List<String> tags;
	private Object dimensions;
	private String logisticType;
	private Boolean storePickUp;
}