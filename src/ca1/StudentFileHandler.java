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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Final class StudentFileHandler is the last inheritance of FileHandler.
 * StudentFileReader must not be extended.
 *
 * This class reads a specific type of file called 'students.txt'.
 *
 * The main responsibility of this class is to read that file, parse it
 * correctly and place the information gathered into student objects.
 *
 * @author kristian
 */
public final class StudentFileHandler extends FileHandler<Student> {

    private final List<Student> allStudentsList;
    private final StudentRepository studentRepository;

    /**
     * Constructor for StudentFileHandler.
     *
     * Initializes the fileContentsList for storing information from a file.
     *
     * @param studentRepository the location to store the extracted data
     */
    public StudentFileHandler(StudentRepository studentRepository) {
        super();
        this.allStudentsList = new ArrayList<Student>();
        this.studentRepository = studentRepository;
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
            processData(fileContentsList); // creates list of students
        } catch (IOException e) {
            System.out.println(e); // catch the I/O exception
        }
    }

    /**
     * Processes the data extracted from the file and creates an array list
     * containing all created student objects.
     *
     * Stores them regardless of being valid or invalid for further processing.
     *
     * @param dataList
     * @return allStudentsList containing list of students.
     */
    @Override
    public List<Student> processData(List<String> dataList) {
        String firstName;
        String lastName;
        String studentID;
        int classes;
        ArrayList<String> name;
        for (int info = 0; info < dataList.size(); info++) {
            name = createStudentName(dataList.get(info));
            firstName = name.get(0);
            lastName = name.get(1);
            studentID = dataList.get(++info);
            classes = Integer.valueOf(dataList.get(++info));
        }

        return allStudentsList;
    }
//
//    @Override
//    public boolean validateData(Object dataItem, Object validator) {
//        return false;
//    }

    /**
     * createStudentName is responsible for making the strings containing a
     * students first and last name. Preps this content for validation
     * elsewhere.
     *
     * @param name
     * @return array list containing the first and last name
     */
    public ArrayList<String> createStudentName(String name) {
        ArrayList<String> names = new ArrayList<>();

        // check if the name contains a space
        if (name.contains(" ")) {
            // If there's a space split it
            String[] splitNames = name.split(" ", 2);
            names.add(splitNames[0]); // Add the first name
            names.add(splitNames[1]); // Add the last name
        } else {
            // if no space add the name to first and make last empty
            names.add(name);
            names.add("");
        }

        return names;
    }

}
