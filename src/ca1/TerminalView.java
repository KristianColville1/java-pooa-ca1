/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author kristian
 * 
 * Handles the terminal view for the user.
 */
public class TerminalView {
    
    /**
     * TerminalView Constructor
     */
    public TerminalView(){
        
    }
    
    /**
     * Displays the welcome message and options for the user.
     */
    public void displayWelcomeOptions(){
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
    
    public int getUserChoice(){
        int choice = 0;
        try{
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
        } catch(InputMismatchException e){
            System.out.println("You must enter a number: 1 or 2 or 3");
        }
        return choice;
    }
}
