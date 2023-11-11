package bg.sofia.uni.fmi.mjt.gym.workout;

import java.util.List;
import java.util.SequencedCollection;

public record Workout(SequencedCollection<Exercise> exercises) {
    public boolean containsByName(String name) {

        return exercises.getLast().equalsName(name);
    }

    public boolean containsByNameAll(String name) {
        for (Exercise iter : exercises) {
            if (iter.equalsName(name)) {
                return true;
            }
        }
        return false;
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public void addExercises(List<Exercise> exerciseList) {
        exercises.addAll(exerciseList);
    }

    public void printWorkout() {
        for (Exercise exercise : exercises) {
            exercise.printExercise();
        }
    }
}
