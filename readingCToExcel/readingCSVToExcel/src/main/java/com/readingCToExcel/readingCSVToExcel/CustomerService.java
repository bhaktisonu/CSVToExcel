package com.readingCToExcel.readingCSVToExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CustomerService {


    public static void writeExcel(SXSSFWorkbook wb, SXSSFSheet customerSheet, Iterator<Customer> customerIterator) {
        List<String> headers = new ArrayList<>(
                Arrays.asList("Customer Code", "Customer Name", "PAN", "Contact", "Email"));
        int rowNum = 0;
        int colNum = 0;
        Row row = customerSheet.createRow(rowNum);

        CellStyle cellStyle = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        cellStyle.setFont(font);

        for (String header : headers) {
            Cell cell = row.createCell(colNum++);
            cell.setCellValue(header);
            cell.setCellStyle(cellStyle);
        }

        while(customerIterator.hasNext()) {

            Customer customer = customerIterator.next();
            row = customerSheet.createRow(++rowNum);
            row.createCell(0).setCellValue(customer.getCustomerCode());
            row.createCell(1).setCellValue(customer.getName());
            row.createCell(2).setCellValue(customer.getPan());
            row.createCell(3).setCellValue(customer.getMobile());
            row.createCell(4).setCellValue(customer.getEmail());
        }

        customerSheet.setColumnWidth(0, 4000);
        customerSheet.setColumnWidth(1, 4000);
        customerSheet.setColumnWidth(2, 4000);
        customerSheet.setColumnWidth(3, 4000);
        customerSheet.setColumnWidth(4, 4000);
    }

}
