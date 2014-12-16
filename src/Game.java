import java.util.ArrayList;
import java.util.List;

/**
 * Created by brandonteng on 12/15/14.
 */
public class Game {

    private int totalScore;
    private int currentRoll = 0;
    private List<Frame> frames = new ArrayList<Frame>();

    public void roll(int pins) {
        if ( (currentRoll & 1) == 0 ) {
            Frame frame = new Frame();
            frame.setFirstRoll(pins);
            checkStrike(frame);
            frames.add(frame);
        } else {
            frames.get(frames.size() - 1).setSecondRoll(pins);
        }
        currentRoll++;
    }

    public int score() {
        totalScore = 0;
        int frameIndex = 0;

        for (Frame frame :frames) {
            if (frame.isSpare()) {
                totalScore += 10 + frames.get(frameIndex + 1).getFirstRoll();
            } else if(frame.isStrike()) {
                totalScore += 10 + frames.get(frameIndex+1).total();
            } else {
                totalScore += frame.total();
            }
            frameIndex ++;
            System.out.println(totalScore);
        }

        return totalScore;
    }


    private void checkStrike(Frame frame) {
        if(frame.isStrike()){
            frame.setSecondRoll(0);
            currentRoll++;
        }
    }

}
