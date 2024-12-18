package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.model.Device;
import com.helpdesk.helpdeskApi.repository.DeviceRepository;
import com.helpdesk.helpdeskApi.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    @Override
    public boolean doesDeviceExist(Long deviceId) {
        return deviceRepository.existsById(deviceId);
    }

    @Override
    public Optional<Device> getDeviceById(Long deviceId) {
        return deviceRepository.findById(deviceId);
    }
}
