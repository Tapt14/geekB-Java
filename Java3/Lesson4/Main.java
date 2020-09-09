package Java3.Lesson4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task1");
        new Thread(new WaitNotifyClass('A', 'B')).start();
        new Thread(new WaitNotifyClass('B', 'C')).start();
        new Thread(new WaitNotifyClass('C', 'D')).start();
    }
}
