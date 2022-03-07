package com.example.vvpsproject.controllers;

import com.example.vvpsproject.helpers.ExcelFilterTestHelper;
import com.example.vvpsproject.model.Response;
import com.example.vvpsproject.services.ExcelFilter;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.temporal.ChronoUnit;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentActivityControllerTests {

    @Mock
    ExcelFilter excelFilter = new ExcelFilter();

    @InjectMocks
    StudentActivityController studentActivityController;

    @Autowired
    ExcelFilterTestHelper excelFilterTestHelper;

    @Test
    void validateAbsoluteFrequencyOfUploadedFilesResponse() {

        //GIVEN
        ResponseEntity<Response> expectedResponse = excelFilterTestHelper.buildAbsoluteFrequencyResponse(excelFilter);

        //WHEN
        ResponseEntity<Response> actualResponse = studentActivityController.getAbsoluteFrequency();

        //THEN
        assertEquals(Objects.requireNonNull(expectedResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS),
                Objects.requireNonNull(actualResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS));
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getStatus(), actualResponse.getBody().getStatus());
        assertEquals(expectedResponse.getBody().getMessage(), actualResponse.getBody().getMessage());
        assertEquals(expectedResponse.getBody().getDescription(), actualResponse.getBody().getDescription());
        assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());

    }

    @Test
    void validateRelativeFrequencyOfUploadedFilesResponse() {

        //GIVEN
        ResponseEntity<Response> expectedResponse = excelFilterTestHelper.buildRelativeFrequencyResponse(excelFilter);

        //WHEN
        ResponseEntity<Response> actualResponse = studentActivityController.getRelativeFrequency();

        //THEN
        assertEquals(Objects.requireNonNull(expectedResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS),
                Objects.requireNonNull(actualResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS));
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getStatus(), actualResponse.getBody().getStatus());
        assertEquals(expectedResponse.getBody().getMessage(), actualResponse.getBody().getMessage());
        assertEquals(expectedResponse.getBody().getDescription(), actualResponse.getBody().getDescription());
        assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());

    }

    @Test
    void validateAverageValueOfUploadedFilesResponse() {

        //GIVEN
        ResponseEntity<Response> expectedResponse = excelFilterTestHelper.buildAverageValueOfUploadedFilesResponse(excelFilter);

        //WHEN
        ResponseEntity<Response> actualResponse = studentActivityController.getAverage();

        //THEN
        assertEquals(Objects.requireNonNull(expectedResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS),
                Objects.requireNonNull(actualResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS));
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getStatus(), actualResponse.getBody().getStatus());
        assertEquals(expectedResponse.getBody().getMessage(), actualResponse.getBody().getMessage());
        assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());

    }

    @Test
    void validateScopeOfUploadedFilesResponse() {

        //GIVEN
        ResponseEntity<Response> expectedResponse = excelFilterTestHelper.buildScopeValueOfUploadedFilesResponse(excelFilter);

        //WHEN
        ResponseEntity<Response> actualResponse = studentActivityController.getScope();

        //THEN
        assertEquals(Objects.requireNonNull(expectedResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS),
                Objects.requireNonNull(actualResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS));
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getStatus(), actualResponse.getBody().getStatus());
        assertEquals(expectedResponse.getBody().getMessage(), actualResponse.getBody().getMessage());
        assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());

    }

    @Test
    void validateUploadedFilesPerUserResponse() {

        //GIVEN
        ResponseEntity<Response> expectedResponse = excelFilterTestHelper.buildFilesUploadedPerUserResponse(excelFilter);

        //WHEN
        ResponseEntity<Response> actualResponse = studentActivityController.getFilesUploadedPerUser();

        //THEN
        assertEquals(Objects.requireNonNull(expectedResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS),
                Objects.requireNonNull(actualResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS));
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getStatus(), actualResponse.getBody().getStatus());
        assertEquals(expectedResponse.getBody().getMessage(), actualResponse.getBody().getMessage());
        assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());

    }

    @Test
    void validateFileUploadedEntriesResponse() {

        //GIVEN
        ResponseEntity<Response> expectedResponse = excelFilterTestHelper.buildFilesUploadedEntries(excelFilter);

        //WHEN
        ResponseEntity<Response> actualResponse = studentActivityController.getFileUploadedEntries();

        //THEN
        assertEquals(Objects.requireNonNull(expectedResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS),
                Objects.requireNonNull(actualResponse.getBody()).getTimeStamp().truncatedTo(ChronoUnit.HOURS));
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getStatus(), actualResponse.getBody().getStatus());
        assertEquals(expectedResponse.getBody().getMessage(), actualResponse.getBody().getMessage());
        assertEquals(expectedResponse.getBody().getData(), actualResponse.getBody().getData());

    }

}
