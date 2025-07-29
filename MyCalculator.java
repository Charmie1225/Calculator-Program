package hw;

import java.util.Scanner;

public class MyCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String userChoice;
        String mathOperator = null;
        double result = 0.0;

        do {
            System.out.println("Enter the calculator mode: Standard/Scientific?");
            String mode = input.next();

            while (!mode.equals("Standard") && !mode.equals("Scientific")) {
                System.out.println("Invalid Mode");
                System.out.println("Enter the calculator mode: Standard/Scientific?");
                mode = input.next();
            }

            if (mode.equals("Standard")) {
                System.out.println("The calculator will operate in standard mode.");
                System.out.println("Enter '+' for addition, '-' for subtraction, '*' for multiplication, '/' for division");
                mathOperator = input.next();

                if (mathOperator.equals("+") || mathOperator.equals("-") || mathOperator.equals("*") || mathOperator.equals("/")) {
                    System.out.println("How many numbers do you want to " + getOperationName(mathOperator) + "?");
                    int number = input.nextInt();
                    System.out.println("Enter " + number + " numbers");

                    result = (mathOperator.equals("*")) ? 1.0 : 0.0;

                    for (int i = 1; i <= number; i++) {
                        double answer = input.nextDouble();

                        if (mathOperator.equals("+")) {
                            result += answer;
                        } else if (mathOperator.equals("-")) {
                            if (i == 1) {
                                result = answer;
                            } else {
                                result -= answer;
                            }
                        } else if (mathOperator.equals("*")) {
                            result *= answer;
                        } else if (mathOperator.equals("/")) {
                            if (i == 1) {
                                result = answer;
                            } else {
                                result /= answer;
                            }
                        }
                    }

                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Invalid operator " + mathOperator);
                }
            } else if (mode.equals("Scientific")) {
                System.out.println("The calculator will operate in scientific mode.");
                System.out.println("Enter '+' for addition, '-' for subtraction, '*' for multiplication, '/' for division, 'sin' for sin x, 'cos' for cos x, 'tan' for tan x:");
                mathOperator = input.next();

                if (mathOperator.equals("+") || mathOperator.equals("-") || mathOperator.equals("*") || mathOperator.equals("/")) {
                    System.out.println("How many numbers do you want to " + getOperationName(mathOperator) + "?");
                    int number = input.nextInt();
                    System.out.println("Enter " + number + " numbers");

                    result = (mathOperator.equals("*")) ? 1.0 : 0.0;

                    for (int i = 1; i <= number; i++) {
                        double answer = input.nextDouble();

                        if (mathOperator.equals("+")) {
                            result += answer;
                        } else if (mathOperator.equals("-")) {
                            if (i == 1) {
                                result = answer;
                            } else {
                                result -= answer;
                            }
                        } else if (mathOperator.equals("*")) {
                            result *= answer;
                        } else if (mathOperator.equals("/")) {
                            if (i == 1) {
                                result = answer;
                            } else {
                                result /= answer;
                            }
                        }
                    }
                } else if (mathOperator.equals("sin") || mathOperator.equals("cos") || mathOperator.equals("tan")) {
                    System.out.println("Enter a number in radians to find the " + getOperationName(mathOperator));
                    double answer = input.nextDouble();

                    if (mathOperator.equals("sin")) {
                        result = Math.sin(answer);
                    } else if (mathOperator.equals("cos")) {
                        result = Math.cos(answer);
                    } else if (mathOperator.equals("tan")) {
                        result = Math.tan(answer);
                    }

                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Invalid operator " + mathOperator);
                }
            }

            System.out.println("Do you want to start over? (Y/N)");
            userChoice = input.next();
        } while (userChoice.equalsIgnoreCase("Y"));

        System.out.println("Goodbye");
    }

    public static String getOperationName(String mathOperator) {
        switch (mathOperator) {
            case "+":
                return "addition";
            case "-":
                return "subtraction";
            case "*":
                return "multiplication";
            case "/":
                return "division";
            case "sin":
                return "sine";
            case "cos":
                return "cosine";
            case "tan":
                return "tangent";
            default:
                return "null";
        }
    }
}
