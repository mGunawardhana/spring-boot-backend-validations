package com.example.springboot.warrenty.service.impl;


import com.example.springboot.common.entity.TermsAndConditions;
import com.example.springboot.common.entity.Warranty;
import com.example.springboot.common.repository.TermsAndConditionsRepository;
import com.example.springboot.common.repository.WarrantyRepository;
import com.example.springboot.warrenty.dto.TermsAndConditionsDTO;
import com.example.springboot.warrenty.dto.WarrantyDTO;
import com.example.springboot.warrenty.service.WarrantyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * warranty service impl
 *
 * @author Maneesha
 */

@Slf4j
@Service
@Transactional
public class WarrantyServiceImpl implements WarrantyService {


    @Autowired
    WarrantyRepository warrantyRepository;

    @Autowired
    TermsAndConditionsRepository termsAndConditionsRepository;

    /**
     * save warranty type with checking validations
     */
    @Override
    public void saveWarranty(WarrantyDTO warrantyDTO) {
        if (warrantyDTO != null) {
            if (warrantyDTO.getWarrantyType() == null || warrantyDTO.getWarrantyProvider() == null || warrantyDTO.getWarrantyCode() == null || warrantyDTO.getWarrantyName() == null || warrantyDTO.getWarrantyDescription() == null || warrantyDTO.getWarrantyDuration() == null || warrantyDTO.getWarrantyType().isEmpty() || warrantyDTO.getWarrantyProvider().isEmpty() || warrantyDTO.getWarrantyCode().isEmpty() || warrantyDTO.getWarrantyName().isEmpty() || warrantyDTO.getWarrantyDescription().isEmpty() || warrantyDTO.getWarrantyDuration().isEmpty()) {
                log.warn("warranty arguments cannot be null or empty.");
                throw new IllegalArgumentException("warranty arguments cannot be null or empty.");
            } else {
                Warranty save = warrantyRepository.save(warrantyEntityModelMapper(warrantyDTO));
                if (save.getId() != null || save.getWarrantyCode() != null) {
                    for (TermsAndConditionsDTO termsAndConditionsDTO : warrantyDTO.getTermsAndConditions()) {
                        TermsAndConditions termsAndConditions = new TermsAndConditions();
                        termsAndConditions.setId(termsAndConditionsDTO.getId());
                        termsAndConditions.setTerm(termsAndConditionsDTO.getTerm());
                        termsAndConditions.setConditions(termsAndConditionsDTO.getConditions());
                        termsAndConditions.setStatus("1");
                        termsAndConditions.setWarrantyId(save.getId());
                        termsAndConditionsRepository.save(termsAndConditions);
                        log.info("termsAndConditions Saved! {} ", termsAndConditions);
                    }
                } else {
                    log.warn("id or warrantyCode cannot be null or empty.");
                    throw new RuntimeException("id or warrantyCode cannot be null or empty.");
                }
            }
        } else {
            log.warn("terms and condition object cannot be null!");
            throw new RuntimeException("terms and condition object cannot be null!");
        }
    }

