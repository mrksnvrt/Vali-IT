package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Double> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("****************\n" +
                "W3lcome to Marek Service Not High comission promize bank! \n" +
                "What would you like to do: \n" +
                "\n" +
                "1 - create an account      \n" +
                "2 - display balance        \n" +
                "3 - deposit money          \n" +
                "4 - withdraw money         \n" +
                "5 - transfer money         \n" +
                "6 - exit program\n" +
                "");

        boolean süsteemTööleKuniExit = true;
        while (süsteemTööleKuniExit) {
            System.out.println("Enter your next action:");
            System.out.println("");
            int inputNumber = scanner.nextInt();
            scanner.nextLine();
            switch (inputNumber) {
                case 1:
                    System.out.println("Welcemo Sir/Madam. We are glad you decided to join our bank.\n" +
                            "\n" +
                            "Please enter your new account number");
                    String accountNr=scanner.nextLine();
                    //Sooviksin lisada siia if statemendi, kui kasutaja võetud siis võtke uus.
                    createAccount(accountNr, accountBalanceMap);
                    break;
                case 2:
                    System.out.println("Enter account number to check balance: ");
                    accountNr=scanner.nextLine();
                    getBalance(accountNr, accountBalanceMap);
                    break;
                case 3:
                    System.out.println("Enter account number to deposit money: ");
                    accountNr=scanner.nextLine();
                    System.out.println("Enter the amount you want to deposit:");
                    double amount=scanner.nextDouble();
                    depositMoney(accountNr,amount,accountBalanceMap);
                    break;
                case 4:
                    System.out.println("Enter account number for withdrawal:");
                    accountNr=scanner.nextLine();
                    System.out.println("Enter the amount you want to withdraw:");
                    amount=scanner.nextDouble();
                    withdrawMoney(accountNr,amount,accountBalanceMap);
                    break;
                case 5:
                    System.out.println("Enter account number from where to transfer:");
                    accountNr=scanner.nextLine();
                    System.out.println("Enter account number where to transfer:");
                    String accountNr2=scanner.nextLine();
                    System.out.println("Enter the amount to transfer:");
                    amount=scanner.nextDouble();
                    transfer(accountNr,accountNr2,amount,accountBalanceMap);
                    break;
                case 6:
                    süsteemTööleKuniExit=false;
                    break;
                default:
                    System.out.println("Unknown number, enter selection from 1 - 6 ");
            }
        }
    }

    // TODO 1
    // Add command: "createAccount ${accountNr}"
    // this has to store accountNr with 0 balance
    public static void createAccount(String accountNr, Map<String,Double> accountBalanceMap){
        accountBalanceMap.put(accountNr,0.0);
    }

    // TODO 2
    // Add command: "getBalance ${accountNr}"
    // this has to display account balance of specific acount
    public static void getBalance(String accountNr, Map<String,Double> accountBalanceMap){
        if(accountBalanceMap.get(accountNr) > 1000){
            System.out.println("ayyyy bruda");
        }
        System.out.println("Your balance is "+accountBalanceMap.get(accountNr));
    }
    // TODO 3
    // Add command: "depositMoney ${accountNr} ${amount}
    // this has to add specified amount of money to account
    // You have to check that amount is positive number
    public static void depositMoney(String accountNr, double amount, Map<String,Double> accountBalanceMap){
        if(amount>0){
            double balance=accountBalanceMap.get(accountNr);
            balance=balance+amount;
            accountBalanceMap.replace(accountNr,balance);
            System.out.println(amount+" added to account "+accountNr+" new balance is: "+balance);
        }else{
            System.out.println("Invalid amount");
        }
    }
    // TODO 4
    // Add command: "withdrawMoney ${accountNr} ${amount}
    // This has to remove specified amount of money from account
    // You have to check that amount is positive number
    // You may not allow this transaction if account balance would become negative
    public static void withdrawMoney(String accountNr, double amount, Map<String,Double> accountBalanceMap){
        if(amount>0){
            double balance=accountBalanceMap.get(accountNr);
            if(balance>=amount){
                balance=balance-amount;
                accountBalanceMap.replace(accountNr,balance);
                System.out.println(amount+" is withdrawd, new balance is: "+balance);
            }else{
                System.out.println("Not enough money on account");
            }
        }else{
            System.out.println("Invalid amount");
        }
    }
    // TODO 5
    // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
    // This has to remove specified amount from fromAccount and add it to toAccount
    // Your application needs to check that toAccount is positive
    // And from account has enough money to do that transaction

    public static void transfer(String firstAccountNr, String secondAccountNr, double amountToTransfer,
                                Map<String,Double> accountBalanceMap){
        double firstAccountBalance=accountBalanceMap.get(firstAccountNr);
        if(firstAccountBalance>=amountToTransfer){
            firstAccountBalance=firstAccountBalance-amountToTransfer;
            accountBalanceMap.replace(firstAccountNr,firstAccountBalance);
            double secondAccountBalance=accountBalanceMap.get(secondAccountNr);
            secondAccountBalance=secondAccountBalance+amountToTransfer;
            accountBalanceMap.replace(secondAccountNr, secondAccountBalance);
            System.out.println(amountToTransfer+" is transferred from "+firstAccountNr+" to "+secondAccountNr);
        }else{
            System.out.println("Not enough money on account nr: "+firstAccountNr);
        }
    }


}




