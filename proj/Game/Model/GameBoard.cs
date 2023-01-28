using System;
using System.Linq;

namespace TAU
{
    public class GameBoard
    {
        private string[,] gameBoard;
        public int GameBoardSize { get; set; }
        public Position PlayerPosition { get; set; }
        public Position FinishPosition { get; set; }

        public GameBoard(int gameBoardSize)
        {
            this.GameBoardSize = gameBoardSize;
            this.PlayerPosition = new Position();
            this.FinishPosition = new Position();
        }

        public void CreateBoard()
        {
            gameBoard = new string[GameBoardSize, GameBoardSize];
            for (int i = 0; i < GameBoardSize; i++)
            {
                for (int j = 0; j < GameBoardSize; j++)
                {
                    gameBoard[i, j] = "-";
                }
            }
        }

        private void GenerateObstacles()
        {
            var random = new Random();
            for (int i = 1; i < GameBoardSize; i++)
            {
                for (int j = 0; j < GameBoardSize; j++)
                {
                    if (random.Next(4) == 1)
                    {
                        gameBoard[i, j] = "#";
                    }
                    else
                    {
                        gameBoard[i, j] = "-";
                    }
                }
            }
        }

        private void SetFinishPosition(int row, int column)
        {
            FinishPosition.setPosition(row, column);
            gameBoard[row, column] = "F";
        }

        public void SetPlayerPosition(int row, int column)
        {
            gameBoard[PlayerPosition.row, PlayerPosition.column] = "-";
            PlayerPosition.setPosition(row, column);
            gameBoard[row, column] = "P";
        }

        public void ClearFieldsForPlayer()
        {
            gameBoard[FinishPosition.row, FinishPosition.column - 1] = "-";
            gameBoard[PlayerPosition.row, PlayerPosition.column + 1] = "-";
        }

        public void GenerateGameBoardObjects()
        {
            var random = new Random();
            GenerateObstacles();
            SetFinishPosition(random.Next(GameBoardSize), GameBoardSize - 1);
            SetPlayerPosition(random.Next(GameBoardSize), 0);
            ClearFieldsForPlayer();
        }

        public string GetFieldCords(int row, int column)
        {
            return gameBoard[row, column];
        }

        public void PlotGameBoard()
        {
            for (int i = 0; i < GameBoardSize; i++)
            {
                for (int j = 0; j < GameBoardSize; j++)
                {
                    Console.Write(gameBoard[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
    }
}

