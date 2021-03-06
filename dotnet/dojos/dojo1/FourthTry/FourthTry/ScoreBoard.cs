﻿using System;
using System.Collections.Generic;
using System.Linq;

namespace FourthTry
{
    public class ScoreBoard
    {
        private readonly List<Frame> frames = new List<Frame>();

        public int TotalScore
        {
            get { return frames.Sum(frame => frame.Score); }
        }

        public void Play(int firstBall, int secondBall, int thirdBall = -1)
        {
            CheckValidity();
            var frame = CreateFrame(firstBall, secondBall, thirdBall);
            if (frames.Count > 0)
            {
                frames.Last().Next = frame;
            }
            frames.Add(frame);
        }

        private void CheckValidity()
        {
            if (frames.Count == 10)
            {
                throw new ArgumentException("at most 10 frames");
            }
        }

        private Frame CreateFrame(int firstBall, int secondBall, int thirdBall)
        {
            Frame frame;
            if (thirdBall == -1)
            {
                frame = new Frame(firstBall, secondBall);
            }
            else
            {
                CheckLastPosition();
                frame = new LastFrame(firstBall, secondBall, thirdBall);
            }
            return frame;
        }

        private void CheckLastPosition()
        {
            if (frames.Count != 9)
            {
                throw new ArgumentException("only last frame can have 3 balls");
            }
        }
    }
}