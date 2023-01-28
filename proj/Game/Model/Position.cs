using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TAU
{
    public class Position
    {
        public int column { get; set; }
        public int row { get; set; }

        public Position()
        {
            this.column = 0;
            this.row = 0;
        }

        public void setPosition(int row, int column)
        {
            this.column = column;
            this.row = row;
        }
    }
}
