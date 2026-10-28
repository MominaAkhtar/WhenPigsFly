import java.time.LocalDate;

public class HabitStatistics {
private Habit habit;
private double[] dailyProgress; //Monday - Sunday of the current week

//Habit Statistics constructor
public HabitStatistics(Habit habit) {
if (habit == null) {
throw new IllegalArgumentException("Habit cannot be null.");
}
this.habit = habit;
this.dailyProgress = new double[7];
updateDailyProgress();
}

//weekly progress from 0.0 to 1.0 - each habit type calculates its own (polymorphism)
public double calculateWeeklyProgress() {
return habit.calculateProgress();
}

//total focus minutes of all finished sessions
public long calculateTotalFocusMinutes() {
long total = 0;
for (FocusSession session : habit.getSessions()) {
if (session.getEndTime() != null) {
total += session.getDurationMinutes();
}
}
return total;
}

//average minutes per finished session, 0 if there are none
public double calculateAverageSessionMinutes() {
int finished = 0;
for (FocusSession session : habit.getSessions()) {
if (session.getEndTime() != null) {
finished++;
}
}
if (finished == 0) {
return 0.0;
}
return (double) calculateTotalFocusMinutes() / finished;
}

//consecutive successful days up to today
//if today is not done yet the streak is still alive from yesterday
public int calculateCurrentStreak() {
LocalDate day = LocalDate.now();
if (!habit.isSuccessfulOn(day)) {
day = day.minusDays(1);
}
int streak = 0;
while (habit.isSuccessfulOn(day)) {
streak++;
day = day.minusDays(1);
}
return streak;
}

//longest run of successful days in the habit's history
public int calculateLongestStreak() {
LocalDate today = LocalDate.now();
LocalDate day = findFirstDate();
int longest = 0;
int run = 0;
while (!day.isAfter(today)) {
if (habit.isSuccessfulOn(day)) {
run++;
if (run > longest) {
longest = run;
}
} else {
run = 0;
}
day = day.plusDays(1);
}
return longest;
}

//number of successful days in the current week
public int getSuccessfulDays() {
updateDailyProgress();
int count = 0;
for (double value : dailyProgress) {
if (value > 0) {
count++;
}
}
return count;
}

//array of 7 values (Monday = index 0): 1.0 = successful day, 0.0 = not
//a copy is returned so the original array stays protected
public double[] getDailyProgress() {
updateDailyProgress();
return dailyProgress.clone();
}

//fills the seven-element array for the current week
private void updateDailyProgress() {
LocalDate monday = Habit.currentWeekStart();
for (int i = 0; i < dailyProgress.length; i++) {
dailyProgress[i] = habit.isSuccessfulOn(monday.plusDays(i)) ? 1.0 : 0.0;
}
}

//earliest date that has any data for the habit
private LocalDate findFirstDate() {
LocalDate first = habit.getCreatedDate();
for (HabitEvent event : habit.getEvents()) {
if (event.getDate().isBefore(first)) {
first = event.getDate();
}
}
for (FocusSession session : habit.getSessions()) {
LocalDate day = session.getStartTime().toLocalDate();
if (day.isBefore(first)) {
first = day;
}
}
return first;
}
}



