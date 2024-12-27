package com.helpdesk.helpdeskApi.mapper;
import com.helpdesk.helpdeskApi.model.Device;
import com.helpdesk.helpdeskApi.model.dto.DeviceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {

    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    DeviceDTO deviceToDto(Device device);
    Device dtoToDevice(DeviceDTO deviceDTO);

}
