package com.errorcenter.api.services.impl;

import com.errorcenter.api.models.EventLog;
import com.errorcenter.api.repositories.EventLogRepository;
import com.errorcenter.api.services.interfaces.EventLogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventLogService implements EventLogServiceInterface {
    @Autowired
    private EventLogRepository eventLogRepository;

    @Override
    public List<EventLog> findAll() {
        return this.eventLogRepository.findAll();
    }

    @Override
    public EventLog save(EventLog eventLog) {
        return this.eventLogRepository.save(eventLog);
    }
}
