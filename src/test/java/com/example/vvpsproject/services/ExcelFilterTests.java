package com.example.vvpsproject.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExcelFilterTests {


    @InjectMocks
    ExcelFilter excelFilter;

    @Test
    void shouldCount577Entries() {

        //GIVEN
        int expectedCount = 577;

        //WHEN
        int actualCount = excelFilter.filterExcelForUploadedFilesEntries().size();

        //THEN
        assertEquals(expectedCount, actualCount);
    }
}
