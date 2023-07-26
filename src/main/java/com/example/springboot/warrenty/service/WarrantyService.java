package com.example.springboot.warrenty.service;

import com.example.springboot.warrenty.dto.WarrantyDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Interface for Receipt service layer.
 *
 * @author Maneesha
 */

@Component
public interface WarrantyService {

    void saveWarranty(WarrantyDTO warranty);

    void updateWarranty(WarrantyDTO warranty);

    void deleteWarranty(Integer code);

    List<?> getAllWarrantyDetails();
}
