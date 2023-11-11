package bg.sofia.uni.fmi.mjt.gym;

import bg.sofia.uni.fmi.mjt.gym.member.Address;
import bg.sofia.uni.fmi.mjt.gym.member.GymMember;
import bg.sofia.uni.fmi.mjt.gym.member.MemberDistanceComparator;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Gym implements GymAPI {
    private TreeSet<GymMember> members;
    private final int capacity;
    private Address address;
    private int numberOfMembers;

    public Gym(int capacity, Address address) {
        this.capacity = capacity;
        this.address = address;
        this.members = new TreeSet<>(new MemberDistanceComparator(address));
        this.numberOfMembers = 0;
    }


    /**
     * Returns an unmodifiable copy of all members of the gym.
     * If there are no members, return an empty collection.
     */
    @Override
    public SortedSet<GymMember> getMembers() {
        if (members.isEmpty()) {
            return new TreeSet<>();
        }
        return Collections.unmodifiableSortedSet(members);
    }


    /**
     * Returns an unmodifiable copy of all members of the gym sorted by their name in lexicographic order.
     * If there are no members, return an empty collection.
     */
    @Override
    public SortedSet<GymMember> getMembersSortedByName() {
        TreeSet<GymMember> sortedByName = new TreeSet<>(members);
        return Collections.unmodifiableSortedSet(sortedByName);
    }

    /**
     * Returns an unmodifiable copy of all members of the gym sorted by their proximity to the
     * gym in increasing order. If there are no members, return an empty collection.
     */
    @Override
    public SortedSet<GymMember> getMembersSortedByProximityToGym() {
        return members;
    }

    /**
     * Adds a single member to the gym.
     *
     * @param member the member to add
     * @throws GymCapacityExceededException - if the gym is full
     * @throws IllegalArgumentException     if member is null
     */
    @Override
    public void addMember(GymMember member) throws GymCapacityExceededException {
        if (member == null) {
            throw new IllegalArgumentException("Member is null");
        } else if (numberOfMembers == capacity) {
            throw new GymCapacityExceededException();
        }

        members.add(member);
        numberOfMembers++;
    }

    /**
     * Adds a group of members to the gym. If the gym does not have the capacity to accept all the
     * new members then no members are added
     *
     * @param members the members to add
     * @throws GymCapacityExceededException if the gym is full
     * @throws IllegalArgumentException     if members is null or empty
     */
    @Override
    public void addMembers(Collection<GymMember> members) throws GymCapacityExceededException {
        if (members == null || members.isEmpty()) {
            throw new IllegalArgumentException("Members is null or empty");
        } else if (numberOfMembers == capacity) {
            throw new GymCapacityExceededException();
        } else if (numberOfMembers + members.size() > capacity) throw new GymCapacityExceededException();

        this.members.addAll(members);
    }

    /**
     * Checks if a given member is member of the gym.
     *
     * @param member - the member
     * @throws IllegalArgumentException if member is null
     */
    @Override
    public boolean isMember(GymMember member) {
        if (member == null) {
            throw new IllegalArgumentException("Members is null");
        } else {
            return members.contains(member);
        }
    }

    /**
     * Checks if an Exercise is trained on a given day.
     *
     * @param exerciseName - the name of the Exercise
     * @param day          - the day for which the check is done
     * @throws IllegalArgumentException if day is null or if exerciseName is null or empty
     */
    @Override
    public boolean isExerciseTrainedOnDay(String exerciseName, DayOfWeek day) {
        if (exerciseName == null || exerciseName.isEmpty() || day == null) {
            throw new IllegalArgumentException("Exercise name is null or empty or day is null");
        } else {
            for (GymMember iter : members) {
                if (iter.isExerciseTrainedOnCertainDay(day, exerciseName)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Returns an unmodifiable Map representing each day and the names of the members that do this exercise on it.
     * The map should contain only the days on which at least one member is doing this exercise.
     *
     * @param exerciseName - the name of the exercise being done
     * @throws IllegalArgumentException if exerciseName is null or empty
     */
    @Override
    public Map<DayOfWeek, List<String>> getDailyListOfMembersForExercise(String exerciseName) {
        if (exerciseName == null || exerciseName.isEmpty()) {
            throw new IllegalArgumentException("Exercise name is null or empty");
        } else {
            Map<DayOfWeek, List<String>> result = new EnumMap<>(DayOfWeek.class);
            for (DayOfWeek day : DayOfWeek.values()) {
                if (isExerciseTrainedOnDay(exerciseName, day)) {
                    result.put(day, new ArrayList<>());
                    List<String> listForDay = result.get(day);
                    for (GymMember iter : members) {
                        if (iter.isExerciseTrainedOnCertainDay(day, exerciseName)) {
                            listForDay.add(iter.getName());
                        }
                    }
                }
            }
            return Collections.unmodifiableMap(result);
        }
    }
}
