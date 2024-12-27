package com.helpdesk.helpdeskApi.mapper;
import com.helpdesk.helpdeskApi.model.Counter;
import com.helpdesk.helpdeskApi.model.dto.CounterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CounterMapper {

    CounterMapper INSTANCE = Mappers.getMapper(CounterMapper.class);

    CounterDTO counterToDto(Counter counter);
    Counter dtoToCounter(CounterDTO counterDTO);

}
