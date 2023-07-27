package com.example.springboot.warrenty.service;

import com.example.springboot.common.entity.WarrantyType;
import com.example.springboot.warrenty.dto.WarrantyTypeDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * warranty type service
 *
 * @author Maneesha
 */

@Component
public interface WarrantyTypeService {

    void saveWarrantyType(WarrantyTypeDTO warrantyTypeDTO);

    List<WarrantyTypeDTO> getAllWarrantyTypeDetails();

    void updateWarrantyType(WarrantyTypeDTO warrantyTypeDTO);

    Page<WarrantyType> returnPagination(Integer pageNumber, Integer pageSize);
}
