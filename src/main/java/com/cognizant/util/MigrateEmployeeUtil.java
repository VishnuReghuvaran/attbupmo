package com.cognizant.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.Empinfodao;
import com.cognizant.model.Employee;
import com.cognizant.model.Project;
import com.cognizant.model.User;
import com.google.gson.Gson;

@Component
public class MigrateEmployeeUtil {

	Logger LOGGER = LogManager.getLogger(MigrateEmployeeUtil.class.getName());

	@Autowired
	Empinfodao empinfodao;

	public Object importEmployee(String path) {
		InputStream excelFileToRead = null;
		int cellCount = 0;
		int rowCount = 0;
		int rowNumber = 0;
		try {
			excelFileToRead = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook(excelFileToRead);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row;
		HSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext()) {
			row = (HSSFRow) rows.next();
			if (rowNumber != 0) {
				rowCount++;
				cellCount = 0;
				Iterator cells = row.cellIterator();
				Employee employee = new Employee();
				Project project = new Project();
				while (cells.hasNext()) {
					cell = (HSSFCell) cells.next();
					cellCount++;
					LOGGER.debug("Cell Number "+cellCount);
					employee.setPrj_assignments(new ArrayList<Project>());
					employee.getPrj_assignments().add(project);
					if (cellCount == 4 &&  cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						project.setPrjId(cell.getStringCellValue().trim());
					}else if(cellCount == 4 &&  cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
						String id = String.valueOf(cell.getNumericCellValue());
						project.setPrjId(id.trim().substring(0, id.indexOf(".")));					
					} else if (cellCount == 5) {
						project.setPrjName(cell.getStringCellValue().trim());
					} else if (cellCount == 7 && cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						employee.setEmpid(cell.getStringCellValue());
					} else if (cellCount == 7 && cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
						String name = String.valueOf(cell.getNumericCellValue());
						employee.setEmpid(name.trim().substring(0, name.indexOf(".")));
					} else if (cellCount == 8) {
						employee.setEmpname(cell.getStringCellValue().trim());
					} else if (cellCount == 9 && cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
					} else if (cellCount == 9 && cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					} else if (cellCount == 10) {
						employee.setMngrName(cell.getStringCellValue().trim());
					} else if (cellCount == 11 && cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
					} else if (cellCount == 11 && cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					} else if (cellCount == 12) {
					} else if (cellCount == 13) {
						employee.setDesignation(cell.getStringCellValue().trim());
					} else if (cellCount == 16) {
					}
					employee.setAddressLine1("");
					employee.setAddressLine2("");
					employee.setAttId("");
					employee.setCiaComplianceDate("");
					employee.setNicComplianceDate("");
					employee.setSignature("");
					/*
					 * if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
					 * System.out.print(cell.getStringCellValue()+" "); } else
					 * if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					 * System.out.print(cell.getNumericCellValue()+" "); } else
					 * { //U Can Handel Boolean, Formula, Errors }
					 */
				}
				Gson gson = new Gson();
				LOGGER.debug("\n");
				LOGGER.debug("Employee Json" + gson.toJson(employee));
				if(employee!=null && employee.getEmpid()!=null){					
				empinfodao.insertEmployee(employee);
				LOGGER.debug("Employee JSON inserted");
				}else{
					LOGGER.debug("Skipping employee onject as empId is null");
				}
			}
			LOGGER.debug("Row Number "+rowNumber);
			rowNumber++;
		}
		LOGGER.debug("Total Number of Rows " + rowCount);
		return rowCount;
	}

	public String createUser(String path) {
		InputStream excelFileToRead = null;
		int cellCount = 0;
		int rowCount = 0;
		int rowNumber = 0;
		try {
			excelFileToRead = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook(excelFileToRead);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row;
		HSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext()) {
			row = (HSSFRow) rows.next();

			rowCount++;
			cellCount = 0;
			Iterator cells = row.cellIterator();
			User user = new User();

			while (cells.hasNext()) {
				cell = (HSSFCell) cells.next();
				cellCount++;

				String passwordString = RandomStringUtils.randomAlphabetic(8);
				user.setPassword(passwordString);

				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
					user.setUsername(cell.getStringCellValue());
				}
				if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					String id = String.valueOf(cell.getNumericCellValue());
					user.setUsername(id.trim().substring(0, id.indexOf(".")));
				}
			}
			Gson gson = new Gson();
			LOGGER.debug("\n");
			LOGGER.debug("User Json" + gson.toJson(user));
			empinfodao.insertUser(user);

			rowNumber++;
		}
        return String.valueOf(rowNumber);
	}
}
