package com.errorcenter.api.controllers;

import com.errorcenter.api.models.EventLog;
import com.errorcenter.api.services.impl.EventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventLog")
public class EventLogController {

    @Autowired
    private EventLogService eventLogService;

    @GetMapping
    public List<EventLog> findAll() {
        return eventLogService.findAll();
    }

    @PostMapping
    public EventLog save(@RequestBody EventLog eventLog) {
        return eventLogService.save(eventLog);
    }
}
