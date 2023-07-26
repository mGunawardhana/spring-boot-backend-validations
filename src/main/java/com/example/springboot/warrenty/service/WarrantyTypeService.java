package com.example.springboot.warrenty.service;

import com.example.springboot.warrenty.dto.WarrantyTypeDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Interface for Receipt service layer.
 *
 * @author Maneesha
 */

@Component
public interface WarrantyTypeService {

    void saveWarrantyType(WarrantyTypeDTO warrantyTypeDTO);

    List<WarrantyTypeDTO> getAllWarrantyTypeDetails();

    void updateWarrantyType(WarrantyTypeDTO warrantyTypeDTO);
}
