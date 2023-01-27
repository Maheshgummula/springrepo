package com.bitlyexample.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RequestForShorten {
	
@JsonProperty("long_url")
private String long_url;

@JsonProperty("domain")
private String domain;

@JsonProperty("group_guid")
private String group_guid;

}
