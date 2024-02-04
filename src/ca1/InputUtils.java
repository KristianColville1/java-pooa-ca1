/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author kristian
 */
public class InputUtils {

    /**
     * Gets input from the user using Scanner.
     *
     * @param range indicates the options available to the user between 1 and
     * range.
     * @param maxAttempts indicates the amount of times to try getting valid
     * input before giving up.
     * @param onInvalidInput provides an option to call another method if this
     * action fails.
     * @return the users input an integer.
     */
    public static int getUserChoice(int range, int maxAttempts, Runnable onInvalidInput) {
        // creates scanner & menu instances
        Scanner sc = new Scanner(System.in);
        TerminalView menu = new TerminalView();
        int userChoice;

        // while the users max attempts are greater than 0
        while (maxAttempts > 0) {
            // try to get the users choice
            try {
                System.out.println("Enter your choice: ");
                userChoice = sc.nextInt();

                // check if the choice is within the valid range
                if (userChoice >= 1 && userChoice <= range) {
                    return userChoice; // return the valid choice
                } else {
                    // Inform the user about the valid range and max attempts
                    menu.selectANumberRange(range);
                    maxAttempts--;
                    onInvalidInput.run(); // execute the invalid input handler
                }
            } catch (InputMismatchException e) {
                // if the input is invalid inform the user
                menu.informUserInputIsInvalid();
                maxAttempts--;
                onInvalidInput.run(); // execute the invalid input handler
                sc.next(); // consumes the invalid input to avoid infinite loop
            }
        }

        // inform user max attempts exceeded and close the app
        menu.maxAttemptsExceededCloseApp();
        userChoice = 3; // default for closing app
        return userChoice;
    }
    
    /**
     * Gets the next line of text from terminal
     * @return 
     */
    public static String getNextLine(){
        String userSelection;
        Scanner sc = new Scanner(System.in);
        userSelection = sc.nextLine();
        return userSelection;
    }
}
