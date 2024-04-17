package it.adegroups.classroomfinder.model;

import java.time.LocalTime;

public class ClassRoom {
    private String room;
    private DaysOfWeek days;
    private boolean lecture;
    private LocalTime time;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public DaysOfWeek getDays() {
        return days;
    }

    public void setDays(DaysOfWeek days) {
        this.days = days;
    }

    public boolean isLecture() {
        return lecture;
    }

    public void setLecture(boolean lecture) {
        this.lecture = lecture;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
