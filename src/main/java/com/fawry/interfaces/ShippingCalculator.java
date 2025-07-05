package com.fawry.interfaces;

import java.util.Map;

import com.fawry.shipping.ShippableSummary;

public interface ShippingCalculator {
  double calculateShipmentPrice(Map<String, ShippableSummary> summaryMap);
}
