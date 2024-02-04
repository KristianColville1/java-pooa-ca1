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
     * stopApplication should handle the exiting of the application.
     */
    void stopApplication();
    
    /**
     * readDataFromFileParseAndCleanFlow should take file contents according
     * to parameters set in the class and validate the data for the user.
     */
    void readDataFromFileParseAndCleanFlow();
    
    /**
     * addNewStudentDataToFile should allow the user to input data to a file.
     */
    void addNewStudentDataToFileFlow();
}
