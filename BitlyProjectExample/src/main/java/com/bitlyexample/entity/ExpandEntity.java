package com.bitlyexample.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ExpandEntity {
	@JsonProperty("bitlink_id")
private String bitlink_id;
}
