package com.errorcenter.api.dto;

import java.time.LocalDate;

public interface EventLogFindDTO {
    long getId();
    String getDescription();
    String getLog();
    String getLevel();
    Integer getAmount();
    String getOrigin();
    LocalDate getCreatedAt();}
