package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.dto.DeviceDTO;
import org.springframework.stereotype.Service;

@Service
public interface DeviceService {
    DeviceDTO createNewDevice(DeviceDTO deviceDTO);
    DeviceDTO getDeviceById (Long deviceId);
    void deleteDeviceById(Long deviceId);

    boolean doesDeviceExist(Long deviceId);

}
