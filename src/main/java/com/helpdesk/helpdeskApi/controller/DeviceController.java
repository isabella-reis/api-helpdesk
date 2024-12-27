package com.helpdesk.helpdeskApi.controller;

import com.helpdesk.helpdeskApi.model.dto.DeviceDTO;
import com.helpdesk.helpdeskApi.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<DeviceDTO> createNewDevice(@RequestBody DeviceDTO deviceDTO) {
        DeviceDTO newDevice = deviceService.createNewDevice(deviceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDevice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDTO> getDeviceById(@PathVariable Long id){
        DeviceDTO deviceDTO = deviceService.getDeviceById(id);
        return ResponseEntity.ok(deviceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDeviceById(@PathVariable Long id){
        deviceService.deleteDeviceById(id);
    }
}
