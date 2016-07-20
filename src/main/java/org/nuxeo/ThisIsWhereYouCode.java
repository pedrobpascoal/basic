package org.nuxeo;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * This is where you have to code.
 * 
 * See javadoc and associated unit tests to understand what is expected
 * 
 * @author tiry
 *
 */
public class ThisIsWhereYouCode {

    /**
     * input will be a string, but it may not have a file extension. return the file
     * extension (with no period) if it has one, otherwise null
     * 
     * @param filename
     * @return null if input is null or filename has no extension and the
     *         extension without the period otherwise
     */
    public String getFileNameExtension(String filename) {
        if(filename == null)
            return null;

        String[] params = filename.split("[.]", 2);
        if(params.length > 1)
            return params[1];

        return null;
    }

    /**
     * return the longest string contained inside the input array
     * 
     * @param array input Array of values
     * @return null if input is null and the longest string otherwise
     */
    public String getLongestString(Object[] array) {
        String longest = "";

        if(array == null)
            return null;

        for(int i=0; i < array.length; i++) {
            Object current = array[i];
            if(current == null || current instanceof Integer)
                continue;

            if(array[i].getClass() == Object[].class)
                current = getLongestString((Object[]) array[i]);

            if(current.toString().length() > longest.length())
                longest = current.toString();
        }

        return longest;
    }

    /**
     * Returns true is both arrays contains the same values
     * 
     * @param array1 first Array to test
     * @param array2 second Array to test
     * @return true if both arrays contains the same values
     */
    public boolean areArraysEquals(String[] array1, String[] array2) {
        if(array1 == null && array2 == null)
            return true;
        if(array1 == null || array2 == null)
            return false;

        if(array1.length != array2.length)
            return false;

        for(int i = 0; i < array1.length; i++) {
            if(array1[i] == null && array2 == null)
                continue;
            if(array1[i] == null || array2 == null)
                return false;
            if(!array1[i].equals(array2[i]))
                return false;
        }

        return true;
    }

    /**
     * Compress the input string with a very dummy algorithm : repeated letters
     * are replaced by {n}{letter} where n is the number of repetition and
     * {letter} is the letter. n must be superior to 1 (otherwise, simply output
     * the letter)
     * 
     * @param input the input string that can only contains letters
     * @return the compressed String or null if the input is null
     */
    public String getCompressedString(String input) {
        String compressed = "";

        if(input == null)
            return null;

        char current = input.charAt(0);
        int count = 1;
        // TODO: if there is time, replace with do.while, or create a function to reduce code-dublication
        for(int i = 1; i < input.length(); i++) {
            if(current != input.charAt(i)) {
                if(count > 1)
                    compressed += count;
                compressed += current;

                current = input.charAt(i);
                count = 0;
            }
            count++;
        }
        if(count > 1)
            compressed += count;
        compressed += current;
        return compressed;
    }

    /**
     * Sort the input array of string based on lexicographic order of the
     * corresponding compressed string
     * 
     * @param array the Array to sort
     * @return the sorted array
     */
    public String[] getSortedArray(String[] array) {

        String[] sorted = new String[array.length];
        Arrays.fill(sorted, null);
        for(int i = 0; i < array.length; i++) {

            int j = 0;
            for(; j < sorted.length; j++) {
                if(sorted[j] == null)
                    break;

                int compare = array[i].compareTo(sorted[j]);
                if (compare < 0)
                {
                    break;
                }
            }
            String temp = sorted[j];
            sorted[j] = array[i];

            int h = j+1;
            for(; h < sorted.length-2; h++) {
                if (temp == null)
                    break;
                sorted[h] = temp;
                temp = sorted[h + 1];
            }
            sorted[h] = temp;
        }
        return sorted;
    }

}
