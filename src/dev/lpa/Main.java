package dev.lpa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create a bank
        Bank myBank = new Bank("MyBank");
        myBank.name = "My Bank";

        // Add customers
        myBank.addCustomer("Alice");
        myBank.addCustomer("Bob", 100.0);

        // Add transactions
        myBank.addTransaction("Alice", 50.0);
        myBank.addTransaction("Bob", -30.0);
        myBank.addTransaction("Charlie", 200.0); // New customer

        // Print customer transactions
        System.out.println("Customer Transactions:");
        myBank.printCustomerTransactions("Alice");
        myBank.printCustomerTransactions("Bob");
        myBank.printCustomerTransactions("Charlie");
    }
}



class Bank{
    String name;
    ArrayList<Customer> customerList;

    public Bank(String name) {
        this.name = name;
        this.customerList = new ArrayList<Customer>();
    }

    public void addCustomer (String customerName){
        customerList.add(new Customer(customerName));
    }

    public void addCustomer (String customerName, Double transactionAmount){
        Customer newCustomer = new Customer(customerName, transactionAmount);
        customerList.add(newCustomer);
    }

    public void addTransaction(String customerName, Double transactionAmount) {
        // First check if Customer exists
        for (Customer customer : customerList) {
            if (customer.getName().equals(customerName)) {
                // Customer exists, add the transaction
                customer.addTransaction(transactionAmount);
                return;
            }
        }

        // Customer does not exist, add a new customer with the transaction
        addCustomer(customerName, transactionAmount);
    }

    public void printCustomerTransactions(String customerName){

        for (Customer customer : customerList) {
            if (customer.getName().equals(customerName)) {
                System.out.println(customerName + ": " + customer.getTransactions());
                return;
            }
        }
    }



}

class Customer{
    String name;
    ArrayList<Double> transactions;

    public void addTransaction(Double amount){
        transactions.add(amount);
    }


    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
    }

    public Customer(String name, Double firstTransactionAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        this.addTransaction(firstTransactionAmount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}

// simple bank app

// Types:
//Customer
//Bank

// Customer:
// name, and Arraylist of transxns with Double wrapper elements
// credit (+), or debit (-)

// Bank:
// name and AL of Customers
// Add a new customer if they're not already in list
// Allow customer to add a transaction to existing Cr
// This class also prints a stmt that includes Cr name and transxn amts. Should use unboxing.