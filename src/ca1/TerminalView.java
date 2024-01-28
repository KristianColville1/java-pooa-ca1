/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author kristian colville
 *
 * Handles the terminal view for the user. TerminalView implements the
 * ITerminalView interface.
 */
public class TerminalView implements ITerminalView {

    /**
     * Displays the welcome message and options for the user.
     */
    @Override
    public void displayWelcomeOptions() {
        System.out.println("#-----------------------------------------------------#");
        System.out.println("      Welcome to the Student Management System        ");
        System.out.println("#-----------------------------------------------------#");
        System.out.println("\n");
        System.out.println("      Please Select an Option:");
        System.out.println("      (1) Validate Student Data From File");
        System.out.println("      (2) Add New Student Data");
        System.out.println("      (3) Exit");
        System.out.println("Your Selection: ");
    }

    /**
     * Informs user of the number range expected for valid input.
     *
     * @param range indicates the expected integer range the input should be.
     */
    @Override
    public void selectANumberRange(int range) {
        System.out.println("Please select a number between 1 - " + range);
        System.out.println("Enter: ");
    }

    /**
     * Informs user the input given is invalid.
     */
    @Override
    public void informUserInputIsInvalid() {
        System.out.println("Your input was not a valid number, try again.");
    }

    /**
     * Informs user that the maximum attempts were reached trying to get valid
     * input and that the application is closing.
     */
    @Override
    public void maxAttemptsExceededCloseApp() {

    }
}
