package com.helpdesk.helpdeskApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_counter")
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counter_id")
    private Long counterId;

    @OneToOne
    @JoinColumn(name = "clerk_id", referencedColumnName = "clerk_id", nullable = false)
    private Clerk clerk;
}
