package com.supportwheelfate.supportwheeloffate.controllers;

import com.supportwheelfate.supportwheeloffate.IGlobal;
import com.supportwheelfate.supportwheeloffate.entities.Schedule;
import com.supportwheelfate.supportwheeloffate.response.GETResponse;
import com.supportwheelfate.supportwheeloffate.services.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class SupportScheduleController {

    @Autowired
    IScheduleService scheduleService; // service layer which is contain all of the logic to generate schedule.
    @CrossOrigin(origins = "*")
    @RequestMapping("/schedule")
    GETResponse schedule(@RequestParam(value = "from",required = true) @DateTimeFormat(pattern = IGlobal.DATE_FORMAT) Date fromDate,
                         @RequestParam(value = "n_persons", required = true) Integer nPersons, @RequestParam(value = "days", required = true) Integer days) {
        String[] persons = new String[nPersons]; // Initialize Array of strings
        for (int i = 1; i <= nPersons; i++) {
            persons[i - 1] = "Person-" + i; // Generating N Persons
        }

        return new GETResponse(true, this.scheduleService.schedule(persons, days, fromDate)); // Response
    }
}
