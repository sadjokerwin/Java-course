package bg.sofia.uni.fmi.mjt.football;

import java.time.LocalDate;
import java.util.List;

public record Player(String name, String fullName, LocalDate birthDate, int age, double heightCm,
                     double weightKg, List<Position> positions, String nationality, int overallRating,
                     int potential, long valueEuro, long wageEuro, Foot preferredFoot) {

    @Override
    public String name() {
        return name;
    }

    @Override
    public String fullName() {
        return fullName;
    }

    @Override
    public LocalDate birthDate() {
        return birthDate;
    }

    @Override
    public int age() {
        return age;
    }

    @Override
    public double heightCm() {
        return heightCm;
    }

    @Override
    public double weightKg() {
        return weightKg;
    }

    @Override
    public List<Position> positions() {
        return positions;
    }

    @Override
    public String nationality() {
        return nationality;
    }

    @Override
    public int overallRating() {
        return overallRating;
    }

    @Override
    public int potential() {
        return potential;
    }

    @Override
    public long valueEuro() {
        return valueEuro;
    }

    @Override
    public long wageEuro() {
        return wageEuro;
    }

    @Override
    public Foot preferredFoot() {
        return preferredFoot;
    }
}
