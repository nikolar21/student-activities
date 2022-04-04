package com.example.vvpsproject.controllers;

import com.example.vvpsproject.models.Response;
import com.example.vvpsproject.services.ExcelFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static java.util.Map.of;

@Controller
@RequestMapping("api/v1/students/activities")
@RequiredArgsConstructor
public class StudentActivityController {

  private final ExcelFilterService excelFilter;

  @GetMapping("/filter/uploaded-files")
  public ResponseEntity<Response> getFileUploadedEntries() {
    return ResponseEntity.ok(
        Response.builder()
            .data(of("values", excelFilter.filterExcelForUploadedFilesEntries()))
            .message("All entries with event name 'A file has been uploaded'.")
            .build());
  }

  @GetMapping("/filter/uploaded-files-per-user")
  public ResponseEntity<Response> getFilesUploadedPerUser() {
    return ResponseEntity.ok(
        Response.builder()
            .data(of("values", excelFilter.calculateAbsoluteFrequencyOfUploadedFiles()))
            .message("Files uploaded per user.")
            .build());
  }

  @GetMapping("/filter/frequency/absolute")
  public ResponseEntity<Response> getAbsoluteFrequency() {
    return ResponseEntity.ok(
        Response.builder()
            .data(of("values", excelFilter.calculateAbsoluteFrequencyOfUploadedFiles()))
            .message("Absolute frequency for uploaded files for all users.")
            .description(
                "Absolute frequency results are represented in two columns - "
                    + "left column represents user id and right column represents"
                    + " frequency of uploaded files per each user.")
            .build());
  }

  @GetMapping("/filter/frequency/relative")
  public ResponseEntity<Response> getRelativeFrequency() {
    return ResponseEntity.ok(
        Response.builder()
            .data(of("values", excelFilter.calculateRelativeFrequencyOfUploadedFiles()))
            .message("Relative frequency for uploaded files for all users.")
            .description(
                "Relative frequency results are represented in two columns - "
                    + "left column represents user id and right column represents"
                    + " frequency of uploaded files per each user.")
            .build());
  }

  @GetMapping("/filter/average")
  public ResponseEntity<Response> getAverage() {
    return ResponseEntity.ok(
        Response.builder()
            .data(of("average value", excelFilter.calculateAverageValueOfUploadedFiles()))
            .message("Average value of all uploaded files.")
            .build());
  }

  @GetMapping("/filter/scope")
  public ResponseEntity<Response> getScope() {
    return ResponseEntity.ok(
        Response.builder()
            .data(of("scope", excelFilter.calculateScopeOfUploadedFiles()))
            .message("Scope of uploaded files for all users.")
            .build());
  }
}
