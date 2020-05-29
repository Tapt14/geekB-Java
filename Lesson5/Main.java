package Lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Баринов Вячеслав Владимирович", "Директор бани", "Barin@banya.ru", "+7(900)433-2727", 200000, 51);
        employees[1] = new Employee("Самарина Виолетта Игоревна ", "Бухгалтер", "Bukh@banya.ru", "+7(900)433-2731", 100000, 44);
        employees[2] = new Employee("Куликов Сергей Петрович", "Старший банщик", "Petrovich@banya.ru", "+7(900)433-2739", 65000, 61);
        employees[3] = new Employee("Лом Александр Викторович", "Банщик", "Sanya@banya.ru", "+7(900)433-2745", 50000, 39);
        employees[4] = new Employee("Соломин Викентий Афанасьевич", "Растопщик", "Vika@banya.ru", "+7(900)433-27348", 39000, 29);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].printEmployee();
                // System.out.println(employees[i]); вариант вывода через переопределение toString
            }
        }
    }
}
