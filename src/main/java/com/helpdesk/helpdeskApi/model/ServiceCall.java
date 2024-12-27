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
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "device_id", nullable = false)
    private Device deviceId;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_status", nullable = false)
    private ServiceStatus serviceStatus;

    @OneToMany(mappedBy = "serviceCall")
    private List<ServiceDetails> serviceDetails = new ArrayList<>();
}
