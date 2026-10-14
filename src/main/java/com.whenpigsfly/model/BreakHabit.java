import java.time.LocalDate;

public class BreakHabit extends Habit {
    private int incidentCount;
    private int habitFreeDays;

    //contructors
    public BreakHabit(int ID, String name, String category, WeeklyGoal weeklyGoal){
        super(ID, name, category, weeklyGoal);
        this.incidentCount = 0;
        this.habitFreeDays = 0;
    }

    //getters
    public int getIncidentCount() {
        return incidentCount;
    }

    public int getHabitFreeDays(){
        return habitFreeDays;
    }

    @Override 
    public String getHabitType(){
        return "Break Habit";
    }

    @Override 
    public void addEvent(HabitEvent event){
        super.addEvent(event);
        if(event.getType() == EventType.INCIDENT){
            incidentCount ++;

        }
        
    }

    public void recordIncident(){
        HabitEvent event = new HabitEvent(getEvents().size() + 1, getID(), LocalDate.now(), EventType.INCIDENT, 1);
        addEvent(event);
        
    }


}
