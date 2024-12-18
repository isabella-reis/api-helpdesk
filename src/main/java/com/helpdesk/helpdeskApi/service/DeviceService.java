package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.Device;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DeviceService {
    Optional<Device> getDeviceById (Long deviceId);
    boolean doesDeviceExist(Long deviceId);
}
