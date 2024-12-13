package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.model.Device;
import com.helpdesk.helpdeskApi.repository.DeviceRepository;
import com.helpdesk.helpdeskApi.service.DeviceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Optional<Device> getDeviceById(Long deviceId) {
        return deviceRepository.findById(deviceId);
    }
}
