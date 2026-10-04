import java.time.LocalDate;

public class HabitEvent{
    int id;
    int habitId;
    LocalDate date;
    EventType type;
    double value;
    String note;

    //HabitEvent constructor
    public HabitEvent(int id, int habitId, LocalDate date, EventType type, double value){
        this.id = id;
        this.habitId = habitId;
        this.date = date;
        this.type = type;
        this.value = value;
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