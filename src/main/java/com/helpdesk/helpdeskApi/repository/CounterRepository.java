package com.helpdesk.helpdeskApi.repository;

import com.helpdesk.helpdeskApi.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Counter, Long> {
}
