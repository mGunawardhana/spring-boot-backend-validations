package com.example.springboot.common.repository;

import com.example.springboot.common.entity.WarrantyType;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * warranty repository
 *
 * @author Maneesha
 */
public interface WarrantyTypeRepository extends JpaRepository<WarrantyType,Integer> {
}
