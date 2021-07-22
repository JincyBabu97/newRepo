package com.example.InterviewRatingApp.data.dao;

import java.io.Serializable;

import lombok.Data;

@Data
public class TechnologyVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double ratings;
	private String comment;

}
