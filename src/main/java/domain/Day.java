package domain;

public class Day {
    private Weekday weekday;

    public Day(Weekday weekday){
        this.weekday = weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    public Weekday getWeekday() {
        return weekday;
    }
}
