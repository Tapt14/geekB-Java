package Java2.Lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    HashMap<String, String> phoneBook = new HashMap<>();

    void add(String number, String surname) {
        phoneBook.put(number, surname);
    }

    void get(String surname) {
        System.out.println("\nTask2\nIf the namesakes:");
        ArrayList<String> phoneNumbers = new ArrayList<>();
        for (Map.Entry<String, String> o : phoneBook.entrySet()) {
            if (o.getValue().equals(surname)) {
                phoneNumbers.add(o.getKey());
                System.out.println(o.getValue() + " - " + o.getKey());
            }
        }

        System.out.println("\nIf the more then one phone Number for one man\n" + surname + " - " + phoneNumbers);
    }
}