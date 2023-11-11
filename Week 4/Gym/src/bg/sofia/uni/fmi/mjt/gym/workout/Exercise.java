package bg.sofia.uni.fmi.mjt.gym.workout;

import java.util.Objects;

public record Exercise(String name, int sets, int repetitions) {
    public boolean equalsName(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(name, exercise.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void printExercise() {
        System.out.println(name + sets + repetitions);
    }
}
