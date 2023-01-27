package com.excelgenerator.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredData {
	String filename;
	Map<String, String> columnNames;
//	List<List<String>> data;
	Object data;

}
