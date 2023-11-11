package bg.sofia.uni.fmi.mjt.gym.member;

public record Address(double longitude, double latitude) {
    public double getDistanceTo(Address other) {
        return Math.sqrt(Math.pow(Math.abs(longitude - other.longitude), 2)
                + Math.pow(Math.abs(latitude - other.latitude), 2));
    }
}
