package com.example.vvpsproject.services;

import com.example.vvpsproject.constants.FilterHelper;
import com.example.vvpsproject.model.StudentActivity;
import com.poiji.bind.Poiji;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExcelFilter {

    /*
     * Method for filtering given Excel file and returning all entries where event name is "A file has been uploaded"
     */
    public List<StudentActivity> filterExcelForUploadedFilesEntries() {
        File file = new File(FilterHelper.FILE_PATH);
        List<StudentActivity> studentActivities = Poiji.fromExcel(file, StudentActivity.class);
        return studentActivities
                .stream()
                .filter(eventName -> FilterHelper.A_FILE_HAS_BEEN_UPLOADED.equals(eventName.getEventName()))
                .collect(Collectors.toList());
    }

    public HashMap<String, Float> calculateAbsoluteFrequencyOfUploadedFiles() {
        Set<String> ids = findUniqueUserIds();
        List<StudentActivity> uploadedFileActivities = filterExcelForUploadedFilesEntries();
        HashMap<String, Float> absoluteFrequency = new HashMap<>();

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

    public HashMap<String, String> calculateRelativeFrequencyOfUploadedFiles() {
        HashMap<String, Float> filesUploadedPerUser = calculateAbsoluteFrequencyOfUploadedFiles();
        int numberOfFilesUploaded = filterExcelForUploadedFilesEntries().size();
        filesUploadedPerUser.entrySet().forEach(id -> id.setValue(id.getValue() / numberOfFilesUploaded * 100));

        HashMap<String, String> relativeFrequency = new HashMap<>();
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
        float scope;
        List<Float> numberOfUploadedFiles = new ArrayList<>(calculateAbsoluteFrequencyOfUploadedFiles().values());
        scope = numberOfUploadedFiles.stream().max(Comparator.naturalOrder()).orElseThrow()
                - numberOfUploadedFiles.stream().min(Comparator.naturalOrder()).orElseThrow();
        return scope;
    }

    public Set<String> findUniqueDescriptions() {
        List<StudentActivity> uploadedFileActivities = filterExcelForUploadedFilesEntries();
        Set<String> description = new HashSet<>();
        uploadedFileActivities.forEach(studentActivity -> description.add(studentActivity.getDescription()));
        return description;
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
