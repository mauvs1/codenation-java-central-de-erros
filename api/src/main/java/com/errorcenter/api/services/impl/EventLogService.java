package com.errorcenter.api.services.impl;

import com.errorcenter.api.dto.EventLogDTO;
import com.errorcenter.api.dto.EventLogFindDTO;
import com.errorcenter.api.dto.EventLogResultDTO;
import com.errorcenter.api.enums.ELevel;
import com.errorcenter.api.models.EventLog;
import com.errorcenter.api.models.User;
import com.errorcenter.api.repositories.EventLogRepository;
import com.errorcenter.api.services.interfaces.EventLogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@Service
public class EventLogService implements EventLogServiceInterface {
    @Autowired
    private EventLogRepository eventLogRepository;

    @Override
    public Optional<EventLogFindDTO> findByIdAndUserId(long id, long userId) {
        return eventLogRepository.findByIdAndUserId(id, userId);
    }

    @Override
    public EventLog save(EventLogDTO eventLogDTO) {
        EventLog model = new EventLog(eventLogDTO.getDescription(), eventLogDTO.getLog(),
                eventLogDTO.getOrigin(),
                eventLogDTO.getAmount(),
                eventLogDTO.getLevel(),
                eventLogDTO.getUser());
        return this.eventLogRepository.save(model);
    }

    @Override
    public List<EventLogResultDTO> findByFilters(String description,
                                                 String level,
                                                 String log,
                                                 String origin,
                                                 Integer amount,
                                                 String date,
                                                 Long userId,
                                                 Pageable pageable) {
        amount = amount != null ? amount : 1;
        return this.eventLogRepository.findByFilters(description, level, log, origin, amount, userId, pageable).getContent();
    }
}
