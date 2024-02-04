/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author kristian
 */
public interface IUserInput {

    /**
     * Should handle the user flow for input
     */
    void handleManualWritingFlow();

    /**
     * Should query the user for input
     */
    void queryUser();

    /**
     * Should confirm the user's input
     */
    void confirmUserSelection();

    /**
     * Should write the selection by a user to a file
     */
    void writeUsersSelectionToFile();
}
