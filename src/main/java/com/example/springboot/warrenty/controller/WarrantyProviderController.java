package com.example.springboot.warrenty.controller;

import com.example.springboot.common.GenericResponse;
import com.example.springboot.warrenty.dto.WarrantyProviderDTO;
import com.example.springboot.warrenty.service.WarrantyProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/warranty-provider/")
public class WarrantyProviderController {
    private static final Logger logger = LoggerFactory.getLogger(WarrantyController.class);

    @Autowired
    WarrantyProviderService warrantyProviderService;

    @PostMapping(value = "save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse saveWarrantyProvide(@RequestBody WarrantyProviderDTO warrantyProviderDTO) {
        logger.info("Save Warranty. Request: {}", warrantyProviderDTO);
        GenericResponse response = new GenericResponse();
        warrantyProviderService.saveWarrantyProvider(warrantyProviderDTO);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @GetMapping(value = "get-all-warranty-providers", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse getAllWarrantyTypeDetails() {
        GenericResponse response = new GenericResponse();
        response.setResponse(warrantyProviderService.getAllWarrantyTypeDetails());
        logger.info("Get all warranty types . response: {}", response);
        response.setStatus(HttpStatus.OK);
        return response;
    }


}
