package Lesson5;

public class Employee {
    private String name, position, email, phoneNumber;
    private int salary, age;

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printEmployee() {
        System.out.printf("\nФИО: " + name + "\n" +
                "Должность: " + position + "\n" +
                "Email: " + email + "\n" +
                "Телефон:" + phoneNumber + "\n" +
                "Зарплата: " + salary + "\n" +
                "Возраст: " + age + "\n");
    }

    //вариант вывода информации через переопределение метода toString
    @Override
    public String toString() {
        return
                "\nФИО: " + name + "\n" +
                        "Должность: " + position + "\n" +
                        "Email: " + email + "\n" +
                        "Телефон:" + phoneNumber + "\n" +
                        "Зарплата: " + salary + "\n" +
                        "Возраст: " + age;
    }
}
