package com.helpdesk.helpdeskApi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CounterDTO {
    private Long counterId;
    private ClerkDTO clerk;
}
