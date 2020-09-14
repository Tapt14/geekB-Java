package Java3.Lesson2;

import Java3.Lesson2.ClientApplication.Messenger;

public class ClientsApplication {
    public static void main(String[] args) {
        new Thread(Messenger::new).start();
        new Thread(Messenger::new).start();
        new Thread(Messenger::new).start();

    }
}

