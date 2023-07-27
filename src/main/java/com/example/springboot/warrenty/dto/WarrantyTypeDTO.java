package com.example.springboot.warrenty.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
/**
 * WarrantyTypeDTO
 *
 * @author Maneesha
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarrantyTypeDTO {

    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private String warrantyType;

}