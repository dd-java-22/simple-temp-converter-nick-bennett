package edu.cnm.deepdive.tempconvert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConverterTest {

  static final double TOLERANCE_SCALE = 0.0001;

  @Test
  void convertC2F() {
    assertEquals(
        -40,
        new Converter().convertC2F(-40),
        Math.abs(-40 * TOLERANCE_SCALE)
    );
  }

}