import java.time.LocalDateTime;

public class FocusSession{
    private int id;
    private int habitId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long pausedSeconds;
    private String note;

    //focus session constructor
    public FocusSession(int id, int habitId, LocalDateTime start){
        this.id = id;
        this.habitId = habitId;
        this.startTime = start;
    }

    //finish focus session
    public void finish(LocalDateTime end){
        endTime = end;
    }

    //getters
    public long getDurationMinutes(){
        return pausedSeconds;
    }

    public int getHabitId() {
        return habitId;
    }

    public LocalDateTime getStartTime(){
        return startTime;
    }

    public LocalDateTime getEndTime(){
        return endTime;
    }

    public String getNote(){
        return note;
    }

    public void setNote(String note){
        this.note = note;
    }

}