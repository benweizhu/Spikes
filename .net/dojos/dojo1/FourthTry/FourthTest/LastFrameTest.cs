﻿using System;
using FourthTry;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace FourthTest
{
    [TestClass]
    public class LastFrameTest
    {
        [TestMethod]
        public void LastFrameShouldSimplyAddAllThreeBallsUp()
        {
            //given
            var lastFrame = new LastFrame(1, 2, 3);

            //when
            var score=lastFrame.Score;

            //then
            Assert.AreEqual(6,score);
        }
    }
}
