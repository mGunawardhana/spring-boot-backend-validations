package com.example.springboot.warrenty.controller;

import com.example.springboot.common.GenericResponse;
import com.example.springboot.warrenty.dto.WarrantyDTO;
import com.example.springboot.warrenty.service.WarrantyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Interface for Receipt service layer.
 *
 * @author Maneesha
 */

@RestController
@CrossOrigin
@RequestMapping("/warranty/")
public class WarrantyController {
    private static final Logger logger = LoggerFactory.getLogger(WarrantyController.class);

    @Autowired
    WarrantyService warrantyService;

    //TODO verified
    @GetMapping(value = "get-all-warranty", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse getAllWarrantyDetails() {
        GenericResponse response = new GenericResponse();
        response.setResponse(warrantyService.getAllWarrantyDetails());
        logger.info("Get all Area. response: {}", response);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    //TODO verified
    @PostMapping(value = "save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse saveWarranty(@RequestBody WarrantyDTO request) {
        logger.info("Save Warranty. Request: {}", request);
        GenericResponse response = new GenericResponse();
        warrantyService.saveWarranty(request);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    //TODO verified
    @PutMapping(value = "update", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse updateWarranty(@RequestBody WarrantyDTO request) {
        logger.info("Update Area. Request: {}", request);
        GenericResponse response = new GenericResponse();
        warrantyService.updateWarranty(request);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    //TODO verified
    @DeleteMapping(value = "delete-{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse deleteWarrantyById(@PathVariable Integer id) {
        logger.info("Delete Warranty Request: {}", id);
        GenericResponse response = new GenericResponse();
        warrantyService.deleteWarranty(id);
        response.setStatus(HttpStatus.OK);
        logger.info("Delete Warranty. Response: {}", response);
        return response;
    }


}
