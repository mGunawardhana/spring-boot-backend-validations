package com.example.springboot.common.repository;

import com.example.springboot.common.entity.WarrantyProvider;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * warranty provider repository
 *
 * @author Maneesha
 */
public interface WarrantyProviderRepository extends JpaRepository<WarrantyProvider,Long> {
}
