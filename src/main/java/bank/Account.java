package bank;

import bank.exceptions.AmountException;

public class Account {
  private int Id;
  private String type;
  private double balance;

  public Account(int ID, String type, double balance){
    setId(ID);
    setType(type);
    setBalance(balance);
  }

  public int getId() {
    return this.Id;
  }

  public void setId(int Id) {
    this.Id = Id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) throws AmountException{ 
    if(amount<1)
    {
      throw new AmountException("The minimum deposit is 1.00");
    }
    else{
      double nbalance = balance + amount;
      setBalance(nbalance);
      Datasource.updateAccountBalance(Id, nbalance);
    }
  }

  public void withdraw(double amount) throws AmountException{
    if(amount<0)
    {
      throw new AmountException("The withdrawl amount must be greater than 0");

    }
    else if(amount> getBalance())
    {
      throw new AmountException("you do not have sufficient balance");
    }
    else 
    {
      double nbalance = balance - amount;
      setBalance(nbalance);
      Datasource.updateAccountBalance(Id, nbalance);
    }
  }
  
}
