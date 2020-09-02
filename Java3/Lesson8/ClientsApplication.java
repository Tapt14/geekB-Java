package Java2.Lesson8;

import Java2.Lesson8.ClientApplication.Messenger;

public class ClientsApplication {
    public static void main(String[] args) {
        new Thread(Messenger::new).start();
        new Thread(Messenger::new).start();
        new Thread(Messenger::new).start();

    }
}

