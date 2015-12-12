package bowling.sixth;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FrameTest {
    @Test
    public void shouldCountItsOwnScoreWithoutBonus() throws Exception {
        //given
        Frame noBonusFrame = new Frame(3, 4);

        //when
        int score = noBonusFrame.countScore();

        //then
        assertThat(score, is(7));
    }

    @Test
    public void shouldCountScoreWithSpareBonus() throws Exception {
        //given
        Frame spareFrame = new Frame(3, 7);
        Frame nextFrame = new Frame(5, 4);
        spareFrame.setNext(nextFrame);

        //when
        int score = spareFrame.countScore();

        //then
        assertThat(score, is(15));
    }
}