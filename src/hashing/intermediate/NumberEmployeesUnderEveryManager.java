package hashing.intermediate;

import java.util.*;

public class NumberEmployeesUnderEveryManager {

    public static void main(String[] args) {
        Map<String, String> empManagerMapping = Map.of(
                "A", "C",
                "B", "C",
                "C", "F",
                "D", "E",
                "E", "F",
                "F", "F"
        );

        countNumberOfEmpUnderEveryManager(empManagerMapping);
    }

    private static void countNumberOfEmpUnderEveryManager(Map<String, String> empManagerMapping) {
        Map<String, List<String>> managerEmpMapping = getManagerEmpMapping(empManagerMapping);

        for (String manager : managerEmpMapping.keySet()) {
            List<String> emps = managerEmpMapping.get(manager);
            if(Objects.nonNull(emps)) {
                int count = emps.size();
                for(String s : emps) {
                    List<String> subEmps = managerEmpMapping.get(s);
                    if(Objects.nonNull(subEmps))
                        count += managerEmpMapping.get(s).size();
                }

                System.out.println(manager + " -> " + count);
            }
        }
    }

    private static Map<String, List<String>> getManagerEmpMapping(Map<String, String> empManagerMapping) {
        Map<String, List<String>> mapping = new HashMap<>();

        empManagerMapping.keySet().forEach(s -> {
            String manager = empManagerMapping.get(s);
            if(!manager.equalsIgnoreCase(s)) {
                if (mapping.containsKey(manager)) {
                    mapping.get(manager).add(s);
                } else {
                    List<String> l = new ArrayList<>();
                    l.add(s);
                    mapping.put(manager, l);
                }
            }
        });

        return mapping;
    }
}
