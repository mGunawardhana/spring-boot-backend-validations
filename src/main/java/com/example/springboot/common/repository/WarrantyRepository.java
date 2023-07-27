package com.example.springboot.common.repository;

import com.example.springboot.common.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Warranty repository
 *
 * @author Maneesha
 */

@Repository
public interface WarrantyRepository extends JpaRepository<Warranty, Integer> {

//    @Query(value = "SELECT Warranty.id,Warranty .warrantyType,Warranty .warrantyProvider," +
//            "Warranty .warrantyCode, Warranty .warrantyName,Warranty .warrantyDescription," +
//            "Warranty .warrantyDuration,GROUP_CONCAT(tac.term) AS terms," +
//            "GROUP_CONCAT(tac.conditions) AS conditions FROM Warranty LEFT JOIN TermsAndConditions tac ON Warranty.id = tac.id GROUP BY Warranty.id",
//            nativeQuery = true)
//
    @Query(value = "SELECT warranty.id,\n" +
            "       warranty.warranty_type,\n" +
            "       warranty.warranty_provider,\n" +
            "       warranty.warranty_code,\n" +
            "       warranty.warranty_name,\n" +
            "       warranty.warranty_description,\n" +
            "       warranty.warranty_duration,\n" +
            "       GROUP_CONCAT(tac.term)           AS terms,\n" +
            "       GROUP_CONCAT(tac.term_condition) AS conditions\n" +
            "FROM warranty\n" +
            "         LEFT JOIN terms_and_conditions tac ON warranty.id = tac.warranty_id\n" +
            "GROUP BY warranty.id;\n" +
            "\n" +
            "SELECT * FROM warranty",nativeQuery = true)
    List<Warranty> getAllWarrantyDetailsWithTermsAndConditions();

}
