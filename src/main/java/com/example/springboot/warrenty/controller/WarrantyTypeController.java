package com.example.springboot.warrenty.controller;

import com.example.springboot.common.GenericResponse;
import com.example.springboot.common.entity.WarrantyType;
import com.example.springboot.warrenty.dto.WarrantyTypeDTO;
import com.example.springboot.warrenty.service.WarrantyTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
/**
 * warranty type controller
 *
 * @author Maneesha
 */
@RestController
@CrossOrigin
@RequestMapping("/warranty-type/")
public class WarrantyTypeController {
    private static final Logger logger = LoggerFactory.getLogger(WarrantyController.class);

    @Autowired
    WarrantyTypeService warrantyTypeService;

    @PostMapping(value = "save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse saveWarrantyType(@RequestBody WarrantyTypeDTO warrantyTypeDTO) {
        logger.info("Save Warranty. Request: {}", warrantyTypeDTO);
        GenericResponse response = new GenericResponse();
        warrantyTypeService.saveWarrantyType(warrantyTypeDTO);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @GetMapping(value = "get-all-warranty-type", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse getAllWarrantyTypeDetails() {
        GenericResponse response = new GenericResponse();
        response.setResponse(warrantyTypeService.getAllWarrantyTypeDetails());
        logger.info("Get all warranty types . response: {}", response);
        response.setStatus(HttpStatus.OK);
        return response;
    }


    @GetMapping(value = "pagination/{pageNumber}/{pageSize}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Page<WarrantyType> paginationManager(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        return warrantyTypeService.returnPagination(pageNumber,pageSize);
    }


    @PutMapping(value = "update", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse updateWarranty(@RequestBody WarrantyTypeDTO request) {
        logger.info("Update Area. Request: {}", request);
        GenericResponse response = new GenericResponse();
        warrantyTypeService.updateWarrantyType(request);
        response.setStatus(HttpStatus.OK);
        return response;
    }

}
