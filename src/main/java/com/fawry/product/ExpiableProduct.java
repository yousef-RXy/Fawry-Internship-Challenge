package com.fawry.product;

import java.time.LocalDate;

class ExpiableProduct extends ProductImp {
  private final LocalDate expiryDate;

  public ExpiableProduct(String name, double price, int quantity, LocalDate expiryDate)
      throws Exception {
    super(name, price, quantity);

    if (expiryDate == null)
      throw new Exception("Must add expiryDate");

    this.expiryDate = expiryDate;
  }

  private boolean isExpired() {
    return expiryDate.isBefore(LocalDate.now());
  }

  @Override
  public boolean isValid(int amount) {
    return super.isValid(amount) && !isExpired();
  }
}
