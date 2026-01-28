package edu.cnm.deepdive.tempconvert.controller;

import edu.cnm.deepdive.tempconvert.model.InputMode;
import edu.cnm.deepdive.tempconvert.service.Converter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Handles user input from stdIn, using a Converter instance to perform conversions, with InputMode
 * to select conversions, and writing output to stdOut.
 */
public class InputHandler {

  private static final Pattern NUMBER_PATTERN = Pattern.compile("[-+]?\\d+(?:\\.\\d*)?");
  private static final String CELSIUS_INPUT_PATTERN = "Celsius = %.2f; Fahrenheit = %.2f%n";
  private static final String FAHRENHEIT_INPUT_PATTERN = "Fahrenheit = %.2f; Celsius = %.2f%n";

  private InputMode mode = InputMode.CELSIUS;

  public void process() {
    Converter converter = new Converter();
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      if (scanner.hasNextDouble()) {
        double input = scanner.nextDouble();
        String output = switch (mode) {
          case CELSIUS -> CELSIUS_INPUT_PATTERN.formatted(input, converter.convertC2F(input));
          case FAHRENHEIT -> FAHRENHEIT_INPUT_PATTERN.formatted(input, converter.convertF2C(input));
        };
        System.out.print(output);
      } else {
        mode = InputMode.valueOf(scanner.next().strip().toUpperCase());
      }
    }
  }

}
