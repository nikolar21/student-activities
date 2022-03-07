package com.example.vvpsproject.helpers;

import com.example.vvpsproject.model.Response;
import com.example.vvpsproject.services.ExcelFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@Component
public class ExcelFilterTestHelper {

    public ResponseEntity<Response> buildAbsoluteFrequencyResponse(ExcelFilter excelFilter) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("events", excelFilter.calculateAbsoluteFrequencyOfUploadedFiles()))
                        .message("Absolute frequency for uploaded files for all users.")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    public ResponseEntity<Response> buildRelativeFrequencyResponse(ExcelFilter excelFilter) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("events", excelFilter.calculateRelativeFrequencyOfUploadedFiles()))
                        .message("Relative frequency for uploaded files for all users.")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    public ResponseEntity<Response> buildAverageValueOfUploadedFilesResponse(ExcelFilter excelFilter) {
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

    public ResponseEntity<Response> buildScopeValueOfUploadedFilesResponse(ExcelFilter excelFilter) {
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

    public ResponseEntity<Response> buildFilesUploadedPerUserResponse(ExcelFilter excelFilter) {
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

    public ResponseEntity<Response> buildFilesUploadedEntries(ExcelFilter excelFilter) {
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

    public Set<String> buildUniqueIdsSet() {
        Set<String> uniqueIds = Set.of("8376", "8377", "8410", "8374", "8375", "8413", "8414", "8411", "8378", "8412",
                "8373", "8406", "7954", "8407", "7953", "8404", "8408", "8409", "8387", "8420", "8421", "8388", "8385",
                "8386", "8424", "8425", "8422", "8389", "8423", "8380", "8383", "8384", "8381", "8382", "8417", "8418",
                "8415", "8019", "8416", "8419", "8431", "8398", "8399", "8432", "8396", "8397", "8430", "8435", "8436",
                "8433", "8434", "8390", "8391", "8394", "8395", "8392", "8393", "8428", "8429", "8426", "8427", "8442",
                "8443", "8440", "8441", "8446", "8447", "8444", "8445", "7907", "7909", "8439", "8437", "8438", "8453",
                "8454", "8451", "8452", "8457", "8458", "8455", "8456", "8450", "7918", "7917", "7919", "7910", "8448",
                "7912", "8449", "7911", "7914", "7913", "7916", "7915", "8465", "7930", "7929", "7928", "7921", "8459",
                "7925", "7924", "7927", "7941", "7939", "7932", "7931", "7934", "7933", "7936", "7935", "7938", "8402",
                "7950", "8403", "8400", "7952", "8401", "8483", "7943", "7942", "7945", "7944", "7947", "7946", "7948");
        return uniqueIds;
    }

    public Map<String, Float> buildAbsoluteFrequencyMap() {
        Map<String, Float> absoluteFrequencyMap = Map.ofEntries(
                Map.entry("8376", 8.0f),
                Map.entry("8377", 5.0f),
                Map.entry("8410", 4.0f),
                Map.entry("8374", 6.0f),
                Map.entry("8375", 6.0f),
                Map.entry("8413", 8.0f),
                Map.entry("8414", 9.0f),
                Map.entry("8411", 7.0f),
                Map.entry("8378", 7.0f),
                Map.entry("8412", 7.0f),
                Map.entry("8373", 7.0f),
                Map.entry("8406", 9.0f),
                Map.entry("7954", 2.0f),
                Map.entry("8407", 7.0f),
                Map.entry("7953", 2.0f),
                Map.entry("8404", 7.0f),
                Map.entry("8408", 7.0f),
                Map.entry("8409", 4.0f),
                Map.entry("8387", 8.0f),
                Map.entry("8420", 8.0f),
                Map.entry("8421", 7.0f),
                Map.entry("8388", 6.0f),
                Map.entry("8385", 4.0f),
                Map.entry("8386", 5.0f),
                Map.entry("8424", 8.0f),
                Map.entry("8425", 4.0f),
                Map.entry("8422", 10.0f),
                Map.entry("8389", 5.0f),
                Map.entry("8423", 7.0f),
                Map.entry("8380", 6.0f),
                Map.entry("8383", 9.0f),
                Map.entry("8384", 1.0f),
                Map.entry("8381", 5.0f),
                Map.entry("8382", 4.0f),
                Map.entry("8417", 5.0f),
                Map.entry("8418", 3.0f),
                Map.entry("8415", 4.0f),
                Map.entry("8019", 1.0f),
                Map.entry("8416", 5.0f),
                Map.entry("8419", 7.0f),
                Map.entry("8431", 4.0f),
                Map.entry("8398", 5.0f),
                Map.entry("8399", 7.0f),
                Map.entry("8432", 6.0f),
                Map.entry("8396", 3.0f),
                Map.entry("8397", 9.0f),
                Map.entry("8430", 3.0f),
                Map.entry("8435", 5.0f),
                Map.entry("8436", 6.0f),
                Map.entry("8433", 3.0f),
                Map.entry("8434", 3.0f),
                Map.entry("8390", 6.0f),
                Map.entry("8391", 6.0f),
                Map.entry("8394", 7.0f),
                Map.entry("8395", 7.0f),
                Map.entry("8392", 6.0f),
                Map.entry("8393", 8.0f),
                Map.entry("8428", 7.0f),
                Map.entry("8429", 3.0f),
                Map.entry("8426", 8.0f),
                Map.entry("8427", 9.0f),
                Map.entry("8442", 8.0f),
                Map.entry("8443", 6.0f),
                Map.entry("8440", 6.0f),
                Map.entry("8441", 3.0f),
                Map.entry("8446", 6.0f),
                Map.entry("8447", 8.0f),
                Map.entry("8444", 9.0f),
                Map.entry("8445", 9.0f),
                Map.entry("7907", 1.0f),
                Map.entry("7909", 2.0f),
                Map.entry("8439", 8.0f),
                Map.entry("8437", 4.0f),
                Map.entry("8438", 5.0f),
                Map.entry("8453", 3.0f),
                Map.entry("8454", 6.0f),
                Map.entry("8451", 5.0f),
                Map.entry("8452", 5.0f),
                Map.entry("8457", 7.0f),
                Map.entry("8458", 5.0f),
                Map.entry("8455", 7.0f),
                Map.entry("8456", 6.0f),
                Map.entry("8450", 5.0f),
                Map.entry("7918", 1.0f),
                Map.entry("7917", 2.0f),
                Map.entry("7919", 1.0f),
                Map.entry("7910", 1.0f),
                Map.entry("8448", 7.0f),
                Map.entry("7912", 1.0f),
                Map.entry("8449", 8.0f),
                Map.entry("7911", 1.0f),
                Map.entry("7914", 1.0f),
                Map.entry("7913", 1.0f),
                Map.entry("7916", 1.0f),
                Map.entry("7915", 1.0f),
                Map.entry("8465", 6.0f),
                Map.entry("7930", 1.0f),
                Map.entry("7929", 1.0f),
                Map.entry("7928", 1.0f),
                Map.entry("7921", 1.0f),
                Map.entry("8459", 6.0f),
                Map.entry("7925", 1.0f),
                Map.entry("7924", 1.0f),
                Map.entry("7927", 2.0f),
                Map.entry("7941", 2.0f),
                Map.entry("7939", 1.0f),
                Map.entry("7932", 1.0f),
                Map.entry("7931", 1.0f),
                Map.entry("7934", 1.0f),
                Map.entry("7933", 1.0f),
                Map.entry("7936", 1.0f),
                Map.entry("7935", 2.0f),
                Map.entry("7938", 2.0f),
                Map.entry("8402", 4.0f),
                Map.entry("7950", 1.0f),
                Map.entry("8403", 3.0f),
                Map.entry("8400", 8.0f),
                Map.entry("7952", 2.0f),
                Map.entry("8401", 6.0f),
                Map.entry("8483", 6.0f),
                Map.entry("7943", 2.0f),
                Map.entry("7942", 2.0f),
                Map.entry("7945", 1.0f),
                Map.entry("7944", 1.0f),
                Map.entry("7947", 1.0f),
                Map.entry("7946", 2.0f),
                Map.entry("7948", 1.0f));

        return absoluteFrequencyMap;
    }

    public Map<String, String> buildRelativeFrequencyMap() {
        Map<String, String> relativeFrequencyMap = Map.ofEntries(
                Map.entry("8376", "1.39%"),
                Map.entry("8377", "0.87%"),
                Map.entry("8410", "0.69%"),
                Map.entry("8374", "1.04%"),
                Map.entry("8375", "1.04%"),
                Map.entry("8413", "1.39%"),
                Map.entry("8414", "1.56%"),
                Map.entry("8411", "1.21%"),
                Map.entry("8378", "1.21%"),
                Map.entry("8412", "1.21%"),
                Map.entry("8373", "1.21%"),
                Map.entry("8406", "1.56%"),
                Map.entry("7954", "0.35%"),
                Map.entry("8407", "1.21%"),
                Map.entry("7953", "0.35%"),
                Map.entry("8404", "1.21%"),
                Map.entry("8408", "1.21%"),
                Map.entry("8409", "0.69%"),
                Map.entry("8387", "1.39%"),
                Map.entry("8420", "1.39%"),
                Map.entry("8421", "1.21%"),
                Map.entry("8388", "1.04%"),
                Map.entry("8385", "0.69%"),
                Map.entry("8386", "0.87%"),
                Map.entry("8424", "1.39%"),
                Map.entry("8425", "0.69%"),
                Map.entry("8422", "1.73%"),
                Map.entry("8389", "0.87%"),
                Map.entry("8423", "1.21%"),
                Map.entry("8380", "1.04%"),
                Map.entry("8383", "1.56%"),
                Map.entry("8384", "0.17%"),
                Map.entry("8381", "0.87%"),
                Map.entry("8382", "0.69%"),
                Map.entry("8417", "0.87%"),
                Map.entry("8418", "0.52%"),
                Map.entry("8415", "0.69%"),
                Map.entry("8019", "0.17%"),
                Map.entry("8416", "0.87%"),
                Map.entry("8419", "1.21%"),
                Map.entry("8431", "0.69%"),
                Map.entry("8398", "0.87%"),
                Map.entry("8399", "1.21%"),
                Map.entry("8432", "1.04%"),
                Map.entry("8396", "0.52%"),
                Map.entry("8397", "1.56%"),
                Map.entry("8430", "0.52%"),
                Map.entry("8435", "0.87%"),
                Map.entry("8436", "1.04%"),
                Map.entry("8433", "0.52%"),
                Map.entry("8434", "0.52%"),
                Map.entry("8390", "1.04%"),
                Map.entry("8391", "1.04%"),
                Map.entry("8394", "1.21%"),
                Map.entry("8395", "1.21%"),
                Map.entry("8392", "1.04%"),
                Map.entry("8393", "1.39%"),
                Map.entry("8428", "1.21%"),
                Map.entry("8429", "0.52%"),
                Map.entry("8426", "1.39%"),
                Map.entry("8427", "1.56%"),
                Map.entry("8442", "1.39%"),
                Map.entry("8443", "1.04%"),
                Map.entry("8440", "1.04%"),
                Map.entry("8441", "0.52%"),
                Map.entry("8446", "1.04%"),
                Map.entry("8447", "1.39%"),
                Map.entry("8444", "1.56%"),
                Map.entry("8445", "1.56%"),
                Map.entry("7907", "0.17%"),
                Map.entry("7909", "0.35%"),
                Map.entry("8439", "1.39%"),
                Map.entry("8437", "0.69%"),
                Map.entry("8438", "0.87%"),
                Map.entry("8453", "0.52%"),
                Map.entry("8454", "1.04%"),
                Map.entry("8451", "0.87%"),
                Map.entry("8452", "0.87%"),
                Map.entry("8457", "1.21%"),
                Map.entry("8458", "0.87%"),
                Map.entry("8455", "1.21%"),
                Map.entry("8456", "1.04%"),
                Map.entry("8450", "0.87%"),
                Map.entry("7918", "0.17%"),
                Map.entry("7917", "0.35%"),
                Map.entry("7919", "0.17%"),
                Map.entry("7910", "0.17%"),
                Map.entry("8448", "1.21%"),
                Map.entry("7912", "0.17%"),
                Map.entry("8449", "1.39%"),
                Map.entry("7911", "0.17%"),
                Map.entry("7914", "0.17%"),
                Map.entry("7913", "0.17%"),
                Map.entry("7916", "0.17%"),
                Map.entry("7915", "0.17%"),
                Map.entry("8465", "1.04%"),
                Map.entry("7930", "0.17%"),
                Map.entry("7929", "0.17%"),
                Map.entry("7928", "0.17%"),
                Map.entry("7921", "0.17%"),
                Map.entry("8459", "1.04%"),
                Map.entry("7925", "0.17%"),
                Map.entry("7924", "0.17%"),
                Map.entry("7927", "0.35%"),
                Map.entry("7941", "0.35%"),
                Map.entry("7939", "0.17%"),
                Map.entry("7932", "0.17%"),
                Map.entry("7931", "0.17%"),
                Map.entry("7934", "0.17%"),
                Map.entry("7933", "0.17%"),
                Map.entry("7936", "0.17%"),
                Map.entry("7935", "0.35%"),
                Map.entry("7938", "0.35%"),
                Map.entry("8402", "0.69%"),
                Map.entry("7950", "0.17%"),
                Map.entry("8403", "0.52%"),
                Map.entry("8400", "1.39%"),
                Map.entry("7952", "0.35%"),
                Map.entry("8401", "1.04%"),
                Map.entry("8483", "1.04%"),
                Map.entry("7943", "0.35%"),
                Map.entry("7942", "0.35%"),
                Map.entry("7945", "0.17%"),
                Map.entry("7944", "0.17%"),
                Map.entry("7947", "0.17%"),
                Map.entry("7946", "0.35%"),
                Map.entry("7948", "0.17%"));

        return relativeFrequencyMap;
    }
}
