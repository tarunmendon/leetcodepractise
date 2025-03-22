package src.random;

import java.util.*;
import java.util.stream.Collectors;

public class SortHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("Shana",500);
        map.put("Tarun",100);
        map.put("Taresh",200);
        map.put("Shruthi",170);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // Sort the list using Collections.sort() with custom Comparator
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue()); // Ascending Order
            }
        });

        // Create LinkedHashMap to store sorted values
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Print Sorted Map
        System.out.println("Sorted Map by Value: " + sortedMap);

        /* Sort HashMap in java8*/

        LinkedHashMap output=map.entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).collect(Collectors.toMap(entrySet->entrySet.getKey(),entrySet->entrySet.getValue(),(oldValue,newValue)->oldValue,LinkedHashMap::new));
        System.out.println("Sorted Map by Value- java8 streams: " + sortedMap);
    }
}
