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
 * Runs the main application logic.
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
     *
     * Event listeners are injected here.
     */
    public MainController() {
        this.appRunning = true;
        this.menu = new TerminalView();
        /**
         * Injecting dependencies into the DataController. menu: provides access
         * to the menu instance to modify the terminal lambda expression:
         * enables DataController to control the applications running state.
         * When the lambda expression is invoked it will signal the application
         * to stop.
         */
        this.dataController = new DataController(menu, () -> appRunning = false);
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
            try {
                // Application Logic
                // displays the welcome options to the user in the terminal
                menu.displayWelcomeOptions();
                dataController.handleUserFlow();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
