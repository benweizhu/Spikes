﻿namespace ThirdTry
{
    public class Frame
    {
        public int FirstBall { get; }
        public int SecondBall { get; }

        public Frame(int firstBall, int secondBall)
        {
            this.FirstBall = firstBall;
            this.SecondBall = secondBall;
        }

        public int Score => CalculateScore();
        public Frame Next { get; set; }

        private int CalculateScore()
        {
            return FirstBall+SecondBall+Bonus();
        }

        private int Bonus()
        {
            if (FirstBall != 10 && FirstBall + SecondBall == 10)
            {
                return Next.FirstBall;
            }
            return 0;
        }
    }
}