package bank;

public class Customer {
  private int ID;
  private String name;
  private String username;
  private String password;
  private int account_id;

public Customer(int ID, String name, String username, String password, int account_id){
  setID(ID);
  setName(name);
  setPassword(password);
  setUsername(username);
  setAccount_id(account_id);
}

  public int getID() {
    return this.ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAccount_id() {
    return this.account_id;
  }

  public void setAccount_id(int account_id) {
    this.account_id = account_id;
  }

}
