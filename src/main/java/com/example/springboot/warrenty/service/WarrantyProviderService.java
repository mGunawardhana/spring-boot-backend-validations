package com.example.springboot.warrenty.service;

import com.example.springboot.warrenty.dto.WarrantyProviderDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Interface for warranty provider service
 *
 * @author Maneesha
 */
@Component
public interface WarrantyProviderService {
    void saveWarrantyProvider(WarrantyProviderDTO warrantyProviderDTO);

    List<WarrantyProviderDTO> getAllWarrantyTypeDetails();

    void updateWarrantyType(WarrantyProviderDTO warrantyProviderDTO);
}
