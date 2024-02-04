/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kristian colville
 *
 * DataController is responsible for handling data logic from the user.
 */
public class DataController implements IDataController {

    private final TerminalView menu; // TerminalMenu instance.
    private final Runnable exitApp; // Runnable to stop app.
    private final StudentRepository studentRepository; // student object storage
    private final StudentFileHandler studentFileHandler; // handles student file

    /**
     * Constructor for DataController.
     *
     * @param menu is the TerminalView instance to the used for user
     * interaction. This dependency is injected to separate concerns.
     * @param exitApp is a Runnable that serves as an event listener to signal
     * that the application should be exited. DataController posses the ability
     * to terminate the application.
     *
     * Also initializes a student repository and injects it into the student
     * file handler.
     */
    public DataController(TerminalView menu, Runnable exitApp) {
        this.menu = menu;
        this.exitApp = exitApp;
        this.studentRepository = new StudentRepository();
        this.studentFileHandler = new StudentFileHandler(
                this.studentRepository,
                this.menu);
    }

    /**
     * After menu options are displayed to the user. Get the user's selection
     * for the initial welcome menu and decide which flow to continue on.
     */
    @Override
    public void handleUserFlow() {
        /**
         * Gets the user's choice and specifies the option limit. Provides a
         * lambda expression for displaying the welcome options should the user
         * not provide a valid integer. sets the maximum attempts before giving
         * up.
         */
        int userChoice = InputUtils.getUserChoice(
                3,
                5,
                () -> menu.displayWelcomeOptions());

        /**
         * Depending on the user choice from the welcome menu options the
         * application will flow in different directions.
         *
         * case1: the application performs the default flow. case2: the
         * application performs the additional functionality which includes
         * adding contents from terminal to the file.
         */
        switch (userChoice) {
            case 1:
                System.out.println("1 selected");
                readDataFromFileParseAndCleanFlow();
                break;
            case 2:
                addNewStudentDataToFileFlow();
                break;
            default:
                stopApplication();
        }
    }

    /**
     * Controls the flow for when a user skips the additional functionality
     * provided and simply wants to read content from a file and parse the data
     * and have it written to another file in a specific format.
     *
     * Reads the data from a file and stores the information in the student
     * repository. Writes the data to another file and writes the invalid data
     * to the terminal.
     */
    @Override
    public void readDataFromFileParseAndCleanFlow() {
        studentFileHandler.readData("students.txt");
        studentFileHandler.storeStudentInformationInRepository();
        studentFileHandler.writeDataToFile("status.txt", false);
        menu.writeInvalidDataToTerminal(studentRepository.getInvalidStudents());
        menu.displayWelcomeOptions();
        handleUserFlow(); // shows main menu again
    }

    /**
     * Controls the flow for when a user wants to use the additional
     * functionality provided and wants to also add data to a file. Controls the
     * logic for this flow.
     */
    @Override
    public void addNewStudentDataToFileFlow() {
        studentFileHandler.writeDataToFile("status.txt", true);
    }

    /**
     * Stops the application - triggers event listener in main controller to
     * stop application.
     */
    @Override
    public void stopApplication() {
        exitApp.run();
    }
}
