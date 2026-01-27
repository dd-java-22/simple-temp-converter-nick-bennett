package edu.cnm.deepdive.tempconvert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConverterTest {

  static final double TOLERANCE_SCALE = 0.0001;
  static final double MIN_ABSOLUTE_TOLERANCE = 0.000000001;

  @ParameterizedTest
  @CsvFileSource(resources = "convert-c2f-valid.csv", useHeadersInDisplayName = true)
  void convertC2F_valid(double celsius, double expected) {
    double tolerance = Math.max(MIN_ABSOLUTE_TOLERANCE, Math.abs(expected * TOLERANCE_SCALE));
    assertEquals(
        expected,
        new Converter().convertC2F(celsius),
        tolerance
    );



  }

  @ParameterizedTest
  @ValueSource(doubles = {-273.16, -Double.MAX_VALUE})
  void convertC2F_invalid(double celsius) {
    try {
      new Converter().convertC2F(celsius);
      fail("IllegalArgumentException expected, but no exception thrown.");
    } catch (IllegalArgumentException e) {
      // Do nothing! This exception is expected.
    } catch (Exception e) {
      fail("IllegalArgumentException expected, but %s thrown.".formatted(e.getClass().getSimpleName()));
    }
  }

}