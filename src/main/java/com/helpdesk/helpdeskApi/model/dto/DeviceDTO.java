package com.helpdesk.helpdeskApi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDTO {
    private Long deviceId;
    private String serialNumber;
}
