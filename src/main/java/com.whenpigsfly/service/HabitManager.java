import java.util.ArrayList;
import java.util.Iterator;

public class HabitManager {
private ArrayList<Habit> habits;
private int nextHabitId;

//Habit manager constructor
public HabitManager(){
    habits = new ArrayList<Habit>();
}

//getters
public ArrayList<Habit> getAllHabits(){
    return habits;
}

public ArrayList<Habit> getActiveHabits(){
    ArrayList<Habit> activeHabits = new ArrayList<>();
    for(Habit habit : habits){
        if(habit != null && habit.isActive()){
            activeHabits.add(habit);
        }
    }
    return activeHabits;
}

public void addHabit(Habit habit){
    habits.add(habit);
}

public void removeHabit(int id){
    Iterator<Habit> itr = habits.iterator();
    while(itr.hasNext()){
        Habit habit = itr.next();
        if(habit != null && habit.getID() == id){
            itr.remove();
            System.out.println("Habit removed.");
            return;
        }
    }
    System.out.println("Habit not found.");
}

public Habit findHabitById(int id){
    for(Habit habit : habits){
        if (habit != null && habit.getID() == id){
            return habit;
        }
    }
    return null;
}


public void pauseHabit(int id){
    for(Habit habit : habits){
        if(habit != null && habit.getID() == id){
            habit.pause();
            System.out.println("Habit paused.");
            return;
        }
    }
    System.out.println("Habit not found.");
}

public void resumeHabit(int id){
    for(Habit habit : habits){
        if(habit != null && habit.getID() == id){
            habit.resume();
            System.out.println("Habit resumed.");
            return;
        }
    }
    System.out.println("Habit not found.");
}

public void archiveHabit(int id){
    for(Habit habit : habits){
        if(habit != null && habit.getID() == id){
            habit.archive();
            System.out.println("Habit archived.");
            return;
        }
    }
    System.out.println("Habit not found.");
}

public ArrayList<Habit> searchHabits(String keyword){
    ArrayList<Habit> foundHabits = new ArrayList<>();
    for(Habit habit : habits){
        if (habit!= null && habit.getName() != null && habit.getName().toLowerCase().contains(keyword.toLowerCase())){
            foundHabits.add(habit);
        }
    }
    return foundHabits;
}
    
}
