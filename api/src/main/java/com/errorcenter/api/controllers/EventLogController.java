package com.errorcenter.api.controllers;

import com.errorcenter.api.Exceptions.ResourceNotFoundException;
import com.errorcenter.api.dto.EventLogDTO;
import com.errorcenter.api.dto.EventLogFindDTO;
import com.errorcenter.api.dto.EventLogResultDTO;
import com.errorcenter.api.dto.UserRegisterDTO;
import com.errorcenter.api.models.EventLog;
import com.errorcenter.api.models.User;
import com.errorcenter.api.services.impl.EventLogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/eventLog")
public class EventLogController {

    @Autowired
    private EventLogService eventLogService;

    @GetMapping
    public List<EventLogResultDTO> findByFilters(@PathParam("description") String description,
                                                 @PathParam("level") String level,
                                                 @PathParam("log") String log,
                                                 @PathParam("origin") String origin,
                                                 @PathParam("amount") Integer amount,
                                                 @PathParam("date") String date,
                                                 @AuthenticationPrincipal User user,
                                                 Pageable pageable) {
        return eventLogService.findByFilters(description, level, log, origin, amount, date, user.getId(), pageable);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Event log not found")})
    public ResponseEntity<EventLogFindDTO> findById(@PathVariable("id") Long id, @AuthenticationPrincipal User user) {
        return new ResponseEntity<EventLogFindDTO>(eventLogService.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("EventLog")), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody EventLogDTO eventLogDTO, @AuthenticationPrincipal User user) {
        eventLogDTO.setUser(user);
        EventLog newLog = eventLogService.save(eventLogDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
