/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Final class StudentFileReader is the last inheritance of FileReader.
 * StudentFileReader must not be extended.
 *
 * This class reads a specific type of file called 'students.txt'.
 *
 * The main responsibility of this class is to read that file, parse it
 * correctly and place the information gathered into student objects.
 *
 * @author kristian
 */
public final class StudentFileHandler extends FileHandler {

    private List<Student> allStudentsList;

    /**
     * Constructor for StudentFileReader.
     *
     * Initializes the fileContentsList for storing information from a file.
     */
    public StudentFileHandler() {
        super();
        this.allStudentsList = new ArrayList<Student>();
    }

    /**
     * Reads the data from the file and stores the file contents in a list.
     *
     * @param filePath The location of the file being read.
     */
    @Override
    public void readData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            /**
             * While reading is possible read each line, if the line contains
             * blank space then don't add it.
             * 
             * Store each line in the fileContentsList.
             */
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    fileContentsList.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e); // catch the I/O exception
        }
    }

    @Override
    public List processData(List dataList) {
        return fileContentsList;
    }

    @Override
    public boolean validateData(Object dataItem, Object validator) {
        return false;
    }

}
