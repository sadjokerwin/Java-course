package bg.sofia.uni.fmi.mjt.gym.workout;

import java.util.SequencedCollection;

public record Workout(SequencedCollection<Exercise> exercises) {
    public boolean containsByName(String name) {
        for (Exercise iter : exercises) {
            if (iter.equalsName(name)) {
                return true;
            }
        }
        return false;
    }
}
