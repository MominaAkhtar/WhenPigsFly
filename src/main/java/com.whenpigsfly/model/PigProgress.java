public class PigProgress {
    //score = weekly progress (80%) + streak momentum (20%), always between 0.0 and 1.0
    private static final double PROGRESS_WEIGHT = 0.8;
    private static final double STREAK_WEIGHT = 0.2;
    private static final int STREAK_DAYS_FOR_FULL_SCORE = 3;

    //stage limits
    private static final double GROWING_LIMIT = 0.25;
    private static final double FLYING_LIMIT = 0.55;
    private static final double CLOUD_LIMIT = 0.85;

    private PigStage stage;

    //pig progress constructor - every pig starts as a piglet
    public PigProgress() {
        this.stage = PigStage.PIGLET;
    }

    //turns a score (0.0 - 1.0) into a stage
    public PigStage determineStage(double progress) {
        if (progress >= CLOUD_LIMIT) {
            return PigStage.CLOUD;
        } else if (progress >= FLYING_LIMIT) {
            return PigStage.FLYING;
        } else if (progress >= GROWING_LIMIT) {
            return PigStage.GROWING;
        }
        return PigStage.PIGLET;
    }

    //getter
    public PigStage getStage() {
        return stage;
    }

    //the stage is never set by hand - it is always derived from the statistics
    public void updateFromStatistics(HabitStatistics stats) {
        if (stats == null) {
            throw new IllegalArgumentException("Statistics cannot be null.");
        }
        double weekly = stats.calculateWeeklyProgress();
        double streakPart = Math.min(stats.calculateCurrentStreak(), STREAK_DAYS_FOR_FULL_SCORE)
                / (double) STREAK_DAYS_FOR_FULL_SCORE;
        double score = PROGRESS_WEIGHT * weekly + STREAK_WEIGHT * streakPart;
        stage = determineStage(score);
    }
}


}