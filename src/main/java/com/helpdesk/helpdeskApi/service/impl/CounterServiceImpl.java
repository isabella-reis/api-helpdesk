package com.helpdesk.helpdeskApi.service.impl;

import com.helpdesk.helpdeskApi.mapper.CounterMapper;
import com.helpdesk.helpdeskApi.model.Counter;
import com.helpdesk.helpdeskApi.model.dto.CounterDTO;
import com.helpdesk.helpdeskApi.repository.CounterRepository;
import com.helpdesk.helpdeskApi.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {
    private final CounterRepository counterRepository;
    private final CounterMapper counterMapper;

    @Override
    public CounterDTO createNewCounter(CounterDTO counterDTO) {
        Counter counter = counterMapper.dtoToCounter(counterDTO);
        Counter savedCounter = counterRepository.save(counter);
        return counterMapper.counterToDto(savedCounter);
    }
}
