import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.List;

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

        for (Frame frame : frames) {
            if(frameIndex < 10) totalScore += getFrameScore(frameIndex, frame);
            frameIndex ++;
        }

        return totalScore;
    }

    private Integer getFrameScore(int frameIndex, Frame frame) {
        if (frame.isSpare()) return 10 + frames.get(frameIndex + 1).getFirstRoll();
        if (isStrikeAndWillStrikeNextFrame(frameIndex)) return 20 + frames.get(frameIndex+2).getFirstRoll();
        if (frame.isStrike()) return 10 + frames.get(frameIndex+1).total();
        return frame.total();
    }

    private boolean isStrikeAndWillStrikeNextFrame(int index) {
        return frames.get(index).isStrike() && frames.get(index+1).isStrike() && index < 9;
    }

    private void checkStrike(Frame frame) {
        if(frame.isStrike() && frames.size() < 10){
            currentRoll++;
        }
    }

}
