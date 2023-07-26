package com.example.springboot.common.repository;

import com.example.springboot.common.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WarrantyRepository extends JpaRepository<Warranty, Integer> {

    @Query(value = "SELECT warranty.id,warranty.warranty_type,warranty.warranty_provider,warranty.warranty_code,warranty.warranty_name,warranty.warranty_description,warranty.warranty_duration,GROUP_CONCAT(tac.term) AS terms,GROUP_CONCAT(tac.term_condition) AS conditions FROM warranty LEFT JOIN terms_and_conditions tac ON warranty.id = tac.warranty_id GROUP BY warranty.id", nativeQuery = true)
    List<Warranty> getAllWarrantyDetailsWithTermsAndConditions();
}
