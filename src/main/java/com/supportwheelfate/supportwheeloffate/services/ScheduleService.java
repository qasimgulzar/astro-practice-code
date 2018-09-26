package com.supportwheelfate.supportwheeloffate.services;

import com.supportwheelfate.supportwheeloffate.entities.Person;
import com.supportwheelfate.supportwheeloffate.entities.Schedule;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class ScheduleService implements IScheduleService {

    /**
     *  @param persons list of persons.
     *  @param days total number of days to generate schedule.
     *  @param startDate date from where we have to start schedule.
     * */
    @Override
    public List<Schedule> schedule(String[] persons, int days, Date startDate) {
        /*Schedule is driver function to generate schedule*/
        List persion_names = Arrays.asList(persons);
        List<Schedule> duties = new ArrayList<Schedule>();
        Collections.shuffle(persion_names);
        /* Here we are populating slots of support */
        for (int i = 1; i <= days; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            cal.add(Calendar.DATE, i);
            duties.add(new Schedule(cal.getTime(), new Person(persons[(i - 1) % persons.length]))); // assigning day slots to persons
        }

        for (Schedule schedule : duties) {
            Person person = this.getValidPersion(schedule.getDate(), duties, persons); // Find best person for the current night shift.
            schedule.setNight_shift_engineer(person);
        }
        return duties;
    }
    /**
     * @param date date of current slot for which we are finding engineer.
     * @param duties list of schedules
     * @param persons list all persons
     * */
    private Person getValidPersion(Date date, List<Schedule> duties, String[] persons) {
        List<String> nonConsecutive = new ArrayList<String>();
        for (Schedule schedule : duties) {
            for (String person : persons) {
                if (!this.isConsecutive(date, duties, person)) {
                    nonConsecutive.add(person);
                }
            }
        }
        return this.getLeastScheduledPerson(duties, nonConsecutive);
    }
    /**
     * @param date date for which we are looking that given person has any consecutive shift or not.
     * @param duties list of schedules.
     * @param person name of the person to which we are comparing.
     * */
    private boolean isConsecutive(Date date, List<Schedule> duties, String person) {
        boolean flag = false;
        for (Schedule schedule : duties) {
            long diffInMillies = Math.abs(schedule.getDate().getTime() - date.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if (diff == 0 || diff == 1) {
                if (schedule.getDay_shift_engineer() != null)
                    if (schedule.getDay_shift_engineer().getName().equals(person))
                        flag = true;
                if (schedule.getNight_shift_engineer() != null)
                    if (schedule.getNight_shift_engineer().getName().equals(person))
                        flag = true;
            }
        }
        return flag;
    }
    /**
     * @param duties list of slots
     * @param nonConsecutive list of nonConsecutive persons
     * */
    private Person getLeastScheduledPerson(List<Schedule> duties, List<String> nonConsecutive) {
        int min = -1;
        String p = null;
        for (String person : nonConsecutive) {
            int ocr = 0;
            for (Schedule schedule : duties) {
                if (schedule.getNight_shift_engineer() != null) {
                    if (schedule.getNight_shift_engineer().getName().equals(person)) {
                        ocr += 1;
                    }
                }
                if (schedule.getDay_shift_engineer() != null) {
                    if (schedule.getDay_shift_engineer().getName().equals(person)) {
                        ocr += 1;
                    }
                }
            }
            if (min == -1) {
                min = ocr;
                p = person;
            }
            if (min > ocr) {
                min = ocr;
                p = person;
            }
        }
        return new Person(p);
    }
}
