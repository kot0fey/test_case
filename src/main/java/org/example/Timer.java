package org.example;

public class Timer {
    private long timerStartTime;

    public void setTimer() {
        timerStartTime = System.currentTimeMillis();
    }

    public long stopTimer() {
        long now = System.currentTimeMillis();
        return now - timerStartTime;
    }

    public Timer() {
    }
}
