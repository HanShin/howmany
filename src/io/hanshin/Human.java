package io.hanshin;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Human {
    private int number;
    private LocalTime startTime;
    private LocalTime endTime;

    private Human(){
    }

    public Human(int number, String startTime, String endTime){
        this.number = number;
        this.startTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("H:m:s"));
        this.endTime = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("H:m:s"));
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
