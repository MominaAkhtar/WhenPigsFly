package com.whenpigsfly.model;
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
    

//setters
    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String catergory){
        this.category = catergory;
    }

    public void setWeeklyGoal(WeeklyGoal weeklyGoal){
        this.weeklyGoal = weeklyGoal;
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
    events.add(event);
}

public void addSession(FocusSession session){
    sessions.add(session);
}

//abstract methods come here below
public abstract double calculateProgress();

public abstract String getHabitType();

}