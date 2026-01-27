package edu.cnm.deepdive.tempconvert;

public class Converter {

  public static final double CELSIUS_ABSOLUTE_ZERO = -273.15;
  public static final double FAHRENHEIT_ABSOLUTE_ZERO = -459.67;
  private static final double CELSIUS_TO_FAHRENHEIT_SCALE = 9.0 / 5;
  private static final int CELSIUS_TO_FAHRENHEIT_OFFSET = 32;

  public double convertC2F(double celsius) {
    if (celsius < CELSIUS_ABSOLUTE_ZERO) {
      throw new IllegalArgumentException();
    }
    return celsius * CELSIUS_TO_FAHRENHEIT_SCALE + CELSIUS_TO_FAHRENHEIT_OFFSET;
  }

  public double convertF2C(double fahrenheit) {
    if (fahrenheit < FAHRENHEIT_ABSOLUTE_ZERO) {
      throw new IllegalArgumentException();
    }
    return (fahrenheit - CELSIUS_TO_FAHRENHEIT_OFFSET) / CELSIUS_TO_FAHRENHEIT_SCALE;
  }

}
