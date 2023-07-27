package com.example.springboot.warrenty.dto;

import com.example.springboot.common.entity.Warranty;
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
    private Integer id;

    private String term;

    private String conditions;

    private String status;

    private Warranty warranty;
}
