package Java2.Lesson3;

import java.util.*;

public class Task1 {

    void doTask1() {
        String[] randomWords = {"cat", "dog", "cat", "dog", "fake",
                "smile", "dog", "fake", "smile", "city", "like", "home",
                "like", "home", "like", "home", "smile", "smile", "smile", "smile"};

        uniqueWordsArray(randomWords);
    }

    private void uniqueWordsArray(String[] array) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : array) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                int i = map.get(s);
                i++;
                map.put(s, i);
            }
        }

        System.out.println("\nTask1\nUnique words from array: " + map.keySet());
        for (Map.Entry<String, Integer> o : map.entrySet()) {
            System.out.println(o.getKey() + " - " + o.getValue());

        }
    }
}
