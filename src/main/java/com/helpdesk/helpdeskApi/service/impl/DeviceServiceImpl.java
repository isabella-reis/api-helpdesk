package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.mapper.DeviceMapper;
import com.helpdesk.helpdeskApi.model.Device;
import com.helpdesk.helpdeskApi.model.dto.DeviceDTO;
import com.helpdesk.helpdeskApi.repository.DeviceRepository;
import com.helpdesk.helpdeskApi.service.DeviceService;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    @Override
    public boolean doesDeviceExist(Long deviceId) {
        return deviceRepository.existsById(deviceId);
    }

    @Override
    public DeviceDTO createNewDevice(DeviceDTO deviceDTO) {
        Device device = DeviceMapper.INSTANCE.dtoToDevice(deviceDTO);
        Device savedDevice = deviceRepository.save(device);
        return DeviceMapper.INSTANCE.deviceToDto(savedDevice);
    }

    @Override
    public DeviceDTO getDeviceById(Long deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new NoResultException("Device not found."));
        return DeviceMapper.INSTANCE.deviceToDto(device);
    }

    @Override
    public void deleteDeviceById(Long deviceId) {
        if (!deviceRepository.existsById(deviceId)) {
            throw new NoResultException("Device not found.");
        }
        deviceRepository.deleteById(deviceId);
    }
}
