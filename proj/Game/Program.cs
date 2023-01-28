using System;
using TAU;

class GameToTestApplication
{
    static void Main(string[] args)
    {
        GamePlay game = new GamePlay();
        Console.WriteLine("Twoim celem jest dotarcie do litery 'F'");
        Console.WriteLine("Ruch w gore - 'w'");
        Console.WriteLine("Ruch w dol - 's'");
        Console.WriteLine("Ruch w lewo - 'a'");
        Console.WriteLine("Ruch w prawo - 'd'");
        Console.WriteLine("Przeszkody sa oznaczone znakiem '#'");
        Console.WriteLine("Gracz jest oznaczony litera 'P'");
        Console.WriteLine("Aby wylaczyc gre nacisnij 'q'");
        Console.WriteLine();
        game.GameFlow(8);
    }
}
