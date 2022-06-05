package hashing.intermediate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class FindItineraryFromListOfTickets {

    public static void main(String[] args) {
        Map<String, String> tickets = Map.of(
                "Chennai","Banglore",
                "Bombay", "Delhi",
                "Goa", "Chennai",
                "Delhi","Goa");

        printJourney(tickets);
    }

    private static void printJourney(Map<String, String> tickets) {

        String startingPoint = getStartingPoint(tickets);

        while(Objects.nonNull(startingPoint)) {
            String dest = tickets.get(startingPoint);
            if(Objects.nonNull(dest))
                System.out.print(startingPoint + "->" + dest + ",\t");
            startingPoint = dest;
        }
    }

    // By assuming that starting point will never be a destination and there will be no cycle.
    private static String getStartingPoint(Map<String, String> tickets) {
        Set<String> allStartingPoints = tickets.keySet();

        // reverse the map
        Map<String, String> reversedTickets = new HashMap<>();
        allStartingPoints.forEach(s -> reversedTickets.put(tickets.get(s), s));

        for(String s : allStartingPoints) {
            if(!reversedTickets.containsKey(s))
                return s;
        }

        return null;
    }
}
