package com.example.springboot.common.repository;

import com.example.springboot.common.entity.TermsAndConditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsAndConditionsRepository extends JpaRepository<TermsAndConditions,Integer> {
}
