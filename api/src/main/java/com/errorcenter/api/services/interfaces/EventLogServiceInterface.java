package com.errorcenter.api.services.interfaces;

import com.errorcenter.api.models.EventLog;

import java.util.List;

public interface EventLogServiceInterface {
    List<EventLog> findAll();
    EventLog save(EventLog eventLog);
}
