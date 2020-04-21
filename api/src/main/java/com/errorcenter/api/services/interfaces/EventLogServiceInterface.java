package com.errorcenter.api.services.interfaces;

import com.errorcenter.api.dto.EventLogDTO;
import com.errorcenter.api.models.EventLog;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventLogServiceInterface {
    List<EventLog> findAll();

    EventLog save(EventLogDTO eventLogDTO);

    List<EventLog> findByFilters(String description,
                                 String level,
                                 String log,
                                 String origin,
                                 Integer amount,
                                 String date,
                                 Pageable pageable);
}
