package com.helpdesk.helpdeskApi.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCallDTO {
    private Long serviceId;
    private Long customerId;
    private Long deviceId;
    private String serviceStatus;
    private List<ServiceDetailsDTO> serviceDetails;
}
