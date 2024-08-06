package com.readingCToExcel.readingCSVToExcel;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;



@Data
public class Customer {

    @CsvBindByName(column = "CUSTOMER_NAME")
    @Column(nullable = false)
    private String name;

    @CsvBindByName(column = "customer_code")
    private String customerCode;

    @CsvBindByName
    private String pan;

    @CsvBindByName
    private String mobile;

    @CsvBindByName
    private String email;

    @CsvBindByName(column="DateOfBirth" )
    @CsvDate(value = "dd-MM-yyyy")
    private LocalDate birthDate;
    
}
