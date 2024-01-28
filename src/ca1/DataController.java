/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author kristian colville
 *
 * DataController is responsible for handling data logic from the user.
 */
public class DataController implements IDataController {

    private TerminalView menu; // TerminalMenu instance.
    private Runnable exitApp; // Runnable to stop app.

    /**
     * Constructor for DataController.
     *
     * @param menu is the TerminalView instance to the used for user
     * interaction. This dependency is injected to separate concerns.
     * @param exitApp is a Runnable that serves as an event listener to signal
     * that the application should be exited. DataController posses the ability
     * to terminate the application.
     */
    public DataController(TerminalView menu, Runnable exitApp) {
        this.menu = menu;
        this.exitApp = exitApp;
    }

    /**
     * After menu options are displayed to the user. Get the user's selection
     * and
     */
    @Override
    public void handleUserFlow() {
    }

    /**
     * Gets input from the user using Scanner.
     *
     * Uses recursion until it gets valid input from the user.
     *
     * @param range indicates the options available to the user between 1 and
     * range.
     * @param onInvalidInput provides an option to call another method if this
     * action fails.
     * @return the users input an integer.
     */
    @Override
    public int getUserChoice(int range, Runnable onInvalidInput) {
        int userChoice = 0;
        Scanner sc = new Scanner(System.in);
        try {
            userChoice = sc.nextInt();
            // if the input is valid
            // and greater than range or less than 1
            if (userChoice > range || userChoice < 1) {
                System.out.println("Please select a number between 1 - " + range);
                System.out.println("Enter: ");
                getUserChoice(range, onInvalidInput); // recursion to loop back and get valid int
            }
        } catch (InputMismatchException e) {
            // if the input is invalid inform them and use recursion to repeat.
            System.out.println("Your input was not a valid number: " + userChoice);
            onInvalidInput.run();
        }
        return userChoice;
    }
}
