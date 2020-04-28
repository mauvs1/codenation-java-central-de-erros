package com.errorcenter.api.services.interfaces;

import com.errorcenter.api.dto.EventLogDTO;
import com.errorcenter.api.dto.EventLogResultDTO;
import com.errorcenter.api.models.EventLog;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventLogServiceInterface {

    Optional<EventLog> findByIdAndUserId(long id, long userId);

    EventLog save(EventLogDTO eventLogDTO);

    List<EventLogResultDTO> findByFilters(String description,
                                          String level,
                                          String log,
                                          String origin,
                                          Integer amount,
                                          String date,
                                          Long userId,
                                          Pageable pageable);
}
