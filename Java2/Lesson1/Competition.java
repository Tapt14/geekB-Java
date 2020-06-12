package Java2.Lesson1;

public class Competition {

    private boolean isPassed = true;
    private final Competitors[] competitors = new Competitors[3];
    private final Obstacles[] obstacles = new Obstacles[2];

    void startCompetition() {
        initialization();
        competition();
    }


    private void initialization() {
        competitors[0] = new Man("Nik", 800, 1.5);
        competitors[1] = new Cat("Martin", 150, 2.4);
        competitors[2] = new Robot("Verter", 1500, 2.0);

        obstacles[0] = new Treadmill(700);
        obstacles[1] = new Wall(1.8);

    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    private void competition() {
        for (int i = 0; i < competitors.length; i++) {

            for (int j = 0; j < obstacles.length ; j++) {
                if (obstacles[j] instanceof Treadmill) {
                    run(competitors[i], (Treadmill) obstacles[j]);
                }else if (obstacles[j] instanceof Wall) {
                    jump(competitors[i], (Wall) obstacles[j]);
                }
                if (!isPassed()) break;
            }
            System.out.println();
        }
    }

    public void run(Competitors competitor, Treadmill treadmill) {
        if ( competitor.getRunLimitDistance() >= treadmill.getDistance()) {
            setPassed(true);
            System.out.printf("\n%s %s ran a distance %d meters", competitor.getClass().getSimpleName(), competitor.getName(), treadmill.getDistance());
        }else {
            setPassed(false);
            System.out.printf("\n%s %s can't run a distance %d meters, distance limit %d meters", competitor.getClass().getSimpleName(), competitor.getName(), treadmill.getDistance(), competitor.getRunLimitDistance());
        }
    }

    public void jump(Competitors competitor, Wall wall) {
        if ( competitor.getJumpLimitHeight() >= wall.getHeight()) {
            setPassed(true);
            System.out.printf("\n%s %s jumped the wall %.2f meters", competitor.getClass().getSimpleName(), competitor.getName(), wall.getHeight());
        }else {
            setPassed(false);
            System.out.printf("\n%s %s can't jump over the wall %.2f meters, limit height %.2f meters", competitor.getClass().getSimpleName(), competitor.getName(), wall.getHeight(), competitor.getJumpLimitHeight());
        }
    }



}
