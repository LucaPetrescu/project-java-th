package lab2;

import java.util.Arrays;
import java.util.Objects;

public final class Schedule {

    private final String owner;
    private final int[] meetings;
    
    public Schedule(String owner, int [] meetingMinutes){
        this.owner = Objects.requireNonNull(owner, "Owner name must not be null");
        this.meetings = Arrays.copyOf(meetingMinutes, meetingMinutes.length);;
    }

    public int[] getMeetings() {
        return Arrays.copyOf(meetings, meetings.length);
    }

    public Schedule withMeeting(int minutes){
        int [] next = Arrays.copyOf(meetings, meetings.length + 1);
        next[next.length - 1] = minutes;
        return new Schedule(owner, next);
    }

    public int totalMinutes() {

        int sum = 0;

        for(int i = 0; i < meetings.length; i++) {
            sum = sum + meetings[i];
        }

        return sum;
    }

    public Schedule merge(Schedule other) {
        int [] combined = new int [meetings.length + other.meetings.length];
        for(int i = 0; i < this.meetings.length; i++) {
            combined[i] = this.meetings[i];
        }

        for(int i = 0; i < other.meetings.length; i++){
            combined[combined.length + i] = other.meetings[i];
        }

        return new Schedule(owner, combined);
    }

    @Override
    public boolean equals(Object o) {

        if(o == this) {
            return true;
        }

        if(!(o instanceof Schedule)) {
            return false;
        }
            
        Schedule s = (Schedule) o;

        return Objects.equals(owner, s.owner) && Arrays.equals(meetings, s.meetings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, Arrays.hashCode(meetings));
    }

    @Override
    public String toString() {
        return "Schedule{owner=" + owner
            + ", meetings=" + Arrays.toString(meetings)
            + ", total=" + totalMinutes() + "min}";
    }

}
