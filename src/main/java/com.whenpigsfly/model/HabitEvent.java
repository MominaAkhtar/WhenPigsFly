import java.time.LocalDate;

public class HabitEvent{
    private int id;
    private int habitId;
    private LocalDate date;
    private EventType type;
    private double value;
    private String note;

    //HabitEvent constructor
    public HabitEvent(int id, int habitId, LocalDate date, EventType type, double value){
        this.id = id;
        this.habitId = habitId;
        this.date = date;
        this.type = type;
        this.value = value;
        this.note = "";
    }

    //getters 
    public int getId(){
        return id;
    }

    public int getHabitId(){
        return habitId;
    }

    public LocalDate getDate(){
        return date;
    }

    public EventType getType(){
        return type;
    }

    public double getValue(){
        return value;
    }
    
    public String getNote(){
        return note;
    }

    //setter 
    public void setNote(String note){
        this.note = note;
    }
}