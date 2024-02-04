/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.List;
import java.util.Map;

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
        System.out.println("Maximum attempts exceeded. Closing application.");
    }

    /**
     * Writes invalid to the terminal.
     *
     * Takes in a list of students to write to the terminal, uses a lambda to
     * map the hash map key values to the terminal with reasons why each student
     * is invalid.
     *
     * @param students list of student objects to use
     */
    public void writeInvalidDataToTerminal(List<Student> students) {
        // print invalid results
        System.out.println("#-----------------------------------------------------#");
        System.out.println("---------------------Invalid Data Detected-------------");
        System.out.println("                     RESULTS:");

        // for each student object
        for (Student student : students) {
            // print out the invalid infomation
            System.out.println("This student is invalid: ");
            System.out.println(String.format("%s %s", student.getFirstName(), student.getLastName()));
            System.out.println("REASONS:");
            // for each invalid reason print it out
            student.getInvalidReasons().forEach((key, value) -> {
                System.out.println(String.format("%s : %s", key, value));
            });
            System.out.println("\n\n");
        }

    }
}
