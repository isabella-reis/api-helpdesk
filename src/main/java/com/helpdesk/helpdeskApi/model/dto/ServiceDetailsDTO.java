package com.helpdesk.helpdeskApi.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDetailsDTO {
    private Long serviceDetailsId;
    private String serviceReason;
    private Long productId;
    private Long customerId;
    private Long clerkId;
    private LocalDateTime dtService;
    private LocalDateTime dtResolution;
}
