package com.helpdesk.helpdeskApi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCallRequest {
    private Long customerId;
    private Long deviceId;
    private Long productId;
    private Long clerkId;
    private String serviceReason;
}
