package com.helpdesk.helpdeskApi.service;

import com.helpdesk.helpdeskApi.model.dto.CounterDTO;
import org.springframework.stereotype.Service;

@Service
public interface CounterService {
    CounterDTO createNewCounter(CounterDTO counterDTO);
}
