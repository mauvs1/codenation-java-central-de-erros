package com.errorcenter.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

public interface EventLogResultDTO {


    long getId();


    String getDescription();


    String getLevel();


    Integer getAmount();


    String getOrigin();


    LocalDate getCreatedAt();

}
