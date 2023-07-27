package com.example.springboot.warrenty.dto;

import com.example.springboot.common.entity.TermsAndConditions;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * WarrantyDTO
 *
 * @author Maneesha
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarrantyDTO {

    @NotNull
    private Integer id;

    @NotNull
    @Size(min = 2,max = 50)
    private String warrantyType;

    @NotNull
    @Size(min = 2,max = 50)
    private String warrantyProvider;

    @NotNull
    @Size(min = 2,max = 10)
    private String warrantyCode;

    @NotNull
    @Size(min = 2,max = 50)
    private String warrantyName;

    private String warrantyDescription;

    @NotNull
    @Size(min = 2,max = 50)
    private String warrantyDuration;

    private String status;

    private List<TermsAndConditionsDTO> termsAndConditions;

}
