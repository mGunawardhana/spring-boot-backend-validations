package com.example.springboot.warrenty.service.impl;

import com.example.springboot.common.entity.WarrantyProvider;
import com.example.springboot.common.repository.WarrantyProviderRepository;
import com.example.springboot.warrenty.dto.WarrantyProviderDTO;
import com.example.springboot.warrenty.service.WarrantyProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface for Receipt service layer.
 *
 * @author Maneesha
 */
@Slf4j
@Service
public class WarrantyProviderServiceImpl implements WarrantyProviderService {

    @Autowired
    WarrantyProviderRepository warrantyProviderRepository;

    @Override
    public void saveWarrantyProvider(WarrantyProviderDTO warrantyProviderDTO) {
        if (warrantyProviderDTO != null) {
            if (warrantyProviderDTO.getId() == null || warrantyProviderDTO.getWarrantyProvider() == null || warrantyProviderDTO.getId().describeConstable().isEmpty() || warrantyProviderDTO.getWarrantyProvider().isEmpty()) {
                throw new IllegalArgumentException("warranty provider details cannot be null or empty.");
            } else {
                if (warrantyProviderRepository.existsById(warrantyProviderDTO.getId())) {
                    log.info("Already exists! {}", warrantyProviderDTO.getId());
                    throw new RuntimeException("Already exists! " + warrantyProviderDTO.getId());
                } else {
                    log.info("warranty saved successfully - !" + warrantyProviderDTO.getId());
                    warrantyProviderRepository.save(warrantyProviderEntityModelMapper(warrantyProviderDTO));
                }
            }
        }
    }

    @Override
    public List<WarrantyProviderDTO> getAllWarrantyTypeDetails() {
        return warrantyProviderRepository.findAll().stream().map(this::warrantyProviderDTOModalMapper).toList();
    }

    @Override
    public void updateWarrantyType(WarrantyProviderDTO warrantyProviderDTO) {

    }

    private WarrantyProviderDTO warrantyProviderDTOModalMapper(WarrantyProvider warrantyProvider){
        WarrantyProviderDTO warrantyProviderDTO = new WarrantyProviderDTO();
        warrantyProviderDTO.setId(warrantyProvider.getId());
        warrantyProviderDTO.setCreatedAt(warrantyProvider.getCreatedAt());
        warrantyProviderDTO.setUpdatedAt(warrantyProvider.getUpdatedAt());
        warrantyProviderDTO.setWarrantyProvider(warrantyProvider.getWarrantyProvider());
        return warrantyProviderDTO;
    }

    private WarrantyProvider warrantyProviderEntityModelMapper(WarrantyProviderDTO warrantyProviderDTO) {
        WarrantyProvider warrantyProvider = new WarrantyProvider();
        warrantyProvider.setId(warrantyProviderDTO.getId());
        warrantyProvider.setCreatedAt(warrantyProviderDTO.getCreatedAt());
        warrantyProvider.setUpdatedAt(warrantyProviderDTO.getUpdatedAt());
        warrantyProvider.setWarrantyProvider(warrantyProviderDTO.getWarrantyProvider());
        return warrantyProvider;
    }

}
