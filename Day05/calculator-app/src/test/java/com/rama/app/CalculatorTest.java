package com.rama.app;

import org.junit.Test;

public class CalculatorTest {

  @Test
  public void testAdd() {
    Calculator calculator = new Calculator();
    double result = calculator.add(13, 4);
    assert result == 17;
  }

  @Test
  public void testSubtract() {
    Calculator calculator = new Calculator();
    double result = calculator.subtract(15, 5);
    assert result == 10;
  }

  @Test
  public void testMultiply() {
    Calculator calculator = new Calculator();
    double result = calculator.multiply(6, 6);
    assert result == 36;
  }

  @Test
  public void testdiv() {
    Calculator calculator = new Calculator();
    double result= Calculator.division(10,2);
    assert result == 5;

  }
}
