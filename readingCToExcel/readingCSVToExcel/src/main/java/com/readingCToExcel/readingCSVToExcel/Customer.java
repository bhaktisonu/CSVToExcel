package com.readingCToExcel.readingCSVToExcel;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import javax.persistence.Column;

@Data
public class Customer {

    @CsvBindByName(column = "CUSTOMER_NAME")
    @Column(nullable = false)
    private String name;

    @CsvBindByName(column = "customer_code")
    private String customerCode;

    @CsvBindByName
    @Column
    private String pan;

    @CsvBindByName
    private String mobile;

    @CsvBindByName
    private String email;
}
