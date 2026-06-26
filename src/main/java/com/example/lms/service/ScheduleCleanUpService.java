package com.example.lms.service;

import com.example.lms.dao.ScheduleRepository;
import com.example.lms.model.Schedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleCleanUpService {
    private final ScheduleRepository scheduleRepository;

    @Scheduled(cron = "${schedule.cleanup.cron}")
    @Transactional
    public void deleteOnSchedule(){
        LocalDateTime oneYearAgo = LocalDateTime.now().minusYears(1);
        List<Schedule> oldSchedules = scheduleRepository.findOlderThanOneYear(oneYearAgo);
        scheduleRepository.deleteAll(oldSchedules);
        log.info("Удалено {} старых расписаний", oldSchedules.size());
    }
}
