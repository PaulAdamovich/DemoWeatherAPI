package org.demoweatherapi.model;

public class DateRange {
    private String from;
    private String to;

    public DateRange() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
