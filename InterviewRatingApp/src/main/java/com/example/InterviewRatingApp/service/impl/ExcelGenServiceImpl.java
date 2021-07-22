package com.example.InterviewRatingApp.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.InterviewRatingApp.constants.RatingExcelConstants;
import com.example.InterviewRatingApp.data.dao.RatingVO;
import com.example.InterviewRatingApp.service.ExcelGenService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ExcelGenServiceImpl implements ExcelGenService{

	private static final String EXCEL_SHEET = "Candidate Rating";
	
	@Override
	public ByteArrayInputStream exportToExcel(String str) {
		
		String[] headers = {"Name", "Date", "Company", "Experience", "Java",
				"Spring", "Microservice", "Hibernate", "Database", "Agile",
				"AWS", "Communication", "Comments", "Status"};
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet(EXCEL_SHEET);
		Row headerRow = sheet.createRow(0);
		// header
			for (int col = 0; col < headers.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(headers[col]);
			}
			
		//for loop for VO
			Row row = sheet.createRow(1);
			ObjectMapper mapper = new ObjectMapper();
			mapper.findAndRegisterModules();
			try {
				List<RatingVO> ratingVOList = mapper.readValue(RatingExcelConstants.str,  new TypeReference<List<RatingVO>>(){});
				System.out.println(ratingVOList);
			} catch (JsonMappingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//if (null != corridor.getCorridorName()) {
				//row.createCell(0).setCellValue(corridor.getCorridorName());
			//}
			//end of for loop
		//sheet.setAutoFilter(new CellRangeAddress(firstCell.getRow(), lastCell.getRow(), firstCell.getCol(), lastCell.getCol()));
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			wb.write(os);
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error while downloading Excel file");
		}

		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

		return is;
	}

}
