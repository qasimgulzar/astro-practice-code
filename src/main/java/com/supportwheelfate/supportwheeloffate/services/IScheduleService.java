package com.supportwheelfate.supportwheeloffate.services;

import com.supportwheelfate.supportwheeloffate.entities.Schedule;

import java.util.Date;
import java.util.List;

public interface IScheduleService {
    List<Schedule> schedule(String[] persons, int days, Date startDate);
}
