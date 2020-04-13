package com.errorcenter.api.models;

import com.errorcenter.api.enums.ELevel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * EventLog
 */
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "event_log")
public class EventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

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

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDate createdAt;

    @Column
    @Min(0)
    private Integer amount = 0;

    @Column
    @Enumerated(EnumType.STRING)
    private ELevel level = ELevel.INFO;

    @ManyToOne
    @JoinColumn
    private User user;

}