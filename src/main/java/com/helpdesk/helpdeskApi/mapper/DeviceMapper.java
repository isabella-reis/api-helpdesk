package com.helpdesk.helpdeskApi.mapper;
import com.helpdesk.helpdeskApi.model.Device;
import com.helpdesk.helpdeskApi.model.dto.DeviceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    DeviceDTO deviceToDto(Device device);
    Device dtoToDevice(DeviceDTO deviceDTO);

}
