/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * StudentRepository class holds two data structures called array lists.
 *
 * This class focuses on data retrieval and storage operations relating to
 * student objects.
 *
 * These array lists separate the valid and invalid student objects that are
 * created.
 *
 * @author kristian
 */
public class StudentRepository {

    private List<Student> validStudents;
    private List<Student> invalidStudents;
    private Map<String, List<Student>> studentData;

    /**
     * Constructs a new StudentData instance. Initializes empty lists for both
     * valid and invalid students.
     *
     * Sets the type stored in the ArrayLists as Student objects only providing
     * stronger type checking and automatically casts the objects retrieved from
     * the list to the Student type.
     *
     * Stores the array lists in a hash map.
     */
    public StudentRepository() {
        this.validStudents = new ArrayList<Student>();
        this.invalidStudents = new ArrayList<Student>();
        this.studentData = new HashMap<>();
    }

    /**
     * Adds student object to the validStudents array list for storage.
     *
     * @param student The Student object to be added to the valid students list.
     */
    public void addValidStudent(Student student) {
        validStudents.add(student);
    }

    /**
     * Adds an invalid student object to the invalidStudents array list for
     * storage.
     *
     * @param student The Student object to be added to the invalid students
     * list.
     */
    public void addInvalidStudent(Student student) {
        invalidStudents.add(student);
    }

    /**
     * Retrieves the list of valid student objects
     *
     * @return A List of Student objects representing the valid students.
     */
    public List<Student> getValidStudents() {
        return validStudents;
    }

    /**
     * Retrieves the list of invalid student objects
     *
     * @return A List of Student objects representing the invalid students.
     */
    public List<Student> getInvalidStudents() {
        return invalidStudents;
    }

    /**
     * Retrieves the hash map of all student data.
     *
     * @return the hash map containing array lists for valid and invalid
     * students
     */
    public Map<String, List<Student>> getStudentData() {
        studentData.clear(); // empty first so data is up to date
        studentData.put("validStudents", validStudents);
        studentData.put("invalidStudents", invalidStudents);
        return studentData;
    }
}
