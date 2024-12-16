package com.helpdesk.helpdeskApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_service_details")
public class ServiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "details_id")
    private Long serviceDetailsId;

    @Column(name = "service_reason", nullable = false)
    private String serviceReason;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "clerk_id", referencedColumnName = "clerk_id")
    private Clerk clerk;

    @UpdateTimestamp
    @Column(name = "dt_service")
    private LocalDateTime dtService;

    @UpdateTimestamp
    @Column(name = "dt_resolution")
    private LocalDateTime dtResolution;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @JsonIgnore
    private ServiceCall serviceCall;
}
