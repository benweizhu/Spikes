package bowling.third.practice;

public class Frame {
    private final int firstRoll;
    private final int secondRoll;
    private Frame next;

    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public int countScore() {
        return ownScore() + countBonus();
    }

    private int countBonus() {
        if (isStrike()) {
            return nextRoll() + nextNextRoll();
        } else if (isSpare()) {
            return nextRoll();
        }
        return 0;
    }

    private int nextNextRoll() {
        if (next.isStrike()) {
            return next.nextRoll();
        } else {
            return next.secondRoll;
        }
    }

    private int nextRoll() {
        return next.firstRoll;
    }

    private int ownScore() {
        return firstRoll + secondRoll;
    }

    private boolean isStrike() {
        return firstRoll == 10;
    }

    private boolean isSpare() {
        return !isStrike() && ownScore() == 10;
    }

    public void setNext(Frame next) {
        this.next = next;
    }
}
