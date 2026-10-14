import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.spi.LocaleNameProvider;

import javax.swing.event.HyperlinkEvent.EventType;

public class BreakHabit extends Habit  {
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
        updateHabitFreeDays();
        return habitFreeDays;
    }

    @Override 
    public boolean isSuccessfulOn(LocalDate date){
        return !date.isBefore(getCreatedDate()) && !date.isAfter(LocalDate.now()) && countEvents(EventType.INCIDENT, date, date) == 0;
    }

    @Override 
    public double calculateProgress(){
        LocalDate today = LocalDate.now();
        LocalDate from = currentWeekStart();
        if(getCreatedDate().isAfter(from)){
            from = getCreatedDate();
        }
        if(from.isAfter(today)){
            return 0.0;
        }
        double target = Math.min(7, getWeeklyGoal().getTargetValue());
        if(target <= 0){
            return 0.0;
        }
        double freeDays = countSuccesfulDays(from, today);
        return Math.min(1.0, freeDays/target);

    }

    private void updateHabitFreeDays(){
        LocalDate reference = getCreatedDate();
        for(HabitEvent event : getEvents()){
            if(event.getType() == EventType.INCIDENT && event.getDate().isAfter(reference)){
                reference = event.getDate();
            }
        }
        long days = ChronoUnit.DAYS.between(reference, LocalDate.now());
        habitFreeDays = (int) Math.max(0, days);
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
       updateHabitFreeDays(); 
    }

    public void recordIncident(){
        HabitEvent event = new HabitEvent(getEvents().size() + 1, getID(), LocalDate.now(), EventType.INCIDENT, 1);
        addEvent(event);

        
    }


}
