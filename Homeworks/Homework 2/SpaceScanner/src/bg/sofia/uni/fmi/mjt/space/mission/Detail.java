package bg.sofia.uni.fmi.mjt.space.mission;

public record Detail(String rocketName, String payload) {
    public Detail {
        if (rocketName == null || rocketName.isEmpty()) {
            throw new IllegalArgumentException("Rocket name is null or empty");
        } else if (payload == null || payload.isEmpty()) {
            throw new IllegalArgumentException("Payload is null or empty");
        }

    }
    public static Detail of(String data) {
        String[] tokens = data.split("\\|");
        return new Detail(tokens[0].trim(), tokens[1].trim().substring(0, tokens[1].trim().length()-1));
    }
}
