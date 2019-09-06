package com.teracode.hiring.bookings.model;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class Room {
    private final long maxTimeInRoom=180;
    private final long minTimeInRoom=15;

    private String name;
    private String location;
    private List<Meet> bookingList;

    public void addMeet(Meet newMeet){
        if(isAvailable(newMeet) && isOnInterval(newMeet)) {
            bookingList.add(newMeet);
        }
    }

    public boolean isAvailable(Meet newMeet) {
        for (Meet meet:bookingList) {
            if(((newMeet.getStart().isAfter(meet.getStart()) || newMeet.getStart().isEqual(meet.getStart()))
                && (newMeet.getEnd().isBefore(meet.getEnd()) || newMeet.getEnd().isEqual(meet.getEnd())))) {
                return false;
            }
        }
        return true;
    }

    public boolean isOnInterval(Meet newMeet) {
        long between = ChronoUnit.MINUTES.between(newMeet.getStart(), newMeet.getEnd());
        if(between>minTimeInRoom && between<180) {
            return true;
        } else return false;
    }
}
