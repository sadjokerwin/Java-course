package bg.sofia.uni.fmi.mjt.gym.workout;

import java.util.SequencedCollection;
import java.util.List;

public record Workout(SequencedCollection<Exercise> exercises) {
    public boolean containsByName(String name) {

        return exercises.getLast().equalsName(name);
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
