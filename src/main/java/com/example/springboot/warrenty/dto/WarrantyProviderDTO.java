package com.example.springboot.warrenty.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
/**
 * WarrantyProviderDTO
 *
 * @author Maneesha
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarrantyProviderDTO {

    @NotNull
    private Long id;

    private Date createdAt;

    private Date updatedAt;

    @NotNull
    @Size(min = 2,max = 50)
    private String warrantyProvider;
}
