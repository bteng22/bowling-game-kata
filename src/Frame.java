/**
 * Created by ThoughtWorker on 12/16/14.
 */
public class Frame {
    private Integer firstRoll;
    private Integer secondRoll;

    public Integer getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(Integer firstRoll) {
        this.firstRoll = firstRoll;
    }

    public void setSecondRoll(Integer secondRoll) {
        this.secondRoll = secondRoll;
    }

    public Integer total() {
        return firstRoll + secondRoll;
    }

    public boolean isStrike() {
        return firstRoll == 10;
    }

    public boolean isSpare() {
        return total() == 10 && !isStrike();
    }
}
