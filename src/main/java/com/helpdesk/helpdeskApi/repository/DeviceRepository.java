package com.helpdesk.helpdeskApi.repository;

import com.helpdesk.helpdeskApi.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    boolean existsById(Long id);
}
