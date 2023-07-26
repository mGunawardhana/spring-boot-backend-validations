package com.example.springboot.warrenty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarrantyProviderDTO {

    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private String warrantyProvider;
}
