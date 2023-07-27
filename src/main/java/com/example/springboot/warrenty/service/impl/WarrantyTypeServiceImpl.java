package com.example.springboot.warrenty.service.impl;

import com.example.springboot.common.entity.WarrantyType;
import com.example.springboot.common.repository.WarrantyTypeRepository;
import com.example.springboot.warrenty.dto.WarrantyTypeDTO;
import com.example.springboot.warrenty.service.WarrantyTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface for warranty type service layer.
 *
 * @author Maneesha
 */
@Slf4j
@Service
public class WarrantyTypeServiceImpl implements WarrantyTypeService {

    @Autowired
    WarrantyTypeRepository warrantyTypeRepository;

    /**
     * save warranty type with validations
     */
    @Override
    public void saveWarrantyType(WarrantyTypeDTO warrantyTypeDTO) {
        if (warrantyTypeDTO != null) {
            log.info("warrantyTypeDTO : {}", warrantyTypeDTO);
            if (warrantyTypeDTO.getId() == null || warrantyTypeDTO.getWarrantyType() == null || warrantyTypeDTO.getWarrantyType().isEmpty()) {
                log.info("warranty type or name cannot be null or empty: {}", warrantyTypeDTO);
                throw new IllegalArgumentException("warranty type or name cannot be null or empty.");
            } else {
                if (warrantyTypeRepository.existsById(Math.toIntExact(warrantyTypeDTO.getId()))) {
                    log.info("Already exists! {}", warrantyTypeDTO.getId());
                    throw new RuntimeException("Already exists! " + warrantyTypeDTO.getId());
                } else {
                    log.info("warranty saved successfully - !" + warrantyTypeDTO.getId());
                    warrantyTypeRepository.save(warrantyTypeEntityModelMapper(warrantyTypeDTO));
                }
            }
        } else {
            throw new IllegalArgumentException("WarrantyTypeDTO cannot be null.");
        }
    }

    /**
     * get all warranty detail types
     */
    @Override
    public List<WarrantyTypeDTO> getAllWarrantyTypeDetails() {
        return warrantyTypeRepository.findAll().stream().map(this::warrantyTypeDTOModalMapper).toList();
    }


    /**
     * update warranty type with validations
     */
    @Override
    public void updateWarrantyType(WarrantyTypeDTO warrantyTypeDTO) {
        if (warrantyTypeDTO != null) {
            if (warrantyTypeDTO.getId() == null || warrantyTypeDTO.getWarrantyType() == null || warrantyTypeDTO.getId().describeConstable().isEmpty() || warrantyTypeDTO.getWarrantyType().isEmpty()) {
                throw new IllegalArgumentException("warranty arguments cannot be null or empty.");
            } else {
                if (warrantyTypeRepository.existsById(Math.toIntExact(warrantyTypeDTO.getId()))) {
                    warrantyTypeRepository.save(warrantyTypeEntityModelMapper(warrantyTypeDTO));
                } else {
                    throw new RuntimeException("cannot find this warranty code! " + warrantyTypeDTO.getId());
                }
            }
        } else {
            throw new RuntimeException("warrantyDTO cannot be null!");
        }
    }

    /**
     * pagination management
     */
    @Override
    public Page<WarrantyType> returnPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return warrantyTypeRepository.findAll(pageable);
    }

    /**
     * warranty type -> warranty dto
     */
    private WarrantyTypeDTO warrantyTypeDTOModalMapper(WarrantyType warrantyType) {
        WarrantyTypeDTO warrantyTypeDTO = new WarrantyTypeDTO();
        warrantyTypeDTO.setId(warrantyType.getId());
        warrantyTypeDTO.setCreatedAt(warrantyType.getCreatedAt());
        warrantyTypeDTO.setUpdatedAt(warrantyType.getUpdatedAt());
        warrantyTypeDTO.setWarrantyType(warrantyType.getWarrantyType());
        return warrantyTypeDTO;
    }

    /**
     * warranty typ dto -> warranty type
     */
    private WarrantyType warrantyTypeEntityModelMapper(WarrantyTypeDTO warrantyTypeDTO) {
        WarrantyType warrantyType = new WarrantyType();
        warrantyType.setId(warrantyTypeDTO.getId());
        warrantyType.setCreatedAt(warrantyTypeDTO.getCreatedAt());
        warrantyType.setUpdatedAt(warrantyTypeDTO.getUpdatedAt());
        warrantyType.setWarrantyType(warrantyTypeDTO.getWarrantyType());
        return warrantyType;
    }

}
