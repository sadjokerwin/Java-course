import bg.sofia.uni.fmi.mjt.gym.member.Address;
import bg.sofia.uni.fmi.mjt.gym.member.Gender;
import bg.sofia.uni.fmi.mjt.gym.member.Member;
import bg.sofia.uni.fmi.mjt.gym.workout.Exercise;
import bg.sofia.uni.fmi.mjt.gym.workout.Workout;

import java.time.DayOfWeek;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

//        write tests for Member class

        Exercise exercise = new Exercise("Bench press", 4, 10);
        Exercise exercise2 = new Exercise("Dumbell press", 4, 10);
        Exercise exercise3 = new Exercise("Overhead press", 4, 10);
        Exercise exercise4 = new Exercise("Leg press", 4, 10);

        ArrayList<Exercise> exercises1 = new ArrayList<Exercise>();
        exercises1.add(exercise);
        exercises1.add(exercise2);
        exercises1.add(exercise3);

        ArrayList<Exercise> exercises2 = new ArrayList<Exercise>();
//        exercises2.add(exercise3);
        exercises2.add(exercise4);
        Workout workout = new Workout(exercises1);
        Workout workout2 = new Workout(exercises2);

        //
        Member member = new Member(new Address(12, 23), "gosheto", 19, "3215412", Gender.MALE);


        member.setWorkout(DayOfWeek.MONDAY, workout);
        member.setWorkout(DayOfWeek.TUESDAY, workout2);

//        member.printTrainingProgram();
//
        System.out.println(member.isExerciseTrainedOnCertainDay(DayOfWeek.MONDAY, "Overhead press"));

//for (DayOfWeek day : DayOfWeek.values()) {
//    System.out.println(day);
//}
    }
}