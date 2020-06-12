package Lesson7;

public class Bowl {

    private final int sizeBowl;
    private int feedInBowl;

    public Bowl(int sizeBowl, int feedInBowl) {
        this.sizeBowl = sizeBowl;
        this.feedInBowl = feedInBowl;
    }

    public int getSizeBowl() {
        return sizeBowl;
    }

    public int getFeedInBowl() {
        return feedInBowl;
    }

    public void setFeedInBowl(int feedInBowl) {
        this.feedInBowl = Math.min(feedInBowl, getSizeBowl());
    }
}
