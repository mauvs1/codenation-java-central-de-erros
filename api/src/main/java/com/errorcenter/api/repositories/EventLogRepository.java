package com.errorcenter.api.repositories;

import com.errorcenter.api.models.EventLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventLogRepository extends JpaRepository<EventLog, Long> {

    @Query(value = "SELECT * FROM event_log el" +
            " WHERE (UPPER(el.description) LIKE UPPER(concat('%', :description,'%')) OR :description IS NULL)" +
            " AND" +
            " (UPPER(el.level) LIKE UPPER(concat('%', :level,'%')) OR :level IS NULL)" +
            " AND " +
            " (UPPER(el.log) LIKE UPPER(concat('%', :log,'%')) OR :log IS NULL)" +
            " AND" +
            " (UPPER(el.origin) LIKE UPPER(concat('%', :origin,'%')) OR :origin IS NULL)" +
            " AND" +
            " (el.amount = :amount)"
            , nativeQuery = true)
    Page<EventLog> findByFilters(
            @Param("description") String description,
            @Param("level") String level,
            @Param("log") String log,
            @Param("origin") String origin,
            @Param("amount") Integer amount,
            Pageable pageable
            //@Param("date") String date
    );

}
