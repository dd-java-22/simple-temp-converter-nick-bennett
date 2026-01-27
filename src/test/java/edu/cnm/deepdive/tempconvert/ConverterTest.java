package edu.cnm.deepdive.tempconvert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class ConverterTest {

  static final double TOLERANCE_SCALE = 0.0001;

  @ParameterizedTest
  void convertC2F(double celsius, double expected) {
    assertEquals(
        -40,
        new Converter().convertC2F(-40),
        Math.abs(-40 * TOLERANCE_SCALE)
    );
  }

}