package com.example.springboot.warrenty.dto;

import com.example.springboot.common.entity.Warranty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * TermsAndConditionDTO
 *
 * @author Maneesha
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TermsAndConditionsDTO {

    @NotNull
    @Size(min = 0,max = 50)
    private Integer id;

    private String term;

    private String conditions;

    private String status;

    @NotNull
    @Size(min = 0,max = 50)
    private  Integer warrantyId;

}
