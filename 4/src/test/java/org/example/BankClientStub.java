package org.example;

public class BankClientStub extends BankClient{
    private final BankClient bankClientStub = new BankClient(1,"test","testowicz","10293847561","male","1024",500.24,Boolean.TRUE);
    @Override
    public double addBalance(double amount){
        this.setAccountBalance(bankClientStub.getAccountBalance()+amount);
        return bankClientStub.getAccountBalance();
    }
    @Override
    public double reduceBalance(double amount){
        this.setAccountBalance(bankClientStub.getAccountBalance()-amount);
        return bankClientStub.getAccountBalance();
    }
    @Override
    public double getAccountBalance(){
        return bankClientStub.accountBalance;
    }
    @Override
    public void setAccountBalance(double amount){
        bankClientStub.accountBalance = amount;
    }
    @Override
    public Boolean getAccountActive(){
        return Boolean.TRUE;
    }
    @Override
    public String getFirstName(){
        return bankClientStub.firstName;
    }
}
