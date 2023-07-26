package com.example.springboot.warrenty.service.impl;


import com.example.springboot.common.entity.TermsAndConditions;
import com.example.springboot.common.entity.Warranty;
import com.example.springboot.common.repository.WarrantyRepository;
import com.example.springboot.warrenty.dto.WarrantyDTO;
import com.example.springboot.warrenty.service.WarrantyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for Receipt service layer.
 *
 * @author Maneesha
 */

@Slf4j
@Service
public class WarrantyServiceImpl implements WarrantyService {


    @Autowired
    WarrantyRepository warrantyRepository;

    @Override
    public void saveWarranty(WarrantyDTO warrantyDTO) {
        if (warrantyDTO != null) {
            if (warrantyDTO.getWarrantyType() == null || warrantyDTO.getWarrantyProvider() == null || warrantyDTO.getWarrantyCode() == null || warrantyDTO.getWarrantyName() == null || warrantyDTO.getWarrantyDescription() == null || warrantyDTO.getWarrantyDuration() == null || warrantyDTO.getTermsAndConditions() == null || warrantyDTO.getWarrantyType().isEmpty() || warrantyDTO.getWarrantyProvider().isEmpty() || warrantyDTO.getWarrantyCode().isEmpty() || warrantyDTO.getWarrantyName().isEmpty() || warrantyDTO.getWarrantyDescription().isEmpty() || warrantyDTO.getWarrantyDuration().isEmpty() || warrantyDTO.getTermsAndConditions().isEmpty()) {
                throw new IllegalArgumentException("warranty arguments cannot be null or empty.");
            } else {
                for (TermsAndConditions termsAndConditions : warrantyDTO.getTermsAndConditions()) {
                    if (termsAndConditions.getId() == null || termsAndConditions.getTerm() == null || termsAndConditions.getConditions() == null || termsAndConditions.getId().describeConstable().isEmpty() || termsAndConditions.getTerm().isEmpty() || termsAndConditions.getConditions().isEmpty()) {
                        throw new IllegalArgumentException("terms and conditions cannot be null or empty.");
                    }
                }
                if (warrantyRepository.existsById(Math.toIntExact(warrantyDTO.getId()))) {
                    log.info("Already have this id {}", warrantyDTO.getId());
                    throw new RuntimeException("Already exists this warranty! " + warrantyDTO.getId());
                } else {
                    log.info("warranty saved successfully - !" + warrantyDTO.getId());
                    warrantyRepository.save(warrantyEntityModelMapper(warrantyDTO));
                }
            }
        } else {
            throw new RuntimeException("warrantyDTO cannot be null!");
        }
    }

    @Override
    public void updateWarranty(WarrantyDTO warrantyDTO) {
        if (warrantyDTO != null) {
            if (warrantyDTO.getWarrantyType() == null || warrantyDTO.getWarrantyProvider() == null || warrantyDTO.getWarrantyCode() == null || warrantyDTO.getWarrantyName() == null || warrantyDTO.getWarrantyDescription() == null || warrantyDTO.getWarrantyDuration() == null || warrantyDTO.getTermsAndConditions() == null || warrantyDTO.getWarrantyType().isEmpty() || warrantyDTO.getWarrantyProvider().isEmpty() || warrantyDTO.getWarrantyCode().isEmpty() || warrantyDTO.getWarrantyName().isEmpty() || warrantyDTO.getWarrantyDescription().isEmpty() || warrantyDTO.getWarrantyDuration().isEmpty() || warrantyDTO.getTermsAndConditions().isEmpty()) {
                throw new IllegalArgumentException("warranty arguments cannot be null or empty.");
            } else {
                for (TermsAndConditions termsAndConditions : warrantyDTO.getTermsAndConditions()) {
                    if (termsAndConditions.getId() == null || termsAndConditions.getTerm() == null || termsAndConditions.getConditions() == null || termsAndConditions.getId().describeConstable().isEmpty() || termsAndConditions.getTerm().isEmpty() || termsAndConditions.getConditions().isEmpty()) {
                        throw new IllegalArgumentException("terms and conditions cannot be null or empty.");
                    }
                }
                if (warrantyRepository.existsById(Math.toIntExact(warrantyDTO.getId()))) {
                    warrantyRepository.save(warrantyEntityModelMapper(warrantyDTO));
                } else {
                    throw new RuntimeException("cannot find this warranty code! " + warrantyDTO.getId());
                }
            }
        } else {
            throw new RuntimeException("warrantyDTO cannot be null!");
        }
    }

    @Override
    public void deleteWarranty(Integer code) {
        if (warrantyRepository.existsById(code)) {
            warrantyRepository.deleteById(code);
        } else {
            throw new RuntimeException("No such a warranty !");
        }
    }

    @Override
    public List<WarrantyDTO> getAllWarrantyDetails() {
        List<Warranty> warranties = warrantyRepository.getAllWarrantyDetailsWithTermsAndConditions();
        List<WarrantyDTO> warrantyDTOs = new ArrayList<>();

        for (Warranty warranty : warranties) {
            warrantyDTOs.add(warrantyDTOModelMapper(warranty));
        }

        return warrantyDTOs;
    }

    private WarrantyDTO warrantyDTOModelMapper(Warranty warranty) {
        WarrantyDTO warrantyDTO = new WarrantyDTO();
        warrantyDTO.setId(warranty.getId());
        warrantyDTO.setWarrantyType(warranty.getWarrantyType());
        warrantyDTO.setWarrantyProvider(warranty.getWarrantyProvider());
        warrantyDTO.setWarrantyCode(warranty.getWarrantyCode());
        warrantyDTO.setWarrantyName(warranty.getWarrantyName());
        warrantyDTO.setWarrantyDescription(warranty.getWarrantyDescription());
        warrantyDTO.setWarrantyDuration(warranty.getWarrantyDuration());
        warrantyDTO.setTermsAndConditions(warranty.getTermsAndConditions());
        return warrantyDTO;
    }


    private Warranty warrantyEntityModelMapper(WarrantyDTO warrantyDTO) {
        log.info("warranty service DTO {}", warrantyDTO);
        Warranty warranty = new Warranty();
        warranty.setId(warrantyDTO.getId());
        warranty.setWarrantyType(warrantyDTO.getWarrantyType());
        warranty.setWarrantyProvider(warrantyDTO.getWarrantyProvider());
        warranty.setWarrantyCode(warrantyDTO.getWarrantyCode());
        warranty.setWarrantyName(warrantyDTO.getWarrantyName());
        warranty.setWarrantyDescription(warrantyDTO.getWarrantyDescription());
        warranty.setWarrantyDuration(warrantyDTO.getWarrantyDuration());
        warranty.setStatus("1");

        List<TermsAndConditions> terms = new ArrayList<>();
        for (TermsAndConditions termsAndConditionsDTO : warrantyDTO.getTermsAndConditions()) {
            log.info("terms and conditions {}", termsAndConditionsDTO);
            TermsAndConditions termsAndConditions = new TermsAndConditions();
            termsAndConditions.setId(termsAndConditionsDTO.getId());
            termsAndConditions.setTerm(termsAndConditionsDTO.getTerm());
            termsAndConditions.setConditions(termsAndConditionsDTO.getConditions());
            termsAndConditions.setStatus("1");
            termsAndConditions.setWarranty(warranty);
            terms.add(termsAndConditions);
        }
        warranty.setTermsAndConditions(terms);
        return warranty;
    }


}