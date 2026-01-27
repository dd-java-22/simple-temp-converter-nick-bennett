package edu.cnm.deepdive.tempconvert;

public class Converter {

  public static final double CELSIUS_ABSOLUTE_ZERO = -273.15;
  public static final double CELSIUS_TO_FAHRENHEIT_SCALE = 9.0 / 5;
  public static final int CELSIUS_TO_FAHRENHEIT_OFFSET = 32;

  public double convertC2F(double celsius) {
    if (celsius < CELSIUS_ABSOLUTE_ZERO) {
      throw new IllegalArgumentException();
    }
    return celsius * CELSIUS_TO_FAHRENHEIT_SCALE + CELSIUS_TO_FAHRENHEIT_OFFSET;
  }

}
