using System;
using System.IO;

namespace TAU
{
    public class GamePlay
    {
        private readonly StreamReader reader = new StreamReader(Console.OpenStandardInput());
        public GameBoard gameBoard;
        private Position finishPosition;
        public bool endGame = false;

        public void StartGame(int gameBoardSize)
        {
            this.gameBoard = new GameBoard(gameBoardSize);
            this.gameBoard.CreateBoard();
            this.gameBoard.GenerateGameBoardObjects();
            this.finishPosition = this.gameBoard.FinishPosition;
        }

        public void Move(char direction)
        {
            int currentRow = this.gameBoard.PlayerPosition.row;
            int currentColumn = this.gameBoard.PlayerPosition.column;

            switch (char.ToLower(direction))
            {
                case 'w':
                    if (currentRow - 1 < 0)
                    {
                        throw new EndOfBoardException("Probowales wyjsc poza plansze.");
                    }
                    if (this.gameBoard.GetFieldCords(currentRow - 1, currentColumn) == "#")
                    {
                        throw new ObstacleException("Probowales wejsc na przeszkode");
                    }
                    currentRow--;
                    break;
                case 's':
                    if (currentRow + 1 > gameBoard.GameBoardSize - 1)
                    {
                        throw new EndOfBoardException("Probowales wyjsc poza plansze.");
                    }
                    if (this.gameBoard.GetFieldCords(currentRow + 1, currentColumn) == "#")
                    {
                        throw new ObstacleException("Probowales wejsc na przeszkode");
                    }
                    currentRow++;
                    break;
                case 'a':
                    if (currentColumn - 1 < 0)
                    {
                        throw new EndOfBoardException("Probowales wyjsc poza plansze.");
                    }
                    if (this.gameBoard.GetFieldCords(currentRow, currentColumn - 1) == "#")
                    {
                        throw new ObstacleException("Probowales wejsc na przeszkode");
                    }
                    currentColumn--;
                    break;
                case 'd':
                    if (currentColumn + 1 > gameBoard.GameBoardSize - 1)
                    {
                        throw new EndOfBoardException("Probowales wyjsc poza plansze.");
                    }
                    if (this.gameBoard.GetFieldCords(currentRow, currentColumn + 1) == "#")
                    {
                        throw new ObstacleException("Probowales wejsc na przeszkode");
                    }
                    currentColumn++;
                    break;
                default:
                    throw new InvalidInputException("Zly przycisk, sprobuj ponownie");
            }
            gameBoard.SetPlayerPosition(currentRow, currentColumn);

            if (currentRow == this.finishPosition.row && currentColumn == this.finishPosition.column)
            {
                Console.WriteLine("Wygrales!");
                endGame = true;
            }
        }

        public void GameFlow(int gameBoardSize)
        {
            StartGame(gameBoardSize);
            string readInput;
            char key = '\0';
            while (!this.endGame)
            {
                gameBoard.PlotGameBoard();
                readInput = Console.ReadLine();
                key = readInput[0];
                if (key == 'q')
                {
                    Environment.Exit(-1);
                }
                try
                {
                    Move(key);
                }
                catch (EndOfBoardException e)
                {
                    Console.WriteLine(e.Message);
                }
                catch (InvalidInputException e)
                {
                    Console.WriteLine(e.Message);
                }
                catch (ObstacleException e)
                {
                    Console.WriteLine(e.Message);
                }
            }
        }
    }
}
