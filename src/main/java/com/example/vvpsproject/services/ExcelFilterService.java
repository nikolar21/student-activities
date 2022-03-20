package com.example.vvpsproject.services;

import com.example.vvpsproject.constants.FilterHelper;
import com.example.vvpsproject.models.StudentActivity;
import com.poiji.bind.Poiji;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExcelFilterService {

    /*
     * Method for filtering given Excel file and returning all entries where event name is "A file has been uploaded"
     */
    public List<StudentActivity> filterExcelForUploadedFilesEntries() {
        File file = new File(FilterHelper.FILE_PATH);
        try {
            List<StudentActivity> studentActivities = Poiji.fromExcel(file, StudentActivity.class);
            return studentActivities
                    .stream()
                    .filter(eventName -> FilterHelper.A_FILE_HAS_BEEN_UPLOADED.equals(eventName.getEventName()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error occurred while processing file {} {}", e.getCause(), e.getMessage());
        }
        return null;
    }

    public Map<String, Float> calculateAbsoluteFrequencyOfUploadedFiles() {
        Set<String> ids = findUniqueUserIds();
        List<StudentActivity> uploadedFileActivities = filterExcelForUploadedFilesEntries();
        Map<String, Float> absoluteFrequency = new HashMap<>();

        uploadedFileActivities.forEach(entity -> ids.forEach(key -> {
            if (entity.getDescription().contains(key)) {
                if (absoluteFrequency.containsKey(key)) {
                    absoluteFrequency.put(key, absoluteFrequency.get(key) + 1);
                } else {
                    absoluteFrequency.put(key, 1f);
                }
            }
        }));
        return absoluteFrequency;
    }

    public Map<String, String> calculateRelativeFrequencyOfUploadedFiles() {
        Map<String, Float> filesUploadedPerUser = calculateAbsoluteFrequencyOfUploadedFiles();
        int numberOfFilesUploaded = filterExcelForUploadedFilesEntries().size();
        filesUploadedPerUser.entrySet().forEach(id -> id.setValue(id.getValue() / numberOfFilesUploaded * 100));

        Map<String, String> relativeFrequency = new HashMap<>();
        for (Map.Entry<String, Float> entry : filesUploadedPerUser.entrySet()) {
            relativeFrequency.put(entry.getKey(), String.format("%.2f", entry.getValue()) + "%");
        }
        return relativeFrequency;
    }

    public Float calculateAverageValueOfUploadedFiles() {
        float filesUploaded = filterExcelForUploadedFilesEntries().size();
        int userIds = findUniqueUserIds().size();
        return filesUploaded / userIds;
    }

    public Float calculateScopeOfUploadedFiles() {
        List<Float> numberOfUploadedFiles = new ArrayList<>(calculateAbsoluteFrequencyOfUploadedFiles().values());

        return calculateAbsoluteFrequencyOfUploadedFiles().values().stream().max(Comparator.naturalOrder()).orElseThrow()
                - numberOfUploadedFiles.stream().min(Comparator.naturalOrder()).orElseThrow();
    }

    public Set<String> findUniqueDescriptions() {
        List<StudentActivity> uploadedFileActivities = filterExcelForUploadedFilesEntries();
        Set<String> descriptions = new HashSet<>();
        uploadedFileActivities.forEach(studentActivity -> descriptions.add(studentActivity.getDescription()));
        return descriptions;
    }

    public Set<String> findUniqueUserIds() {
        Set<String> ids = new HashSet<>();
        Set<String> uniqueDescriptions = findUniqueDescriptions();
        for (String description : uniqueDescriptions) {
            ids.add(description.substring(18, 22));
        }
        return ids;
    }
}
