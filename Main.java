/********************************************
*	AUTHOR:	Blake Walker
*	LAST MODIFIED:	October 14, 2024
********************************************/

/********************************************
*	coolculator
*********************************************
*	PROGRAM DESCRIPTION:
*	The calculator program accepts user input in the form of mathematical expressions; it functions 
* as a user would expect a very basic calculator to function.
*
* This program was made without using iterable data structures because I wanted to stick to the 
* basic data types that have been discussed in class thus far.
*********************************************
*	ALGORITHM:
*	Print art
* Prompt user for input
* Collect operand1
* Collect operator
* Collect operand2
* Perform given mathematical operations
* Return result of mathematical operations
*********************************************
*	STATIC METHODS:
* getOperand()
* getOperator()
* calculate()
* colorizeString()
* printInputError()
* printASCII()
*********************************************/

import java.util.Scanner;

public class Main {
  /***** CONSTANT SECTION *****/

  // Colors for text output
  static final String RED = "\u001B[31m";
  static final String YELLOW = "\u001B[33m";
  static final String BLUE = "\u001B[34m";
  static final String PURPLE = "\u001B[35m";
  static final String CYAN = "\u001B[36m";
  static final String DEFAULT = "\u001B[0m";

  // Each line is a string of ASCII characters to be printed in sequence
  // Credit: https://patorjk.com/software/taag
  static final String ASCII_ART_1 = Main.colorizeString("                    __           __      __            ", BLUE);
  static final String ASCII_ART_2 = Main.colorizeString("  _________  ____  / /______  __/ /___ _/ /_____  _____", BLUE);
  static final String ASCII_ART_3 = Main.colorizeString(" / ___/ __ \\/ __ \\/ / ___/ / / / / __ `/ __/ __ \\/ ___/", PURPLE);
  static final String ASCII_ART_4 = Main.colorizeString("/ /__/ /_/ / /_/ / / /__/ /_/ / / /_/ / /_/ /_/ / /    ", RED);
  static final String ASCII_ART_5 = Main.colorizeString("\\___/\\____/\\____/_/\\___/\\__,_/_/\\__,_/\\__/\\____/_/     ", YELLOW);
  static final String ASCII_ART_6 = Main.colorizeString("                                                       ", DEFAULT);
  static final String ASCII_ART_7 = Main.colorizeString("                                                       ", DEFAULT);

  static final String STAR = Main.colorizeString("* ", CYAN);

  // Opens input stream
  static Scanner inputScanner = new Scanner(System.in);

  public static void main(String[] args) {
    double operand1, operand2, result;
    String operator;

    Main.printASCII();

    System.out.print(STAR + "Enter the first operand: ");   // prompt user for first operand
    operand1 = Main.getOperand();                          // collect first operand

    System.out.print(STAR + "Enter the operator: ");       // prompt user for operator
    operator = Main.getOperator();                         // collect operator                                 

    System.out.print(STAR + "Enter the second operand: "); // prompt user for second operand
    operand2 = Main.getOperand();
    System.out.println();

    inputScanner.close();                                  // close input stream

    result = Main.calculate(operand1, operator, operand2); // calculate result
    System.out.println(STAR + "Result: " + result);        // print result
  }

  // Gets number from user
  public static double getOperand()
  {
    return inputScanner.nextDouble();
  }

  // Gets operator (i.e. +. -. /, or *) from user
  public static String getOperator()
  {
    return inputScanner.next();
  }

  // Calculates result of mathematical expression
  public static double calculate(double operand1, String operator, double operand2) {
    if(operator.equals("+")) {        // check if it should add
      return operand1 + operand2;
    } else if(operator.equals("-")) { // check if it should subtract
      return operand1 - operand2;
    } else if(operator.equals("/")) { // check if it should divide
      return operand1 / operand2;
    } else if(operator.equals("*")) { // check if it should multiply
      return operand1 * operand2;
    } else {
      Main.printInputError();                  // print error message
      System.out.println();
      return 0;
    }
  }

  // Allows colorized output for ASCII art and error message
  public static String colorizeString(String text, String color)
  {
    return color + text + DEFAULT; // set text color, print text, reset text color
  }

  // Prints an error message if an invalid operator is entered
  public static void printInputError()
  {
    String errorMessage = Main.colorizeString("Invalid expression!", RED);
    System.out.println(errorMessage);
  }
  
  // Prints intro ASCII art
  public static void printASCII()
  {
    System.out.println(ASCII_ART_1);
    System.out.println(ASCII_ART_2);
    System.out.println(ASCII_ART_3);
    System.out.println(ASCII_ART_4);
    System.out.println(ASCII_ART_5);
    System.out.println(ASCII_ART_6);
    System.out.println(ASCII_ART_7);
  }
}
