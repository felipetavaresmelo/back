package com.xproject.master.app.dataprovider.mercadolivre.dto;

import java.util.List;
import lombok.Data;

@Data
public class AttributesItem{
	private String attributeGroupId;
	private String valueType;
	private List<ValuesItem> values;
	private String name;
	private String attributeGroupName;
	private String id;
	private Object valueId;
	private ValueStruct valueStruct;
	private String valueName;
}