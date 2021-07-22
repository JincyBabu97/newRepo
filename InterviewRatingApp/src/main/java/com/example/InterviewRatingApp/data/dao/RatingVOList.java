package com.example.InterviewRatingApp.data.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RatingVOList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<RatingVO> rationgVOList = new ArrayList<RatingVO>();
}
