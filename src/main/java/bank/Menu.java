package bank;

import java.sql.SQLDataException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import bank.exceptions.AmountException;

public class Menu {
  private Scanner scanner;

  public static void main(String[] args){
    System.out.println("Welcome to Globe Bank International!");
    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);

    Customer customer = menu.authenticateuser();
    if(customer != null){
      Account account = Datasource.getAccount(customer.getAccount_id());
      menu.showMenu(customer, account);
    }

    menu.scanner.close();
  }

  private Customer authenticateuser(){
    System.out.println("Please enter the username");
    String username = scanner.next();

    System.out.println("Please enter the password");
    String password = scanner.next();

    Customer customer = null;
    try{
       customer = Authenticator.login(username, password);
    }catch(LoginException e){
      System.out.println("there was an error"+ e.getMessage());
    }
    return customer;

  }

  private void showMenu(Customer customer, Account account){
    int selection = 0;
    while(selection!=4&& customer.isAuthenticated()){
      System.out.println("====================================");
      System.out.println("please select one of the options");
      System.out.println("1: Deposit");
      System.out.println("2: withdraw");
      System.out.println("3: check balance");
      System.out.println("4: exit");
      System.out.println("====================================");

      selection = scanner.nextInt();
      double amount = 0;

      switch(selection){
        case 1:
        System.out.println("how much would you like to deposit?");
        amount = scanner.nextDouble();
        try{
          account.deposit(amount);
        }catch(AmountException e)
        {
          System.out.println(e.getMessage());
          System.out.println("please try again");
        }
        break;

        case 2:
        System.out.println("how much do yoou like to withdraw?");
        amount = scanner.nextDouble();
        try{
          account.withdraw(amount);
        }catch(AmountException e){
          System.out.println(e.getMessage());
          System.out.println("please try again");
        }
        break;

        case 3:
        System.out.println("current balance:"+account.getBalance());
        break;

        case 4:
        Authenticator.logout(customer);
        System.out.println("Thanks for visiting");
        break;

        default:
        System.out.println("Invalid option");
        break;
      }
    }
  }
}
