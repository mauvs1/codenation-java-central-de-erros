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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventLogDTO {

    @NotNull(message = "Não pode ser nulo")
    @NotEmpty(message = "Deve conter um valor")
    @Size(min = 3, max = 250)
    private String description;

    @NotNull(message = "Não pode ser nulo")
    @NotEmpty(message = "Deve conter um valor")
    @Size(min = 3, max = 500)
    private String log;

    @NotNull(message = "Não pode ser nulo")
    @NotEmpty(message = "Deve conter um valor")
    @Size(min = 3, max = 250)
    private String origin;

    @Min(value = 1, message = "Deve ser maior ou igual a 1")
    private Integer amount = 1;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Deve conter um valor")
    private ELevel level = ELevel.INFO;
}
