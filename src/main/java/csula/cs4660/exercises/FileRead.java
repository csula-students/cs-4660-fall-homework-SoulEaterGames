package csula.cs4660.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Introduction Java exercise to read file
 */
public class FileRead {
    private int[][] numbers;
    int row = 8;
    int column = 5;
    /**
     * Read the file and store the content to 2d array of int
     * @param file read file
     * @throws FileNotFoundException
     */
    public FileRead(File file) throws FileNotFoundException {
        // TODO: read the file content and store content into numbers

        Scanner input = new Scanner(file);
        String line = input.nextLine();
        String[] n = line.split(" ");

        for(int i = 0; i < row; i++){
          for(int j = 0; j < column; j++){
            numbers[i][j] = Integer.parseInt(n[j]);
          }
        }

    }

    /**
     * Read the file assuming following by the format of split by space and next
     * line. Display the sum for each line and tell me
     * which line has the highest mean.
     *
     * lineNumber starts with 0 (programming friendly!)
     */
    public int mean(int lineNumber) {
        return 0;
    }

    public int max(int lineNumber) {
        return 0;
    }

    public int min(int lineNumber) {
        return 0;
    }

    public int sum(int lineNumber) {
        return 0;
    }

    public static void main(String[] args) {

    }

}
