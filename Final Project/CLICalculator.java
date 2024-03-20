import java.util.Scanner;
/*  Milestone 1 - REQ 1.)
 * File: Calculator.java
 * A text based calculator used to solve mathematical equations.
 * 
 * Zachary Morrell
 * CIT 272 - Object Oriented Programming and Data Structures
 * Milestone 3 - Final Project Starter
 * Jeremy Doolin
 * 
 */
public class CLICalculator {
    public static void main(String[] args) {
        command = new Scanner(System.in);
        boolean running = true;
        Calculator calc = new Calculator();

        print_program_details();
        // Milestone 1 - REQ 4.)
        while (running == true) {
            String user_equation = get_user_input(command);
            // Milestone 1 - REQ 4.)
            if(user_equation.equals("exit")) {
                running = false;
                command.close();
            }
            // Milestone 1 - REQ 5.)
            String expression_validity = (calc.isValidExpression(user_equation.split(" "))) ? "VALID" : "INVALID";
            msg("The expression is " +expression_validity);
            /*equation = user_equation.split(" ");
            //Milestone 1 - REQ 6.)
            msg("There are " + equation.length + " tokens in the math expression.");*/
        }
    }
    // Global variable to hold the current progress of the equation.
    public static String[] equation;
    public static Scanner command;

    // Returns user input, as text, from the console.
    private static String get_user_input(Scanner command) {
        // Milestone 1 - REQ 2.)
        msg("Input the mathematical equation you would like solved: ");
        return command.nextLine();
    }

    // Uses message to print the program details.
    private static void print_program_details() {
        msg("\nThis program is a Calculator and is used to solve mathematical expressions.");
        // Milestone 1 - REQ 3.) - I assume you do not want input validation yet?
        msg("You must use a space after each number for operations.\n");
    }

    // Method to handle and shorten System.out.println.
    private static void msg(String message) {
        System.out.println(message);
    }
}