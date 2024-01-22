import java.util.Scanner;

/*
 * This program converts Fahrenheit temperatures to  Celsius and Kelvin.
 * 
 * Author: Zachary Morrell
 * Assignment: Module 2 Exercise: Temperature Conversion
 * Date: 1/22/2024
 * Professor: Jeremy Doolin
 */

public class TempConversion {
    static Boolean running = true;
    public static void main(String[] args) {
        System.out.println("\nThis program converts Fahrenheit to both Celsius and Kelvin.\nUse quit to exit this program.\n");
        Scanner user_input;
        do {
            user_input = new Scanner(System.in);
            System.out.println("Enter the temperature in Fahrenheit: ");
            String input = user_input.nextLine();
            handle_input(input);
        } while(running);
        // Close the scanner input stream.
        user_input.close();
        
    }
    // Takes the input, processes it, then print to console through print_results method.
    public static void handle_input(String input) {
        switch (input) {
            case "quit":
                running = false;              
                break;
        
            default:
                try {
                    Double doub_input = Double.parseDouble(input);
                    Double celsius = f_to_c(doub_input);
                    Double kelvin = f_to_k(doub_input);
                    print_results(doub_input, celsius, kelvin);
                } catch (Exception e) {
                    System.out.println("Other than the quit command, intergers are the only acceptable inputs.");
                }

                break;
        }
    }
    // Fahrenheit to Celsius conversion 5/9(F-32)
    public static double f_to_c(double fahrenheit) {
        return ((double)5/9 * (fahrenheit-32));
    }
    // Fahrenhei to Kelvin conversion (F-32) * 5/9 + 273.15
    public static double f_to_k(double fahrenheit) {
        return ((fahrenheit-32) * ((double)5/9) + 273.15);
    }
    // Print the resultant conversions of the input Fahrenheit.
    public static void print_results(double fahrenheit, double celsius, double kelvin) {
        // (%) Beginning of farmat specifier, (.2) is the decimal place, and (f) is the datatype or float in my case.
        String formatted_string = String.format("Farenheit: %.2f\nCelsius: %.2f\nKelvin: %.2f",fahrenheit, celsius, kelvin);;
        if(kelvin < 0) {
            formatted_string = String.format("Farenheit: %.2f\nCelsius: %.2f\nKelvin: Invalid temperature. Cannot be below absolute zero.",fahrenheit, celsius);        
        }
        System.out.println(formatted_string);
    }
}