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

  @InjectMocks ExcelFilterService excelFilterService;

  @Autowired ExcelFilterTestHelper excelFilterTestHelper;

  @Test
  void validateAverageValueOfUploadedFilesWhenCalculateAverageInvoked() {

    float expectedAverageValue = 4.5433073f;

    float actualAverageValue = excelFilterService.calculateAverageValueOfUploadedFiles();

    assertEquals(expectedAverageValue, actualAverageValue);
  }

  @Test
  void validateScopeOfUploadedFilesWhenCalculateScopeInvoked() {

    float expectedScope = 9.0f;

    float actualAverageScope = excelFilterService.calculateScopeOfUploadedFiles();

    assertEquals(expectedScope, actualAverageScope);
  }

  @Test
  void shouldFindNUniqueDescriptions() {

    int expectedUniqueDescriptions = 460;

    int actualUniqueDescriptions = excelFilterService.findUniqueDescriptions().size();

    assertEquals(expectedUniqueDescriptions, actualUniqueDescriptions);
  }

  @Test
  void shouldFind577UploadedFileEntries() {

    int expectedCount = 577;

    int actualCount = excelFilterService.filterExcelForUploadedFilesEntries().size();

    assertEquals(expectedCount, actualCount);
  }

  @Test
  void validateUniqueIdsWhenFindUniqueIdsInvoked() {

    Set<String> expectedUniqueIds = excelFilterTestHelper.buildUniqueIdsSet();

    Set<String> actualUniqueIds = excelFilterService.findUniqueUserIds();

    assertEquals(expectedUniqueIds, actualUniqueIds);
  }

  @Test
  void validateAbsoluteFrequencyWhenCalculateAbsoluteFrequencyInvoked() {

    Map<String, Float> expectedAbsoluteFrequency =
        excelFilterTestHelper.buildAbsoluteFrequencyMap();

    Map<String, Float> actualAbsoluteFrequency =
        excelFilterService.calculateAbsoluteFrequencyOfUploadedFiles();

    assertEquals(expectedAbsoluteFrequency, actualAbsoluteFrequency);
  }

  @Test
  void validateRelativeFrequencyWhenCalculateAbsoluteFrequencyInvoked() {

    Map<String, String> expectedRelativeFrequency =
        excelFilterTestHelper.buildRelativeFrequencyMap();

    Map<String, String> actualRelativeFrequency =
        excelFilterService.calculateRelativeFrequencyOfUploadedFiles();

    assertEquals(expectedRelativeFrequency, actualRelativeFrequency);
  }
}
