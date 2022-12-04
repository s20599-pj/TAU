package org.example;

public class BankClient {
    public int id;
    public String firstName;
    public String lastName;
    private String PESEL;
    public String sex;
    public String accountNumber;
    public double accountBalance;
    public Boolean isAccountActive;
    public BankClient() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankClient(int id, String firstName, String lastName, String PESEL, String sex, String accountNumber, double accountBalance, Boolean isAccountActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.PESEL = PESEL;
        this.sex = sex;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.isAccountActive = isAccountActive;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Boolean getAccountActive() {
        return isAccountActive;
    }

    public void setAccountActive(Boolean accountActive) {
        isAccountActive = accountActive;
    }

    public String getFullName(){
        return this.getFirstName()+" "+this.getLastName();
    }

    public double addBalance(double payment){
        this.setAccountBalance(this.getAccountBalance()+payment);
        return getAccountBalance();
    }

    public double reduceBalance(double payment){
        this.setAccountBalance(this.getAccountBalance()-payment);
        return getAccountBalance();
    }
}
