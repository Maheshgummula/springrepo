package com.nsdl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PanCard {
	@JsonProperty("pan_number")
	private String PanNumber;

	public String getPanNumber() {
		return PanNumber;
	}

	public void setPanNumber(String panNumber) {
		PanNumber = panNumber;
	}

}
