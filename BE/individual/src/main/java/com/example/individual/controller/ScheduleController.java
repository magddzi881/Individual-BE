package com.example.individual.controller;

import com.example.individual.model.Schedule;
import com.example.individual.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping
    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable("id") Long id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        return optionalSchedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        Schedule createdSchedule = scheduleRepository.save(schedule);
        return ResponseEntity.ok(createdSchedule);
    }
    @GetMapping("/findByUsername")
    public ResponseEntity<List<Schedule>> findSchedulesByUsername(@RequestParam("username") String username) {
        List<Schedule> schedules = scheduleRepository.findSchedulesByUsername(username);

        if (schedules.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(schedules);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable("id") Long id, @RequestBody Schedule updatedSchedule) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();

            // Update the fields based on the provided updatedSchedule
            if (updatedSchedule.getUsername1() != null) {
                schedule.setUsername1(updatedSchedule.getUsername1());
            }
            if (updatedSchedule.getUsername2() != null) {
                schedule.setUsername2(updatedSchedule.getUsername2());
            }
            if (updatedSchedule.getStart() != null) {
                schedule.setStart(updatedSchedule.getStart());
            }
            if (updatedSchedule.getEnd() != null) {
                schedule.setEnd(updatedSchedule.getEnd());
            }
            if (updatedSchedule.getCategory() != null) {
                schedule.setCategory(updatedSchedule.getCategory());
            }

            Schedule updated = scheduleRepository.save(schedule);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable("id") Long id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            scheduleRepository.deleteById(id);
            return ResponseEntity.ok("Deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
