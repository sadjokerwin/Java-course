package bg.sofia.uni.fmi.mjt.gym;

import bg.sofia.uni.fmi.mjt.gym.member.Address;
import bg.sofia.uni.fmi.mjt.gym.member.GymMember;
import bg.sofia.uni.fmi.mjt.gym.member.Member;
import bg.sofia.uni.fmi.mjt.gym.member.MemberDistanceComparator;
import com.sun.source.tree.Tree;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Gym implements GymAPI{
    private TreeSet<GymMember> members;
    private int capacity;
    private Address address;

    public Gym(int capacity, Address address) {
        this.capacity = capacity;
        this.address = address;
        this.members = new TreeSet<>(new MemberDistanceComparator(address));
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
        TreeSet<GymMember> sortedByName =  new TreeSet<>(members);
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
        }
        else if ()
    }

    /**
     * Adds a group of members to the gym. If the gym does not have the capacity to accept all the
     * new members then no members are added
     *
     * @param members the members to add
     * @throws GymCapacityExceededException if the gym is full
     * @throws IllegalArgumentException     if members is null or empty
     */
    void addMembers(Collection<GymMember> members) throws GymCapacityExceededException;

    /**
     * Checks if a given member is member of the gym.
     *
     * @param member - the member
     * @throws IllegalArgumentException if member is null
     */
    boolean isMember(GymMember member);

    /**
     * Checks if an Exercise is trained on a given day.
     *
     * @param exerciseName - the name of the Exercise
     * @param day          - the day for which the check is done
     * @throws IllegalArgumentException if day is null or if exerciseName is null or empty
     */
    boolean isExerciseTrainedOnDay(String exerciseName, DayOfWeek day);

    /**
     * Returns an unmodifiable Map representing each day and the names of the members that do this exercise on it.
     * The map should contain only the days on which at least one member is doing this exercise.
     *
     * @param exerciseName - the name of the exercise being done
     * @throws IllegalArgumentException if exerciseName is null or empty
     */
    Map<DayOfWeek, List<String>> getDailyListOfMembersForExercise(String exerciseName);
}
