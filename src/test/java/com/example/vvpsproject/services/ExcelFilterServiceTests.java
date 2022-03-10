package com.example.vvpsproject.services;

import com.example.vvpsproject.helpers.ExcelFilterTestHelper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExcelFilterServiceTests {

    @InjectMocks
    ExcelFilterService excelFilterService;

    @Autowired
    ExcelFilterTestHelper excelFilterTestHelper;

    @Test
    void shouldFindNUniqueDescriptions() {

        //GIVEN
        int expectedUniqueDescriptions = 460;

        //WHEN
        int actualUniqueDescriptions = excelFilterService.findUniqueDescriptions().size();

        //THEN
        assertEquals(expectedUniqueDescriptions, actualUniqueDescriptions);
    }

    @Test
    void shouldFind577UploadedFileEntries() {

        //GIVEN
        int expectedCount = 577;

        //WHEN
        int actualCount = excelFilterService.filterExcelForUploadedFilesEntries().size();

        //THEN
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void validateAverageValueOfUploadedFilesWhenCalculateAverageInvoked() {
        //GIVEN
        float expectedAverageValue = 4.5433073f;

        //WHEN
        float actualAverageValue = excelFilterService.calculateAverageValueOfUploadedFiles();

        //THEN
        assertEquals(expectedAverageValue, actualAverageValue);
    }

    @Test
    void validateScopeOfUploadedFilesWhenCalculateScopeInvoked() {

        //GIVEN
        float expectedScope = 9.0f;

        //WHEN
        float actualAverageScope = excelFilterService.calculateScopeOfUploadedFiles();

        //THEN
        assertEquals(expectedScope, actualAverageScope);
    }

    @Test
    void validateUniqueIdsWhenFindUniqueIdsInvoked() {

        //GIVEN
        Set<String> expectedUniqueIds = excelFilterTestHelper.buildUniqueIdsSet();

        //WHEN
        Set<String> actualUniqueIds = excelFilterService.findUniqueUserIds();

        //THEN
        assertEquals(expectedUniqueIds, actualUniqueIds);
    }

    @Test
    void validateAbsoluteFrequencyWhenCalculateAbsoluteFrequencyInvoked() {

        //GIVEN
        Map<String, Float> expectedAbsoluteFrequency = excelFilterTestHelper.buildAbsoluteFrequencyMap();

        //WHEN
        Map<String, Float> actualAbsoluteFrequency = excelFilterService.calculateAbsoluteFrequencyOfUploadedFiles();

        //THEN
        assertEquals(expectedAbsoluteFrequency, actualAbsoluteFrequency);
    }

    @Test
    void validateRelativeFrequencyWhenCalculateAbsoluteFrequencyInvoked() {

        //GIVEN
        Map<String, String> expectedRelativeFrequency = excelFilterTestHelper.buildRelativeFrequencyMap();

        //WHEN
        Map<String, String> actualRelativeFrequency = excelFilterService.calculateRelativeFrequencyOfUploadedFiles();

        //THEN
        assertEquals(expectedRelativeFrequency, actualRelativeFrequency);
    }
}
