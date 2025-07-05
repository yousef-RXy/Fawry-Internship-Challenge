package com.fawry.shipping;

import java.util.Map;

import com.fawry.interfaces.ShippingCalculator;

public class ShippingCalculatorImp implements ShippingCalculator {
  private final double shippingRatePerKG;

  public ShippingCalculatorImp(double shippingRatePerKG) throws Exception {
    if (shippingRatePerKG <= 0)
      throw new Exception("Shipping rate must be more than 0");

    this.shippingRatePerKG = shippingRatePerKG;
  }

  @Override
  public double calculateShipmentPrice(Map<String, ShippableSummary> summaryMap) {
    if (summaryMap.isEmpty()) {
      return 0;
    }

    double totalWeight = 0;
    System.out.println("** Shipment notice **");

    for (ShippableSummary summary : summaryMap.values()) {
      double itemTotalWeight = summary.getWeight() * summary.getQuantity();
      System.out.println(summary + " g");
      totalWeight += itemTotalWeight;
    }

    System.out.printf("Total package weight %.1f kg%n", totalWeight);
    return totalWeight * shippingRatePerKG;
  }

}
