/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Final class StudentFileHandler is the last inheritance of FileHandler.
 * StudentFileReader must not be extended.
 *
 * Processes student information from the file contents.
 *
 * @author kristian
 */
public final class StudentFileHandler extends FileHandler<Student> {

    private final List<Student> allStudentsList;
    private final StudentRepository studentRepository;
    private final TerminalView menu;
    private final Runnable exitApp;

    /**
     * Constructor for StudentFileHandler.
     *
     * Initializes the fileContentsList for storing information from a file.
     *
     * Injects the studentRepository dependency.
     *
     * @param studentRepository the location to store the extracted data
     */
    public StudentFileHandler(StudentRepository studentRepository, TerminalView menu, Runnable exitApp) {
        super();
        this.allStudentsList = new ArrayList<Student>();
        this.studentRepository = studentRepository;
        this.menu = menu;
        this.exitApp = exitApp;
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
     */
    @Override
    public void processData(List<String> dataList) {
        String firstName;
        String lastName;
        String studentID;
        int classes;
        ArrayList<String> name;
        for (int info = 0; info < dataList.size(); info++) {
            name = createStudentName(dataList.get(info));
            firstName = name.get(0);
            lastName = name.get(1);
            classes = Integer.valueOf(dataList.get(++info));
            studentID = dataList.get(++info);
            Student student = new Student(
                    firstName,
                    lastName,
                    studentID,
                    classes);
            allStudentsList.add(student);
        }
        validateData(allStudentsList);
    }

    /**
     * Validates the student objects and adds them to the studentRepository
     * using the StudentValidator class.
     *
     * Injects the studentRepository into the
     *
     * @param data list of student objects to validate
     */
    @Override
    public void validateData(List<Student> data) {
        // Initializes validator and validates the students
        StudentValidator validator = new StudentValidator();
        validator.performValidationChecksOnStudentData(data);
    }

    /**
     * createStudentName is responsible for making the strings containing a
     * students first and last name. Preps this content for validation
     * elsewhere.
     *
     * @param name the entire string containing first and last name
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

    /**
     * Stores the student information in the repository
     */
    public void storeStudentInformationInRepository() {
        // store data in the student repository
        for (Student student : allStudentsList) {
            if (student.isValid()) {
                studentRepository.addValidStudent(student);
            } else {
                studentRepository.addInvalidStudent(student);
            }
        }
    }

    /**
     * Writes the valid student data to a file.
     * 
     * @param fileName the location to write the information to
     */
    @Override
    public void writeDataToFile(String fileName) {
        List<Student> data = studentRepository.getValidStudents();
        // try to write to file location
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            // for each student object write the data to the terminal
            for(Student student : data){
                writer.write(
                        String.format(
                                "%s - %s",
                                student.getIdentityNumber(),
                                student.getLastName()));
                writer.newLine();
                writer.write(student.getWorkloadDescription());
                writer.newLine();
                writer.newLine();
            }
        } catch(IOException e){
            System.out.println("Error writing data to file");
        }
    }
    
    /**
     * Overloaded method writeDataToFile for deciding which type of writing
     * is needed in the application flow.
     * 
     * @param fileName the location of the file to write to
     * @param manual Boolean to decide which route to take
     */
    @Override
    public void writeDataToFile(String fileName, Boolean manual){
        // if not manual writing then normal flow
        if(!manual){
            writeDataToFile(fileName);
        }
        // creates the StudentFileWriter and handles that user flow
        StudentFileWriter writer;
        try {
            writer = new StudentFileWriter(new FileWriter(fileName), menu, () -> exitApp.run());
            writer.handleManualWritingFlow();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
   
}
