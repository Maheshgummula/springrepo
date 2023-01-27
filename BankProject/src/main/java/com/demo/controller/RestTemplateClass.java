package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestTemplateClass {
	@Autowired
	RestTemplateController controller;

	@GetMapping("/verifying")
	public String verify(Model model) {
		ResponseEntity<String> entity = controller.getExternal();
		if (entity.getStatusCode() == HttpStatus.valueOf(200)) {
			String msg = "verification Succesful";
			model.addAttribute("Message", msg);
			return "DefaultWelcome";
		} else {
			return "AccessDenied";

		}
	}

}
