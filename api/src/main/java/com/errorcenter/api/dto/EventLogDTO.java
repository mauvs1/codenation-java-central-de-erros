package com.errorcenter.api.dto;

import com.errorcenter.api.enums.ELevel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventLogDTO {
    @Column
    @NotNull
    @Size(max = 250)
    private String description;

    @Column
    @NotNull
    @Size(max = 500)
    private String log;

    @Column
    @NotNull
    @Size(max = 250)
    private String origin;

    @Column
    @Min(0)
    private Integer amount = 0;

    @Column
    @Enumerated(EnumType.STRING)
    private ELevel level = ELevel.INFO;
}
