package Java3.Lesson5;

import java.util.concurrent.Semaphore;

public class FuelStation {
    static Semaphore smp = new Semaphore(3);

        public static void refueling (Vehicle vehicle) {
            new Thread(() -> {
              try {
                    System.out.printf("%s %s is refueling\n", vehicle.getClass().getSimpleName(), vehicle.name);
                    smp.acquire();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.printf("%s %s is filled\n", vehicle.getClass().getSimpleName(), vehicle.name);
                    smp.release();
                }
            }).start();
        }
    }
