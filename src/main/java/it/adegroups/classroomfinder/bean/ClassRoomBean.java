package it.adegroups.classroomfinder.bean;

import it.adegroups.classroomfinder.model.DaysOfWeek;

import java.time.LocalTime;

public class ClassRoomBean {
    private String room;
    private DaysOfWeek day;
    private boolean lecture;
    private LocalTime time;

    public ClassRoomBean(String className, DaysOfWeek day, boolean lecture, LocalTime time) {
        this.room = className;
        this.day = day;
        this.lecture = lecture;
        this.time = time;
    }

    public String getRoom() {
        return room;
    }

    public boolean isLecture() {
        return lecture;
    }

    public LocalTime getTime() {
        return time;
    }

    public DaysOfWeek getDay() {
        return day;
    }

    public void setDay(DaysOfWeek day) {
        this.day = day;
    }
}
