package com.example.springboot.warrenty.dto;

import com.example.springboot.common.entity.TermsAndConditions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Interface for Receipt service layer.
 *
 * @author Maneesha
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarrantyDTO {

    private Integer id;

    private String warrantyType;

    private String warrantyProvider;

    private String warrantyCode;

    private String warrantyName;

    private String warrantyDescription;

    private String warrantyDuration;

    private String status;

    private List<TermsAndConditions> termsAndConditions;}
