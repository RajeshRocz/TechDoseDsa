package dsa_aug_25.CapitalOne;

import java.util.List;
import java.util.Map;

public class Astronut {
    static String solution(String season, int dayCount, String initialPhase) {
        List<String> lunarPhases = List.of(
                "NewMoon", "Crescent", "Quarter", "Gibbous",
                "Full", "Waning", "Eclipse", "Twilight"
        );

        Map<String, Integer> monthMap = Map.ofEntries(
                Map.entry("January", 0),
                Map.entry("February", 1),
                Map.entry("March", 2),
                Map.entry("April", 3),
                Map.entry("May", 4),
                Map.entry("June", 5),
                Map.entry("July", 6),
                Map.entry("August", 7),
                Map.entry("September", 8),
                Map.entry("October", 9),
                Map.entry("November", 10),   // fixed typo
                Map.entry("December", 11)
        );

        Map<String, Integer> lunarMap = Map.of(
                "NewMoon", 0,
                "Crescent", 1,
                "Quarter", 2,
                "Gibbous", 3,
                "Full", 4,
                "Waning", 5,
                "Eclipse", 6,
                "Twilight", 7
        );

        List<Integer> monthValue = List.of(
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        );

        int month = monthMap.get(season);
        int days = 0;
        for (int i = 0; i < month; i++) {
            days += monthValue.get(i);
        }

        int pos = lunarMap.get(initialPhase);
        int phasePos = (days + pos + dayCount - 1) % 8;  // fixed parentheses + modulo
        return lunarPhases.get(phasePos);
    }

}
