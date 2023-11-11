package bg.sofia.uni.fmi.mjt.gym.member;

import bg.sofia.uni.fmi.mjt.gym.workout.Exercise;
import bg.sofia.uni.fmi.mjt.gym.workout.Workout;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Member implements GymMember, Comparable<GymMember> {
    private String name;
    private int age;
    private String personalIdNumber;
    private Gender gender;
    private Address address;
    private EnumMap<DayOfWeek, Workout> trainingProgram;

    public Member(Address address, String name, int age, String personalIdNumber, Gender gender) {
        this.name = name;
        this.age = age;
        this.personalIdNumber = personalIdNumber;
        this.gender = gender;
        this.address = address;
        this.trainingProgram = new EnumMap<DayOfWeek, Workout>(DayOfWeek.class);
    }

    @Override
    public int compareTo(GymMember other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public Map<DayOfWeek, Workout> getTrainingProgram() {
        return trainingProgram;
    }

    @Override
    public void setWorkout(DayOfWeek day, Workout workout) {
        if (day == null || workout == null) {
            throw new IllegalArgumentException("Day or workout is null");
        }

        trainingProgram.put(day, workout);
    }

    @Override
    public Collection<DayOfWeek> getDaysFinishingWith(String exerciseName) {
        if (exerciseName == null || exerciseName.isEmpty()) {
            throw new IllegalArgumentException("Exercise Name is null or empty");
        }

        ArrayList<DayOfWeek> result = new ArrayList<>();

        for (Map.Entry<DayOfWeek, Workout> iter : trainingProgram.entrySet()) {
            if (iter.getValue().containsByName(exerciseName)) {
                result.add(iter.getKey());
            }
        }

        return result;
    }

    @Override
    public void addExercise(DayOfWeek day, Exercise exercise) {
        if (day == null || exercise == null) {
            throw new IllegalArgumentException("Day or exercise is null");
        } else if (!trainingProgram.containsKey(day)) {
            throw new DayOffException();
        }

        for (Map.Entry<DayOfWeek, Workout> iter : trainingProgram.entrySet()) {
            if (iter.getKey().equals(day)) {
                iter.getValue().addExercise(exercise);
                return;
            }
        }

    }

    @Override
    public void addExercises(DayOfWeek day, List<Exercise> exercises) {
        if (day == null || exercises == null || exercises.isEmpty()) {
            throw new IllegalArgumentException("Day or exercise is null");
        } else if (!trainingProgram.containsKey(day)) {
            throw new DayOffException();
        }

        for (Map.Entry<DayOfWeek, Workout> iter : trainingProgram.entrySet()) {
            if (iter.getKey().equals(day)) {
                iter.getValue().addExercises(exercises);
                return;
            }
        }
    }

    public void printTrainingProgram() {
        for (Map.Entry<DayOfWeek, Workout> iter : trainingProgram.entrySet()) {
            System.out.println(iter.getKey());
            iter.getValue().printWorkout();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(personalIdNumber, member.personalIdNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalIdNumber);
    }

    @Override
    public boolean isExerciseTrainedOnCertainDay(DayOfWeek day, String exerciseName) {
        if (!trainingProgram.containsKey(day)) {
            return false;
        }
        for (Map.Entry<DayOfWeek, Workout> iter : trainingProgram.entrySet()) {
            if (iter.getKey().equals(day)) {
                return iter.getValue().containsByNameAll(exerciseName);
            }
        }
        return true;
    }
}
