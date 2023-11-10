package bg.sofia.uni.fmi.mjt.gym.member;

import java.net.spi.InetAddressResolver;
import java.util.Comparator;

public class MemberDistanceComparator implements Comparator<GymMember> {
    private Address address;

    public MemberDistanceComparator(Address address) {
        this.address = address;
    }

    @Override
    public int compare(GymMember member1, GymMember member2) {
        return Double.compare(member1.getAddress().getDistanceTo(address), member2.getAddress().getDistanceTo(address));
    }
}
