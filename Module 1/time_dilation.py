"""
Zachary Morrell
CIT 272 OOP and Data Structures
Module 1 exercise - Python and Java
Professor Jeremy Doolin

This program calculates Time Dialation for an object traveling through space and the observer.

"""

import math
def main():
    # The constant or c, which is the speed of light.
    speed_of_light = 3*(10**8)

    # Message to the user explaining the purpose of this program.
    print("This program calculates Time Dilation for a space traveler. ")

    # Space traveler's name.
    space_traveler_name = input("Space Traveler's Name: ")
    
    # Observer's name.
    observers_name = input("Observer's Name: ")

    # The velocity of the travelers as a decimal percent of c.
    traveler_velocity = 0.00
    # Input validation to ensure a decimal percentage is given.
    while(traveler_velocity<=0 or traveler_velocity >= 1):
        try:
            traveler_velocity = float(input("Please enter a decimal between 0 and 1: "))
        except:
            print("The input MUST be a decimal number between 0 and 1.")

    # Convert traveler velocity from a fraction to meters per second.
    traveler_velocity_ms = traveler_velocity * speed_of_light

    # The amount of time that has passed, as this could be a fictional time I allowed for floats.
    traveler_time_passed = 0.00
    # Input validation to ensure the input is desired for the program.
    while(traveler_time_passed<=0):
        try:
            traveler_time_passed = float(input("Enter the amount of time that has passed: "))
        except:
            print("Only integers, including decimals are accepted")

    # Easy to read math for time dilation formula: observers time = travelers time/math.sqrt(1-(v/c)^2)
    # square root of (1 - (v/c)^2)
    denominator = math.sqrt(1 - (traveler_velocity_ms/speed_of_light)**2)

    # observers time = travelers time/denominator, denominator being the denominator portion of the equation.
    observer_time = traveler_time_passed/denominator

    # Input unit of time from a user, can be a fake measurement of time since the speed measurement can be near light.
    print("\nEnter the units of time that is being measured\n")
    unit_of_time = input("seconds, minutes, hours, days, years, globs?: ")

    # Output the resultant of time difference for both parties.
    print(f"If {space_traveler_name} travels at {int(traveler_velocity*100)}% the speed of light, {traveler_time_passed} {unit_of_time} passes for {space_traveler_name}, while {observer_time} {unit_of_time} passes for {observers_name}")

main()