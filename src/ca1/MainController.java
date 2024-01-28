/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author kristian colville
 *
 * Main controller class is the brain of the application.
 */
public class MainController {

    // appRunning is used to keep track of the applications running status.
    private boolean appRunning;
    private TerminalView menu;
    // dataController is responsible for handling the data logic
    private DataController dataController;

    /**
     * Constructor for the MainController class. This constructor initializes
     * MainController objects.
     * 
     * Dependencies are injected here.
     */
    public MainController() {
        this.appRunning = true;
        this.menu = new TerminalView();
         // menu dependency injected for datacontroller
        this.dataController = new DataController(menu);
    }

    /**
     * Responsible for running the application processes for the user.
     */
    public void startApp() {
        // While loop that continues as long as appRunning is true
        while (appRunning) {
            /**
             * This is the highest try catch block in the application. Its
             * designed to catch and handle any uncaught exceptions from lower
             * in the application.
             *
             * This ensures the application can handle errors gracefully.
             *
             * Helps to provide feedback for better exception handling lower
             * down the application.
             *
             */

            // displays the welcome options to the user in the terminal
            menu.displayWelcomeOptions();
            try {
                // Application Logic
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
