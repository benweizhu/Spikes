﻿namespace FourthTry
{
    public class LastFrame:Frame
    {
        private int _thirdBall;

        public LastFrame(int firstBall, int secondBall, int thirdBall) : base(firstBall,secondBall)
        {
            this._thirdBall = thirdBall;
        }

        protected override int CalculateScore()
        {
            return FirstBall + SecondBall + _thirdBall;
        }
    }
}