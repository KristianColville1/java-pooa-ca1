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
     * After menu options are displayed to the user.
     * Get the user's selection and 
     */
    @Override
    public void handleUserFlow() {
        int userChoice = 0;
        try {
            userChoice = getUserChoice();
        } catch(InputMismatchException e){
            System.out.println(e);
        }
    }

    @Override
    public int getUserChoice() {
        Scanner choice = new Scanner(System.in);
        return choice.nextInt();
    }
}
