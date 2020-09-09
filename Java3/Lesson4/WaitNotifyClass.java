package Java3.Lesson4;

public class WaitNotifyClass implements Runnable {
            private final char currentLetter;
            private final char nextLetter;
            static volatile char c = 'A';
            static final Object mon = new Object();

            public WaitNotifyClass(char currentLetter, char nextLetter) {
                this.currentLetter = currentLetter;
                this.nextLetter = nextLetter;
            }

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        try {
                            while (c != currentLetter)
                                mon.wait();
                            System.out.print(currentLetter);
                            c = nextLetter;
                            mon.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

