package com.helpdesk.helpdeskApi.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClerkDTO {
    private Long clerkId;
    private String name;
}
