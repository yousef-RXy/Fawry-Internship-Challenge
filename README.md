# Fawry Rise Journey - Full Stack Development Internship Challenge

This is my submission for the **Fawry Rise Journey - Full Stack Development Internship Challenge**. It implements a console-based e-commerce checkout system in Java, demonstrating full-stack design thinking and OOP principles.

---

## ✅ Problem Statement

Design an e-commerce system with these features:

- Define products with name, price, and quantity.
- Some products may expire (like Cheese and Biscuits).
- Some products require shipping with weight (e.g., Cheese, TV).
- Customers add products to a cart, not exceeding available quantity.
- Customers can checkout:
  - Order subtotal
  - Shipping fees
  - Paid amount
  - Customer balance after payment
  - Error on empty cart, insufficient balance, expired/out-of-stock items.
- Collect all shippable items and send them to a Shipping Service that accepts objects implementing:
  - `String getName()`
  - `double getWeight()`

---

## ✅ Solution Overview

The project is implemented in **Java**. It uses:

- OOP inheritance and interfaces
- SOLID design principles
- Factory pattern for product creation
- Shipping service with weight-based pricing
- Validation for stock, expiry, balance
- Thread-safety using Semaphores for checkout

---

## ✅ Main Features

✔️ Define different product types:

- Regular products
- Expirable products
- Shippable products
- Expirable + Shippable products

✔️ Cart management:

- Add/remove/reduce items
- Prevent exceeding available quantity

✔️ Checkout service:

- Validates cart and items
- Ensures balance
- Calculates shipping fees
- Prints detailed receipt

✔️ Shipping service:

- Aggregates shippable items
- Calculates total weight and shipping cost

✔️ Customer account:

- Balance management
- Thread-safe checkout using Semaphore

---

## ✅ Technologies Used

- Java 17+
- Plain console output for demonstration
- No external libraries

---

## ✅ How to Run

Clone the repo, then compile and run:

```bash
javac -d out src/**/*.java
java -cp out com.fawry.Main
```
