package com.helpdesk.helpdeskApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_clerk")
public class Clerk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clerk_id")
    private Long clerkId;

    @Column(name = "name", nullable = false)
    private String name;
}
