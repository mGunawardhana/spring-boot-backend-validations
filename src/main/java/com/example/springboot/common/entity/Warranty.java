package com.example.springboot.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
/**
 * warranty entity
 *
 * @author Maneesha
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "warranty")
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "warranty_type")
    private String warrantyType;

    @Column(name = "warranty_provider")
    private String warrantyProvider;

    @Column(name = "warranty_code")
    private String warrantyCode;

    @Column(name = "warranty_name")
    private String warrantyName;

    @Column(name = "warranty_description")
    private String warrantyDescription;

    @Column(name = "warranty_duration")
    private String warrantyDuration;

    @Column(name = "status_code")
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(mappedBy = "warranty",cascade = CascadeType.ALL)
    private List<TermsAndConditions> termsAndConditions;
}
