/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author kristian colville
 *
 * DataController is responsible for handling data logic from the user.
 */
public class DataController {

    private TerminalView menu;

    /**
     * Constructor for DataController.
     * 
     * @param menu is the TerminalView instance to the used for user interaction.
     * This dependency is injected to separate concerns.
     */
    public DataController(TerminalView menu) {
        this.menu = menu;
    }

}
