package bg.sofia.uni.fmi.mjt.gym.workout;

public record Exercise(String name, int sets, int repetitions) {
    public boolean equalsName (String name) {
        return this.name.equals(name);
    }
}
