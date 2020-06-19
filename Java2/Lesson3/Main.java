package Java2.Lesson3;

public class Main {
    public static void main(String[] args) {

        new Task1().doTask1();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("+79031234567", "Nik");
        phoneBook.add("+79031234568", "Nik");
        phoneBook.add("+79031234569", "Mike");

        phoneBook.get("Nik");
    }
}
