package bg.sofia.uni.fmi.mjt.space.rocket;

public enum RocketStatus {
    STATUS_RETIRED("StatusRetired"),
    STATUS_ACTIVE("StatusActive");

    private final String value;

    RocketStatus(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    public static RocketStatus fromString(String status) {
        for (RocketStatus rocketStatus : RocketStatus.values()) {
            if (rocketStatus.value.equals(status)) {
                return rocketStatus;
            }
        }
        throw new IllegalArgumentException("Invalid RocketStatus: " + status);
    }
}
