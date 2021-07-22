package com.example.InterviewRatingApp.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InterviewRatingApp.constants.RatingExcelConstants;
import com.example.InterviewRatingApp.service.ExcelGenService;

@RestController
@RequestMapping("rating")
@CrossOrigin(origins ="*")
public class ExcelGenController {
	
	@Autowired
	ExcelGenService excelGenService;
	
	public static String EXCEL_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public static String CACHE_CONTROL = "must-revalidate, post-check=0, pre-check=0";
	public static String FILE_NAME = "attachment; filename=InterviewRating.xlsx";

	@GetMapping("/downloadExcel")
	public ResponseEntity<Resource> downloadRating() throws Exception{
		
		ByteArrayInputStream is = excelGenService.exportToExcel(RatingExcelConstants.str);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(EXCEL_TYPE));
		headers.setCacheControl(CACHE_CONTROL);
		headers.set(HttpHeaders.CONTENT_DISPOSITION, FILE_NAME);
		ResponseEntity<Resource> response = new ResponseEntity<Resource>(new InputStreamResource(is), headers, HttpStatus.OK);
		return response;
		
	}
}
;