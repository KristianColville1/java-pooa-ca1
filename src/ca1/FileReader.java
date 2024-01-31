/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.List;

/**
 * Abstract class representing a generic file reader. This class is designed to
 * be sub classed with a specific type parameter T, indicating the type of data
 * that will be read from a file. Subclasses must implement the methods to
 * define how data is read, processed and validated.
 *
 * @param <T> The type of data that this reader will process and return.
 * @author kristian
 */
public abstract class FileReader<T> {

    /**
     * Reads data from a file in the required location and converts it into a
     * list of objects of type T.
     *
     * This method must be implemented by subclasses to define how to read the
     * file contents in the desired format.
     *
     * @param filePath to locate and read.
     * @return list of file contents in the type specified in the
     * implementation.
     */
    public abstract List<T> readData(String filePath);

    /**
     * Validates a single data item of type T using a provided validator of type
     * V. This is a generic method that introduces its own type parameter V.
     *
     * @param <V> The type of the validator.
     * @param dataItem the data item to validate.
     * @param validator the validator object used for validation.
     * @return true if the data item is valid according to the validator, false
     * otherwise.
     */
    public abstract <V> boolean validateData(T dataItem, V validator);
}
