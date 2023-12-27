package bg.sofia.uni.fmi.mjt.space.mission;

import java.util.Map;

public class MonthConverter {

    private Map<String, String> months = Map.ofEntries(
        Map.entry("Jan", "01"),
        Map.entry("Feb", "02"),
        Map.entry("Mar", "03"),
        Map.entry("Apr", "04"),
        Map.entry("May", "05"),
        Map.entry("Jun", "06"),
        Map.entry("Jul", "07"),
        Map.entry("Aug", "08"),
        Map.entry("Sep", "09"),
        Map.entry("Oct", "10"),
        Map.entry("Nov", "11"),
        Map.entry("Dec", "12")
    );

    public String convert(String month) {
        if (month == null || month.isEmpty()) {
            throw new IllegalArgumentException("Month is null or empty");
        }
        return months.get(month);
    }


}
