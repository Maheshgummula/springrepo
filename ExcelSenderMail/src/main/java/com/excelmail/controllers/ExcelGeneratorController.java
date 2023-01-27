package com.excelmail.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.ListUtils;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelmail.entity.RequiredData;
import com.excelmail.service.ExcelGenerator;

@RestController
public class ExcelGeneratorController {

	@PostMapping("/posting")
	public ResponseEntity<?> postdata(@RequestBody RequiredData data) {
		List<String> headers = new ArrayList<String>();
		JSONObject object = new JSONObject();
		object.put("Info", data.getData());
		object.put("headers", data.getColumnNames());
		for (String keys : data.getColumnNames().keySet()) {
			String ob = data.getColumnNames().get(keys);
			headers.add(ob);
		}
		ArrayList<String> list=new ArrayList<>();
		List<Map<String, Object>> maps=(List<Map<String, Object>>) object.get("Info");
		for(Map<String, Object> datas:maps)
		{
			Set<String> keys=datas.keySet();
			Iterator<String> it=keys.iterator();
			while (it.hasNext()) {
				String itr =  it.next();
				list.add((String)datas.get(itr));
			}
		}

		List<List<String>> listOfData = ListUtils.partition(list, headers.size());
//		List<List<String>> listOfData=data.getData();
		//creating the object of Excel Generator Class
		ExcelGenerator generator = new ExcelGenerator();
		//calling the method which create the excel file
		generator.excelCreator(listOfData, headers, data.getFilename());
		return new ResponseEntity<Object>(data, HttpStatus.OK);
	}

}
