package com.teracode.hiring.bookings.model;


import java.time.LocalDateTime;
import java.util.List;

public class Meet {
    private User organizer;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<User> participants;

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}
