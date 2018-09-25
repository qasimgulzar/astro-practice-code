package com.supportwheelfate.supportwheeloffate.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import com.supportwheelfate.supportwheeloffate.IGlobal;

public class Schedule {
    private Date date;
    private Person night_shift_engineer;
    private Person day_shift_engineer;

    public Schedule(Date date, Person day_shift_engineer) {
        this.date = date;
        this.day_shift_engineer = day_shift_engineer;
    }

    @JsonFormat(pattern = IGlobal.DATE_FORMAT)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getNight_shift_engineer() {
        return night_shift_engineer;
    }

    public void setNight_shift_engineer(Person night_shift_engineer) {
        this.night_shift_engineer = night_shift_engineer;
    }

    public Person getDay_shift_engineer() {
        return day_shift_engineer;
    }

    public void setDay_shift_engineer(Person day_shift_engineer) {
        this.day_shift_engineer = day_shift_engineer;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "date='" + date + '\'' +
                ", night_shift_engineer=" + night_shift_engineer +
                ", day_shift_engineer=" + day_shift_engineer +
                '}';
    }
}
