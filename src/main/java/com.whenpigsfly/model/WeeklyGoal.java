public class WeeklyGoal(){
    private GoalType goalType;
    private double targetValue;
    private String unit;

    //WeeklyGoal constructor
    public WeeklyGoal(GoalType type, double targetValue, String unit){
        this.goalType = type;
        this.targetValue = targetValue;
        this.unit = unit;
    }

    //getters
    public GoalType getGoalType() {
        return goalType;
    }

    public double getTargetValue(){
        return targetValue;
    }

    public String getUnit(){
        return unit;
    }

    //setter
    public void setTargetValue(double value){
        targetValue = value;
    }

    //is ValidTarget

    public boolean isValidTarget(){
        boolean isValidTarget = true;
        if(targetValue <= 0){
            isValidTarget = false;
        }
        return isValidTarget;
    }

    


    


}