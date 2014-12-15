import java.util.ArrayList;
import java.util.List;

/**
 * Created by brandonteng on 12/15/14.
 */
public class Game {

    private int totalScore;
    private int currentRoll = 0;
    private List<Integer> rolls = new ArrayList<Integer>();

    public void roll(int pins) {
        rolls.add(0);
        rolls.set(currentRoll++, pins);
        if(isStrike(rolls.size()-1)){
            rolls.add(0);
            currentRoll++;
        }
    }

    public int score() {
        totalScore = 0;
        int frameIndex = 0;
        for(int frame = 0; frame < 10; frame ++){
            if (isStrike(frameIndex)) {
                totalScore += 10 + framePinCount(frameIndex+2);
            } else if(isSpare(frameIndex)) {
                totalScore += 10 + rolls.get(frameIndex+2);
            } else {
                totalScore += (framePinCount(frameIndex));
            }
            frameIndex += 2;
        }
//        System.out.println(rolls);
        return totalScore;
    }

    private boolean isSpare(int frameIndex) {
        return framePinCount(frameIndex) ==  10;
    }

    private boolean isStrike(int frameIndex) {
        return rolls.get(frameIndex) ==  10 && frameIndex % 2 == 0;
    }

    private int framePinCount(int frameIndex) {
        return rolls.get(frameIndex) + rolls.get(frameIndex + 1);
    }
}
