package bg.sofia.uni.fmi.mjt.space.rocket;

import java.util.Optional;

public record Rocket(String id, String name, Optional<String> wiki, Optional<Double> height) {
    public Rocket {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id is null or empty");
        } else if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is null or empty");
        }
    }
}
