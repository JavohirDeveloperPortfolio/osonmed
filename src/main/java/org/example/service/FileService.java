package org.example.service;

public interface FileService {
    String getDataFromFile(String fileName);
    boolean writeDataToFile(String data, String fileName);
}
