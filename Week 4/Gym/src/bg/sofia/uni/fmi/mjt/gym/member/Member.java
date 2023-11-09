package bg.sofia.uni.fmi.mjt.gym.member;

import bg.sofia.uni.fmi.mjt.gym.workout.Exercise;
import bg.sofia.uni.fmi.mjt.gym.workout.Workout;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedMap;

public class Member implements GymMember{
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
            if (Workout)
        }
    }



}
