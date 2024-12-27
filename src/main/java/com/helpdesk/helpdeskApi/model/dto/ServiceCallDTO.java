package com.helpdesk.helpdeskApi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCallDTO {
    private Long serviceId;
    private Long customerId;
    private Long deviceId;
    private String serviceStatus;
    private ServiceDetailsDTO serviceDetails;
}
