public class BreakHabit extends Habit {
    private int incidentCount;
    private int habitFreeDays;

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
}
