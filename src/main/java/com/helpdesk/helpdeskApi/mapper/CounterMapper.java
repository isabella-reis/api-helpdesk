package com.helpdesk.helpdeskApi.mapper;
import com.helpdesk.helpdeskApi.model.Counter;
import com.helpdesk.helpdeskApi.model.dto.CounterDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CounterMapper {

    CounterDTO counterToDto(Counter counter);
    Counter dtoToCounter(CounterDTO counterDTO);

}
