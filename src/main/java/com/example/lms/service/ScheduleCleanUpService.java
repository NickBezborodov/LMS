package com.example.lms.service;

import com.example.lms.dao.ScheduleRepository;
import com.example.lms.model.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleCleanUpService {
    private final ScheduleRepository scheduleRepository;

    @Scheduled(cron = " 0 0 3 * * ?")
    @Transactional
    public void deleteOnSchedule(){
        LocalDateTime oneYearAgo = LocalDateTime.now().minusYears(1);
        List<Schedule> oldSchedules = scheduleRepository.findOlderThanOneYear(oneYearAgo);
        scheduleRepository.deleteAll(oldSchedules);
        System.out.println("Удалено " + oldSchedules.size() +" старых расписаний");
    }
}
