﻿using BowlingSecondPractice;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace BowlingTest
{
    [TestClass]
    public class ScoreBoardTest
    {
        [TestMethod]
        public void ScoreBoardShouldCalculateTotalScoreOfTenFrames()
        {
            //given
            var scoreBoard = new ScoreBoard();

            //when
            scoreBoard.PlayFrame(3, 4); //7
            scoreBoard.PlayFrame(2, 4); //6
            scoreBoard.PlayFrame(5, 4); //9
            scoreBoard.PlayFrame(6, 4); //20
            scoreBoard.PlayFrame(10, 0); //18
            scoreBoard.PlayFrame(3, 5); //8
            scoreBoard.PlayFrame(3, 7); //13
            scoreBoard.PlayFrame(3, 5); //8
            scoreBoard.PlayFrame(2, 7); //9
            scoreBoard.PlayFrame(2, 8, 3); //13

            var totalScore = scoreBoard.TotalScore;

            //then
            Assert.AreEqual(111, totalScore);
        }

        [TestMethod]
        public void ScoreBoardShouldCalculateTotalScoreOfPerfectGame()
        {
            //given
            var scoreBoard = new ScoreBoard();

            //when
            scoreBoard.PlayFrame(10, 0);
            scoreBoard.PlayFrame(10, 0);
            scoreBoard.PlayFrame(10, 0);
            scoreBoard.PlayFrame(10, 0);
            scoreBoard.PlayFrame(10, 0);
            scoreBoard.PlayFrame(10, 0);
            scoreBoard.PlayFrame(10, 0);
            scoreBoard.PlayFrame(10, 0);
            scoreBoard.PlayFrame(10, 0);
            scoreBoard.PlayFrame(10, 10, 10);

            var totalScore = scoreBoard.TotalScore;

            //then
            Assert.AreEqual(300, totalScore);
        }
    }
}