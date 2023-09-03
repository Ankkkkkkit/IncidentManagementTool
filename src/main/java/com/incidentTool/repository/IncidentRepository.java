package com.incidentTool.repository;

import com.incidentTool.entities.Department;
import com.incidentTool.entities.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident,Long> {

    @Query("SELECT i FROM Incident i WHERE i.reporter_id = :reporterId")
    List<Incident> findByReporterId(@Param("reporterId") Long reporterId);
}
