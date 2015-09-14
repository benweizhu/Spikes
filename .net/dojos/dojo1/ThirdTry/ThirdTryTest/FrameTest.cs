﻿using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ThirdTry;

namespace ThirdTryTest
{
    [TestClass]
    public class FrameTest
    {
        [TestMethod]
        public void FrameShouldCountItsOwnScoreWithoutBonus()
        {
            //given
            var frame = new Frame(1,2);

            //when
            int score=frame.Score;

            //then
            Assert.AreEqual(3,score);
        }

        [TestMethod]
        public void FrameShouldCountItsScoreWithNextBallAsBonusWhenThereIsSpare()
        {
            //given
            var frame = new Frame(4,6);
            var nextFrame=new Frame(2,3);
            frame.Next = nextFrame;

            //when
            int score=frame.Score;

            //then
            Assert.AreEqual(12,score);
        }
    }
}
