package com.task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private NWD nwd;

    @BeforeEach
    public void setUp(){
        nwd = new NWD();
        System.out.println("Test initialization");
    }

    @AfterEach
    public void tearDown(){
        nwd = null;
        System.out.println("cleanup completed");
    }

    @Test
    public void AllPositiveAndSameNumbers(){
        int tryResult = nwd.NWD(2,2);
        assertEquals(2, tryResult);
        System.out.println("Test no.1 - com.task.NWD: "+tryResult);
    }
    @Test
    public void AllPositiveAndDifferentNumbers(){
        int tryResult = nwd.NWD(2,4);
        assertEquals(2, tryResult);
        System.out.println("Test no.2 - com.task.NWD: "+tryResult);
    }
    @Test
    public void FirstPositiveSecondNegative(){
        int tryResult = nwd.NWD(3,-2);
        assertEquals(1, tryResult);
        System.out.println("Test no.3 - com.task.NWD: "+tryResult);
    }
    @Test
    public void FirstNegativeSecondPositive(){
        int tryResult = nwd.NWD(-12,4);
        assertEquals(4, tryResult);
        System.out.println("Test no.4 - com.task.NWD: "+tryResult);
    }
    @Test
    public void AllNegativeAndSameNumbers(){
        int tryResult = nwd.NWD(-2,-6);
        assertEquals(2, tryResult);
        System.out.println("Test no.5 - com.task.NWD: "+tryResult);
    }
    @Test
    public void AllNumbersEqualsZeroException(){
        System.out.println("Test no. 6 - Exception test");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int tryResult = nwd.NWD(0,0);
        } );
    }
    @Test
    public void FirstNumberZero(){
        int tryResult = nwd.NWD(0,-6);
        assertEquals(6, tryResult);
        System.out.println("Test no.7 - com.task.NWD: "+tryResult);
    }
    @Test
    public void SecondNumberZero(){
        int tryResult = nwd.NWD(25,0);
        assertEquals(25, tryResult);
        System.out.println("Test no.8 - com.task.NWD: "+tryResult);
    }
}
