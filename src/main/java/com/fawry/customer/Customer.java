package com.fawry.customer;

public class Customer {
  private double balance;

  public Customer(double balance) throws Exception {
    validatePositive(balance);
    this.balance = balance;
  }

  public double getBalance() {
    return this.balance;
  }

  public void increaseBalance(double increasedAmount) throws Exception {
    validatePositive(increasedAmount);
    this.balance += increasedAmount;
  }

  public void reduceBalance(double reducedAmount) throws Exception {
    validatePositive(reducedAmount);
    this.balance -= reducedAmount;
  }

  public boolean isSufficientBalance(double receiptAmount) {
    return receiptAmount >= 0 && this.balance >= receiptAmount;
  }

  private void validatePositive(double amount) throws Exception {
    if (amount <= 0) {
      throw new Exception("Amount must be > 0");
    }
  }
}
