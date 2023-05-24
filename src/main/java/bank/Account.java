package bank;

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

  public int getBalance() {
    return this.balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

}
