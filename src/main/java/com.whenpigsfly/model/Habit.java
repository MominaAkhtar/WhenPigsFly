package com.whenpigsfly.model;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

public abstract class Habit{
    private int ID;
    private String name;
    private String category;
    private WeeklyGoal weeklyGoal;
    private boolean active;
    private boolean archived;
    private ArrayList<HabitEvent> events;
    private ArrayList<FocusSession> sessions;
    private LocalDate createdDate;

    //constructor
    public Habit(int ID, String name, String category, WeeklyGoal weeklyGoal){
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.weeklyGoal = weeklyGoal;
        this.active = true;
        this.archived = false;
        this.events = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }

//getters
    public String getName(){
    return name;
    }

    public String getCategory(){
        return category;
    }

    public int getID(){
        return ID;
    }

    public WeeklyGoal getWeeklyGoal(){
        return weeklyGoal;
    }

    public boolean isActive(){
        return active;
    }

    public boolean isArchived(){
        return archived;
    }

    public ArrayList<HabitEvent> getEvents(){
        return events;
    }

    public ArrayList<FocusSession> getSessions(){
        return sessions;
    }

    public LocalDate getCreatedDate(){
        return createdDate;
    }

    public int countEvents(EventType type, LocalDate from, LocalDate to){
        int count = 0;
        for(HabitEvent event : events){
            if (event.getType() == type && !event.getDate().isBefore(from) && !event.getDate().isAfter(to)){
                count ++;
            }
        }
        return count;
    }
    
    public long focusedMinutesBetween(LocalDate from, LocalDate to){
        long total = 0;
        for(FocusSession session : sessions){
            LocalDate day = session.getStartTime().toLocalDate();
            if(session.getEndTime() != null && !day.isBefore(from) && !day.isAfter(to)){
                total += session.getDurationMinutes();
            }
        }
        return total;
    }

    public int countSuccesfulDays(LocalDate from, LocalDate to){
        int count = 0;
        LocalDate day = from;
        while(!day.isAfter(to)){
            if (isSuccessfulOn(day)){
                count ++;
            }
            day = day.plusDays(1);
        }
        return count;
    }


//setters
    public void setName(String name){
        if(name.isBlank() || name == null){
            throw new IllegalArgumentException("Habit name cannot be empty.");
        }
        this.name = name;
    }

    public void setCategory(String catergory){
        this.category = catergory;
    }

    public void setWeeklyGoal(WeeklyGoal weeklyGoal){
        if(weeklyGoal == null){
            throw new IllegalArgumentException("Weekly goal cannot be empty.");
        }
        this.weeklyGoal = weeklyGoal;
    }

    public void setCreatedDate(LocalDate createdDate){
        if(createdDate != null){
            this.createdDate = createdDate;
        }
    }
    

//method to pause a habit
public void pause(){
    active = false;
}

//method to resume a habit
public void resume(){
    active = true;
    archived = false;
}

//a user can archive any habit
//all the archived habits go inactive, active = false
public void archive(){
    archived = true;
    active = false;
}

//methods to add events and sessions to the array list

public void addEvent(HabitEvent event){
    if(event == null){
        throw new IllegalArgumentException("Event cannot be blank.");
    }
    events.add(event);
}

public void addSession(FocusSession session){
    if(session == null){
        throw new IllegalArgumentException("Session cannot be blank.");
    }
    sessions.add(session);
}



//abstract methods come here below
public abstract double calculateProgress();

public abstract String getHabitType();

public abstract boolean isSuccessfulOn(LocalDate date);

//return local date
public static LocalDate currentWeekStart() {
return LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
}

}