/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author kristian colville
 *
 * This is an interface for menu handling in the terminal application. This
 * interface defines the functionalities that any terminal view should
 * implement.
 */
public interface ITerminalView {

    /**
     * Displays the menu options to the user.
     */
    void displayWelcomeOptions();

    /**
     * Informs user of the expected input to be received.
     *
     * @param range should specify the expected integer range.
     */
    void selectANumberRange(int range);

    /**
     * Informs the user that the input given is invalid.
     */
    void informUserInputIsInvalid();

    /**
     * Responds to the user and informs them of that the maximum attempts for
     * input have been exceeded.
     */
    void maxAttemptsExceededCloseApp();
}
