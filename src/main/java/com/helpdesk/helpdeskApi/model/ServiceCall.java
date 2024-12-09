package com.helpdesk.helpdeskApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_service_calls")
public class ServiceCall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @UpdateTimestamp
    @Column(name = "dt_service")
    private LocalDateTime dtService;

    @UpdateTimestamp
    @Column(name = "dt_resolution")
    private LocalDateTime dtResolution;

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "device_id")
    private Device device;

    @Enumerated(EnumType.STRING)
    private ServiceStatus serviceStatus;

    @OneToMany(mappedBy = "serviceCall")
    private List<ServiceDetails> serviceDetails = new ArrayList<>();
}
