package com.supportwheelfate.supportwheeloffate.services;

import com.supportwheelfate.supportwheeloffate.entities.Schedule;

import java.util.Date;
import java.util.List;

public interface IScheduleService {

    /**
     *  @param persons list of persons.
     *  @param days total number of days to generate schedule.
     *  @param startDate date from where we have to start schedule.
     * */
    List<Schedule> schedule(String[] persons, int days, Date startDate);
}
