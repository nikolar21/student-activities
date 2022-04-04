package com.example.vvpsproject.controllers;

import com.example.vvpsproject.helpers.ExcelFilterTestHelper;
import com.example.vvpsproject.models.Response;
import com.example.vvpsproject.services.ExcelFilterService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentActivityControllerTests {

  @Mock ExcelFilterService excelFilter = new ExcelFilterService();

  @InjectMocks StudentActivityController studentActivityController;

  @Autowired ExcelFilterTestHelper excelFilterTestHelper;

  @Test
  void validateAbsoluteFrequencyOfUploadedFilesResponse() {

    ResponseEntity<Response> expectedResponse =
        excelFilterTestHelper.buildAbsoluteFrequencyResponse(excelFilter);

    ResponseEntity<Response> actualResponse = studentActivityController.getAbsoluteFrequency();

    assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    assertEquals(expectedResponse.getStatusCodeValue(), actualResponse.getStatusCodeValue());
    assertEquals(
        Objects.requireNonNull(expectedResponse.getBody()).getMessage(),
        Objects.requireNonNull(actualResponse.getBody()).getMessage());
    assertEquals(
        expectedResponse.getBody().getDescription(), actualResponse.getBody().getDescription());
    assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());
  }

  @Test
  void validateRelativeFrequencyOfUploadedFilesResponse() {

    ResponseEntity<Response> expectedResponse =
        excelFilterTestHelper.buildRelativeFrequencyResponse(excelFilter);

    ResponseEntity<Response> actualResponse = studentActivityController.getRelativeFrequency();

    assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    assertEquals(expectedResponse.getStatusCodeValue(), actualResponse.getStatusCodeValue());
    assertEquals(
        Objects.requireNonNull(expectedResponse.getBody()).getMessage(),
        Objects.requireNonNull(actualResponse.getBody()).getMessage());
    assertEquals(
        expectedResponse.getBody().getDescription(), actualResponse.getBody().getDescription());
    assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());
  }

  @Test
  void validateAverageValueOfUploadedFilesResponse() {

    ResponseEntity<Response> expectedResponse =
        excelFilterTestHelper.buildAverageValueOfUploadedFilesResponse(excelFilter);

    ResponseEntity<Response> actualResponse = studentActivityController.getAverage();

    assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    assertEquals(expectedResponse.getStatusCodeValue(), actualResponse.getStatusCodeValue());
    assertEquals(
        Objects.requireNonNull(expectedResponse.getBody()).getMessage(),
        Objects.requireNonNull(actualResponse.getBody()).getMessage());
    assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());
  }

  @Test
  void validateScopeOfUploadedFilesResponse() {

    ResponseEntity<Response> expectedResponse =
        excelFilterTestHelper.buildScopeValueOfUploadedFilesResponse(excelFilter);

    ResponseEntity<Response> actualResponse = studentActivityController.getScope();

    assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    assertEquals(expectedResponse.getStatusCodeValue(), actualResponse.getStatusCodeValue());
    assertEquals(
        Objects.requireNonNull(expectedResponse.getBody()).getMessage(),
        Objects.requireNonNull(actualResponse.getBody()).getMessage());
    assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());
  }

  @Test
  void validateUploadedFilesPerUserResponse() {

    ResponseEntity<Response> expectedResponse =
        excelFilterTestHelper.buildFilesUploadedPerUserResponse(excelFilter);

    ResponseEntity<Response> actualResponse = studentActivityController.getFilesUploadedPerUser();

    assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    assertEquals(expectedResponse.getStatusCodeValue(), actualResponse.getStatusCodeValue());
    assertEquals(
        Objects.requireNonNull(expectedResponse.getBody()).getMessage(),
        Objects.requireNonNull(actualResponse.getBody()).getMessage());
    assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());
  }

  @Test
  void validateFileUploadedEntriesResponse() {

    ResponseEntity<Response> expectedResponse =
        excelFilterTestHelper.buildFilesUploadedEntries(excelFilter);

    ResponseEntity<Response> actualResponse = studentActivityController.getFileUploadedEntries();

    assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    assertEquals(expectedResponse.getStatusCodeValue(), actualResponse.getStatusCodeValue());
    assertEquals(
        Objects.requireNonNull(expectedResponse.getBody()).getMessage(),
        Objects.requireNonNull(actualResponse.getBody()).getMessage());
    assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());
  }
}
