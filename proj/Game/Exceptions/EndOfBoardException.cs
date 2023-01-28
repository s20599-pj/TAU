using System;

namespace TAU
{
    public class EndOfBoardException : Exception
    {
        public EndOfBoardException(string message) : base(message)
        {
        }
    }
}
