/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author kristian colville
 *
 * Handles the terminal view for the user.
 * TerminalView implements the ITerminalView interface.
 */
public class TerminalView implements ITerminalView {

    /**
     * TerminalView Constructor
     */
    public TerminalView() {

    }

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
}
