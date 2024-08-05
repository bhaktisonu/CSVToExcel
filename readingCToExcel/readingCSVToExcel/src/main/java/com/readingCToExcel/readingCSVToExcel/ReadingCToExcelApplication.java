package com.readingCToExcel.readingCSVToExcel;

import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Iterator;

import static java.lang.System.out;

@SpringBootApplication
public class ReadingCToExcelApplication {

	public static void main(String[] args) {

	CustomerService customerService = new CustomerService();

		File file = new File("D:\\Recon Files\\New folder\\customerMasterTemplate1.csv");

		try (FileReader reader = new FileReader(file.getAbsoluteFile())) {

			Iterator<Customer> customerIterator = new CsvToBeanBuilder<Customer>(reader)
					.withType(Customer.class)
					.build()
					.iterator();

			SXSSFWorkbook wb;
			wb = new SXSSFWorkbook();

			SXSSFSheet customerSheet = wb.createSheet();
			customerService.writeExcel(wb,customerSheet,customerIterator);
			try (FileOutputStream out = new FileOutputStream("D:\\Recon Files\\New folder\\customerList.xlsx", true)) {
				wb.write(out);
			}

			out.println ("File created successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}




}
