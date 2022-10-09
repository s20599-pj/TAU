package zad1;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zad1.NWD;


public class tests {
    private NWD nwd;

    @Before
    public void setUp(){
        nwd = new NWD();
        System.out.println("Test initialization");
    }

    @After
    public void tearDown(){
        nwd = null;
        System.out.println("cleanup completed");
    }

    @Test
    public void AllPositiveAndSameNumbers(){
        int tryResult = nwd.NWD(2,2);
        assertEquals(2, tryResult);
        System.out.println("Test no.1 - NWD: "+tryResult);
    }
    @Test
    public void AllPositiveAndDifferentNumbers(){
        int tryResult = nwd.NWD(2,4);
        assertEquals(2, tryResult);
        System.out.println("Test no.2 - NWD: "+tryResult);
    }
    @Test
    public void FirstPositiveSecondNegative(){
        int tryResult = nwd.NWD(3,-2);
        assertEquals(1, tryResult);
        System.out.println("Test no.3 - NWD: "+tryResult);
    }
    @Test
    public void FirstNegativeSecondPositive(){
        int tryResult = nwd.NWD(-12,4);
        assertEquals(4, tryResult);
        System.out.println("Test no.4 - NWD: "+tryResult);
    }
    @Test
    public void AllNegativeAndSameNumbers(){
        int tryResult = nwd.NWD(-2,-6);
        assertEquals(2, tryResult);
        System.out.println("Test no.5 - NWD: "+tryResult);
    }
    @Test(expected = IllegalArgumentException.class)
    public void AllNumbersEqualsZeroException(){
        System.out.println("Test no. 6 - Exception test");
        int tryResult = nwd.NWD(0,0);
    }
    @Test
    public void FirstNumberZero(){
        int tryResult = nwd.NWD(0,-6);
        assertEquals(6, tryResult);
        System.out.println("Test no.7 - NWD: "+tryResult);
    }
    @Test
    public void SecondNumberZero(){
        int tryResult = nwd.NWD(25,0);
        assertEquals(25, tryResult);
        System.out.println("Test no.8 - NWD: "+tryResult);
    }
}
