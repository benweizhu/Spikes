package bowling2017.practice2;

public class Frame {
  private final int roll1;
  private final int roll2;
  private final boolean isStrike;
  private int ownScore;
  private final boolean isSpare;

  private Frame next;

  public Frame(int roll1, int roll2) {
    this.roll1 = roll1;
    this.roll2 = roll2;

    ownScore = roll1 + roll2;
    isStrike = roll1 == 10;
    isSpare = !isStrike && roll1 + roll2 == 10;
  }

  public void setNext(Frame next) {
    this.next = next;
  }

  public int countScore() {
    if (isSpare) {
      return ownScore + next.roll1;
    } else if (isStrike) {
      return ownScore + next.roll1 + next.roll2;
    }
    return ownScore;
  }
}
