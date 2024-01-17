import java.util.Scanner;
import java.lang.Math;
public class TimeDilation {

    public static void main(String[] args) {

        // Speed of light defined as 'c'
        double c = 3.0 * Math.pow(10, 8);

        // Initiate doubles for decimal percentage of velocity and time.
        double percentage_velocity = 0.00, t = 0.00;

        // User for validating input for velocity and time.
        boolean valid_input = false;

        // Print to the screen the purpose of the program to the user.
        System.out.println("This program calculates Time Dilation for a space traveler. ");

        // Create a Scanner Object.
        Scanner user_input = new Scanner(System.in);

        // Get the name of the traveler and observer from user input.
        String travelers_name = get_user_input("What is the space traveler's name: ", user_input);
        String observers_name = get_user_input("What is the observer's name: ", user_input);

        // Input validation for decimal percentage of the speed of light of the space traveler
        while(!valid_input) {
            String user_response = get_user_input("Enter the decimal percentage of the speed of light that the space traveler is traveling at: ", user_input);
            // Check if input is or can be converted to a double, if it is valid_input = true and we escape the while loop.
            if(is_double(user_response)) {
                percentage_velocity = Double.parseDouble(user_response);
                valid_input = true;
            } else {
            // If the input is not a boolean or cannot be converted to a double, then output an error message.
            System.out.println("The decimal velocity requires a DECIMAL between 0 and 1.");
            }
        }
        valid_input=false;
        // Input validation for time input.
        while (!valid_input) {
            String user_response = get_user_input("Enter the amount of time that has passed for the space traveler: ", user_input);
            //If it is an integer or can be converted to a double then escape the while loop.
            if(is_double(user_response)) {
                t = Double.parseDouble(user_response);
                valid_input = true;
            } else {
                // If the input is not valid give this error message and loop back to requesting user input.
                System.out.println("The amount of time can only be an integer/number.");
            }
        }

        // Get units of time used by the traveler and observer.
        String time_units = get_user_input("What unit of time is the traveler and observer using? seconds, minutes, hours, days, months, years, globs?: ", user_input);

        // Multiply velocity percent by the constant (speed of light) to get the velocity of the traveler.
        Double v = percentage_velocity*c;

        // Close the Scanner as it is no longer needed.
        user_input.close();

        // Calculate the observer time that passed using a method call.
        Double observer_time = calculate_observer_time(t, v, c);

        // Create a final message prompt for the user.
        String final_user_message = "If "+travelers_name+" travels at "+(int)(percentage_velocity*100)+"% the speed of light, "+t+" "+time_units+" passes for "+travelers_name+", while "+observer_time+" "+time_units+" passes for "+observers_name;

        // Print the generated user prompt.
        System.out.println(final_user_message);
    }

    // Method for getting user input, validating data, and returning to the requested call.
    public static String get_user_input(String user_prompt, Scanner scanner) {
        // Print the request prompt or message dialogue to the user.
        System.out.println(user_prompt);
        // Skips a line to wait for the user response and sets the _return string to the user_input.
        String _return = scanner.nextLine();
        // return the input back to the call.
        return _return;
    }

    // Method to check if the input is a boolean or can be converted to a boolean.
    public static boolean is_double(String check_string) {
        try{
            // If it can or is a double, return true.
            Double result = Double.parseDouble(check_string);
            return true;
            // 
        } catch(Exception e) {
            return false;
        }
    }

    // Time dilation equation: to = t/
    public static Double calculate_observer_time(Double t, Double v, Double c){
        // V/C
        Double v_over_c = v/c;
        // Square v_over_c
        v_over_c = v_over_c * v_over_c;
        // 1-(v/c)^2
        Double denominator = Math.sqrt(1-v_over_c);
        Double _return = t/denominator;
        return _return;
    }
}