package com.example.vvpsproject.controllers;

import com.example.vvpsproject.models.Response;
import com.example.vvpsproject.services.ExcelFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("api/v1/students/activities")
@RequiredArgsConstructor
public class StudentActivityController {

    private final ExcelFilterService excelFilter;

    @GetMapping("/filter/uploaded-files")
    public ResponseEntity<Response> getFileUploadedEntries() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("events", excelFilter.filterExcelForUploadedFilesEntries()))
                        .message("All entries with event name 'A file has been uploaded'.")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/filter/uploaded-files-per-user")
    public ResponseEntity<Response> getFilesUploadedPerUser() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("events", excelFilter.calculateAbsoluteFrequencyOfUploadedFiles()))
                        .message("Files uploaded per user.")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/filter/frequency/absolute")
    public ResponseEntity<Response> getAbsoluteFrequency() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("events", excelFilter.calculateAbsoluteFrequencyOfUploadedFiles()))
                        .message("Absolute frequency for uploaded files for all users.")
                        .description("Absolute frequency results are represented in two columns - " +
                                "left column represents user id and right column represents" +
                                " frequency of uploaded files per each user.")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/filter/frequency/relative")
    public ResponseEntity<Response> getRelativeFrequency() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("events", excelFilter.calculateRelativeFrequencyOfUploadedFiles()))
                        .message("Relative frequency for uploaded files for all users.")
                        .description("Relative frequency results are represented in two columns - " +
                                "left column represents user id and right column represents" +
                                " frequency of uploaded files per each user.")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/filter/average")
    public ResponseEntity<Response> getAverage() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("average value", excelFilter.calculateAverageValueOfUploadedFiles()))
                        .message("Average value of all uploaded files!")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/filter/scope")
    public ResponseEntity<Response> getScope() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("scope", excelFilter.calculateScopeOfUploadedFiles()))
                        .message("Scope of uploaded files for all users")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
