package com.example.InterviewRatingApp.data.dao;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Data;

@Data
public class RatingVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDate date;
	
	private String company;
	private Double experience;
	private TechnologyVO java;
	private TechnologyVO spring;
	private TechnologyVO microservice;
	private TechnologyVO hibernate;
	private TechnologyVO database;
	private TechnologyVO agile;
	private TechnologyVO aws;
	private TechnologyVO communication;
	private String comments;
	private String status;
	

}
