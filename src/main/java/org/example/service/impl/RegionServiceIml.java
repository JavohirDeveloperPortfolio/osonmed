package org.example.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.modul.Region;
import org.example.service.FileService;

import java.util.ArrayList;
import java.util.List;

public class RegionServiceIml {
    private String fileName = "regions.txt";

    private FileService fileService = new FileServiceImpl();

    public List<Region> getAll(){
        return List.of(
                new Region(1, "Bektimer tumani","Bektimer tumani ru"),
                new Region(2, "Mirzo Ulug'bek tumani", "Mirzo Ulug'bek tumani ru"),
                new Region(3, "Mirobod tumani", "Mirobod tumani ru")
        );
//        String dataFromFile = fileService.getDataFromFile(fileName);
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            List<Region> list = objectMapper.readValue(dataFromFile, List.class);
//            System.out.println(list);
//            return list;
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
    }
}
