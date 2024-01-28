/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author kristian colvilleF
 *
 * This is an interface for DataController in the terminal application. This
 * interface defines the functionalities that any data controller should
 * implement.
 */
public interface IDataController {

    /**
     * Should handle the user flow of the application and trigger conditional
     * events.
     */
    void handleUserFlow();

    /**
     * Gets the users selection through the terminal and
     *
     * @range indicates the highest selection available by user as integer.
     * @onInvalidInput method to be called decided by the function calling if
     * the data is invalid. Makes the dynamic and more reusable. Helps tidy code
     * elsewhere.
     * @return the users selection as an integer
     */
    int getUserChoice(int range, Runnable onInvalidInput);

}
