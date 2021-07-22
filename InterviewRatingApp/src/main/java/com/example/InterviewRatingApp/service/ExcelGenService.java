package com.example.InterviewRatingApp.service;

import java.io.ByteArrayInputStream;

public interface ExcelGenService {

	ByteArrayInputStream exportToExcel(String str);

}
