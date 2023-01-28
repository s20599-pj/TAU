using NUnit.Framework;
using FluentAssertions;
using System;

namespace TAU
{
    public class GamePlayTest
    {
        private GamePlay gamePlay;

        [SetUp]
        public void SetUp()
        {
            gamePlay = new GamePlay();
            gamePlay.StartGame(8);
        }

        [TearDown]
        public void TearDown()
        {
        }

        [Test]
        public void ShouldThrowEndOfBoarExceptionWhenMowingUpToBorder()
        { 
            gamePlay.gameBoard.SetPlayerPosition(0, 0)
            Action move = () => gamePlay.Move('w');
            move.Should().Throw<EndOfBoardException>();
        }

        [Test]
        public void ShouldThrowEndOfBoarExceptionWhenMowingDownToBorder()
        {
            gamePlay.gameBoard.SetPlayerPosition(7, 0);
            Action move = () => gamePlay.Move('s');
            move.Should().Throw<EndOfBoardException>();
        }

        [Test]
        public void ShouldThrowEndOfBoarExceptionWhenMowingLeftToBorder()
        {
            Action move = () => gamePlay.Move('a');
            move.Should().Throw<EndOfBoardException>();
        }

        [Test]
        public void ShouldThrowEndOfBoarExceptionWhenMowingRightToBorder()
        {
            gamePlay.gameBoard.SetPlayerPosition(0, 7);
            Action move = () => gamePlay.Move('d');
            move.Should().Throw<EndOfBoardException>();
        }

        [Test]
        public void EndGameTriggerShouldBeTrue()
        {
            gamePlay.gameBoard.SetPlayerPosition(gamePlay.gameBoard.FinishPosition.row,
                    gamePlay.gameBoard.FinishPosition.column - 1);
            gamePlay.Move('d');
            gamePlay.endGame.Should().Be(true);
        }

        [Test]
        public void ShouldThrowObstacleExceptionWhenHitingObstacle()
        {
            Position obstaclePosition = new Position();
            
            for (int i = 0; i < 7; i++)
            {
                for (int j = 0; j < 7; j++)
                {
                    if (gamePlay.gameBoard.GetFieldCords(i, j).Equals("#"))
                    {
                        obstaclePosition.setPosition(i, j);
                        break;
                    }
                }
            }
            gamePlay.gameBoard.SetPlayerPosition(obstaclePosition.row, obstaclePosition.column - 1);
            
            Action move = () => gamePlay.Move('d');
            move.Should().Throw<ObstacleException>();
        }
    }
}
