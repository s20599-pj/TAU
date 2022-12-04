package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankClientStubTests {
    BankClientStub bankClientStub;

    @BeforeEach
    void setup(){
        bankClientStub = new BankClientStub();
    }
    @Test
    void returnFirstName(){
        Assertions.assertEquals(bankClientStub.getFirstName(), "test");
    }
    @Test
    void shouldShowAccountBalance(){
        Assertions.assertEquals(500.24,bankClientStub.getAccountBalance());
    }
    @Test
    void shouldAddBalance(){
        Assertions.assertEquals(501.24, bankClientStub.addBalance(1));
    }
    @Test
    void shouldRemoveBalance(){
        Assertions.assertEquals(500,bankClientStub.reduceBalance(0.24));
    }
}
