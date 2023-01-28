using System;
using System.Linq;
using NUnit.Framework;
using FluentAssertions;

namespace TAU
{
    [TestFixture]
    public class GameBoardTest
    {
        private GameBoard gameBoard;

        [SetUp]
        public void SetUp()
        {
            gameBoard = new GameBoard(8);
            gameBoard.CreateBoard();
        }

        [Test]
        public void ShouldCreateGameBoard()
        {
            gameBoard.GetFieldCords(4, 6)
                .Should()
                .Be("-");
        }

        [Test]
        public void ShouldCreateObjects()
        {
            gameBoard.GenerateGameBoardObjects();
            gameBoard.GetFieldCords(4, 6)
                .Should()
                .BeOneOf("#", "F", "P", "-");
        }

        [Test]
        public void ShouldSetFinishPosition()
        {
            gameBoard.GenerateGameBoardObjects();
            gameBoard.GetFieldCords(gameBoard.FinishPosition.row, gameBoard.FinishPosition.column)
                .Should()
                .Be("F");
        }

        [Test]
        public void ShouldSetPlayerPosition()
        {
            gameBoard.GenerateGameBoardObjects();
            gameBoard.GetFieldCords(gameBoard.PlayerPosition.row, gameBoard.PlayerPosition.column)
                .Should()
                .Be("P");
        }
    }
}
