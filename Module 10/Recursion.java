/*
 * Zachary Morrell
 * CIT 272 Object Oriented Programming and Data Structures.
 *  Professor Jeremy Doolin
 */

import java.util.Scanner;

 /*
 *  A program that uses recursion to sum up the total of the target number.
 */
public class Recursion {

    public static void main(String[] args) {
        System.out.println(recursion(request_valid_int()));
    }

    /*
     * A recursion function that adds numbers, starting at the target number, until 0 is reached.
     * ex: 5 + 4 + 3 + 2 + 1 = 15.
     */
    public static int recursion(int last_number) {
        if(last_number == 0) {
            return(last_number);
        }
        return last_number + recursion(last_number - 1);
    }

    /*
     * Gathers user input to ensure it is properly formatted.
     * Proper formatting would be a whole integer greater than -1.
     */
    public static int request_valid_int() {

        Scanner source_scanner = new Scanner(System.in);
        boolean valid = false;
        int return_int = -1;
        System.out.println("Enter a number to add to using recursion: ");

        while (!valid) {
            try {
                // Reads the user input as an integer.
                return_int = source_scanner.nextInt();
                // Throw exception if the number is not positive.
                if (return_int < 0) { throw new Exception(); }
                // Return true as the integer is valid.
                valid = true;
            } catch (Exception e) {
                // The user gave invalid input, supply an error message.
                System.out.println("Please enter a valid, whole, integer: ");
                // Move scanner to new Line or else a loop of exceptions will occur.
                source_scanner.nextLine();
            }
        }
        // Close the scanner as it is no longer needed.
        source_scanner.close();
        // Return the user's int.
        return return_int;
    }
}