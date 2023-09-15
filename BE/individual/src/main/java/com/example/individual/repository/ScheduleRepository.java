package com.example.individual.repository;

import com.example.individual.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {


    @Query("SELECT s FROM Schedule s WHERE s.username1 = :username OR s.username2 = :username")
    List<Schedule> findSchedulesByUsername(@Param("username") String username);
}
