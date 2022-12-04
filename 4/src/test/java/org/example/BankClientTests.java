package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankClientTests {
    @Mock
    BankClient bankClient;

    @Test
    void accountIsActive() {
        when(bankClient.getAccountActive()).thenReturn(Boolean.TRUE);
        Assertions.assertEquals(bankClient.getAccountActive(), Boolean.TRUE);
    }
    @Test
    void shouldShowAccountBalance(){
        double balance = 4526;
        when(bankClient.getAccountBalance()).thenReturn(4526D);
        Assertions.assertEquals(balance, bankClient.getAccountBalance());
    }
    @Test
    void shouldAddMoney(){
        when(bankClient.addBalance(400D)).thenReturn(400D);
        when(bankClient.getAccountBalance()).thenReturn(400D);
        Assertions.assertEquals(bankClient.addBalance(400D), bankClient.getAccountBalance());
    }
    @Test
    void shouldReduceBalance(){
        when(bankClient.reduceBalance(400D)).thenReturn(400D);
        when(bankClient.getAccountBalance()).thenReturn(400D);
        Assertions.assertEquals(bankClient.reduceBalance(400D), bankClient.getAccountBalance());
    }
    @Test
    void shouldThrowExceptionDuringNegativeAddMoney(){
        when(bankClient.addBalance(-100D)).thenThrow(IllegalArgumentException.class);
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankClient.addBalance(-100D));
    }
    @Test
    void balanceIsIncorrectAfterDeposit(){
        when(bankClient.addBalance(100d)).thenReturn(100d);
        when(bankClient.getAccountBalance()).thenReturn(200d);
        Assertions.assertNotEquals(bankClient.addBalance(100d),bankClient.getAccountBalance());
    }
}
