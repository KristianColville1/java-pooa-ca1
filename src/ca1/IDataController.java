/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author kristian colville
 *
 * This is an interface for DataController in the terminal application. This
 * interface defines the functionalities that any data controller should
 * implement.
 */
public interface IDataController {

    /**
     * Gets the users selection through the terminal and
     *
     * @return the users selection as an integer
     */
    int getUserChoice();

}