    /**
     * update warranty type with checking validations
     */
    @Override
    public void updateWarranty(WarrantyDTO warrantyDTO) {
        if (warrantyDTO != null) {
            if (warrantyDTO.getWarrantyType() == null || warrantyDTO.getWarrantyProvider() == null || warrantyDTO.getWarrantyCode() == null || warrantyDTO.getWarrantyName() == null || warrantyDTO.getWarrantyDescription() == null || warrantyDTO.getWarrantyDuration() == null || warrantyDTO.getWarrantyType().isEmpty() || warrantyDTO.getWarrantyProvider().isEmpty() || warrantyDTO.getWarrantyCode().isEmpty() || warrantyDTO.getWarrantyName().isEmpty() || warrantyDTO.getWarrantyDescription().isEmpty() || warrantyDTO.getWarrantyDuration().isEmpty()) {
                throw new IllegalArgumentException("warranty arguments cannot be null or empty.");
            } else {
//                for (TermsAndConditions termsAndConditions : warrantyDTO.getTermsAndConditions()) {
//                    if (termsAndConditions.getId() == null || termsAndConditions.getTerm() == null || termsAndConditions.getConditions() == null || termsAndConditions.getId().describeConstable().isEmpty() || termsAndConditions.getTerm().isEmpty() || termsAndConditions.getConditions().isEmpty()) {
//                        throw new IllegalArgumentException("terms and conditions cannot be null or empty.");
//                    }
//                }
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

    /**
     * deleting warranty
     */
    @Override
    public void deleteWarranty(Integer code) {
        if (warrantyRepository.existsById(code)) {
            Warranty warrantyToDelete = null;
            for (Warranty warranty : warrantyRepository.findAll()) {
                if (warranty.getId().equals(code)) {
                    warrantyToDelete = warranty;
                    break;
                }
            }

            if (warrantyToDelete != null) {
                warrantyToDelete.setStatus("0");
                warrantyRepository.save(warrantyToDelete);
            }
        } else {
            throw new RuntimeException("No such a warranty!");
        }
    }


    /**
     * get all warranty details
     */
    @Override
    public List<?> getAllWarrantyDetails() {        //TODO fix the bug here ....

        return warrantyRepository.findAll().stream().map(this::warrantyDTOModelMapper).toList();
//        return warrantyRepository.getAllWarrantyDetailsWithTermsAndConditions().stream().map(this::warrantyDTOModelMapper).toList();
    }

    /**
     * warranty type -> warranty dto
     */
    private WarrantyDTO warrantyDTOModelMapper(Warranty warranty) {
        WarrantyDTO warrantyDTO = new WarrantyDTO();
        warrantyDTO.setId(warranty.getId());
        warrantyDTO.setWarrantyType(warranty.getWarrantyType());
        warrantyDTO.setWarrantyProvider(warranty.getWarrantyProvider());
        warrantyDTO.setWarrantyCode(warranty.getWarrantyCode());
        warrantyDTO.setWarrantyName(warranty.getWarrantyName());
        warrantyDTO.setWarrantyDescription(warranty.getWarrantyDescription());
        warrantyDTO.setWarrantyDuration(warranty.getWarrantyDuration());
        warrantyDTO.setStatus(warranty.getStatus());


        //TODO fix the bug here ....
//
//        List<TermsAndConditions> termsAndConditionsDTOList = new ArrayList<>();
//        for (TermsAndConditions termsAndConditions:warranty.getTermsAndConditions()){
//            TermsAndConditionsDTO termsAndConditions1 = new TermsAndConditionsDTO();
//            termsAndConditions1.setId(termsAndConditions.getId());
//            termsAndConditions1.setTerm(termsAndConditions.getTerm());
//            termsAndConditions1.setConditions(termsAndConditions.getConditions());
//            termsAndConditions1.setStatus(termsAndConditions.getStatus());
//            termsAndConditions1.setWarranty(termsAndConditions.getWarranty());
//            termsAndConditionsDTOList.add(termsAndConditions1);
//        }

        return warrantyDTO;
    }


    /**
     * warranty dto -> warranty
     */
    private Warranty warrantyEntityModelMapper(WarrantyDTO warrantyDTO) {
        log.info("warranty service DTO {}", warrantyDTO);
        Warranty warranty = new Warranty();
//        warranty.setId(warrantyDTO.getId());
        warranty.setWarrantyType(warrantyDTO.getWarrantyType());
        warranty.setWarrantyProvider(warrantyDTO.getWarrantyProvider());
        warranty.setWarrantyCode(warrantyDTO.getWarrantyCode());
        warranty.setWarrantyName(warrantyDTO.getWarrantyName());
        warranty.setWarrantyDescription(warrantyDTO.getWarrantyDescription());
        warranty.setWarrantyDuration(warrantyDTO.getWarrantyDuration());
        warranty.setStatus("1");


        //warranty.setTermsAndConditions(terms);
        return warranty;
    }


}
