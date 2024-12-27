package com.helpdesk.helpdeskApi.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewServiceCallRequest {
    private ServiceCallDTO serviceCallDTO;
    private ServiceDetailsDTO serviceDetailsDTO;
}
