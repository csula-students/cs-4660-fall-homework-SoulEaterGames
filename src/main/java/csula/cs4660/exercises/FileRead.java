package csula.cs4660.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Introduction Java exercise to read file
 */
public class FileRead {
    int row = 5;
    int column = 8;
    int[][] numbers = new int[row][column];

    /**
     * Read the file and store the content to 2d array of int
     * @param file read file
     * @throws FileNotFoundException
     */
    public FileRead(File file) throws FileNotFoundException {

        Scanner input = new Scanner(file);

        for (int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++){
                numbers[i][j] = input.nextInt();
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
        int mean = 0;

        for (int i = 0; i < numbers[lineNumber].length; i++) {
            mean += numbers[lineNumber][i];
        }

        int meanestMean = mean / column;

        return meanestMean;
    }

    public int max(int lineNumber) {
        int max = numbers[lineNumber][0];

        for (int i = 0; i < numbers[lineNumber].length; i++) {
            if (max < numbers[lineNumber][i]) {
                max = numbers[lineNumber][i];
            }
        }

        return max;
    }

    public int min(int lineNumber) {
        int min = numbers[lineNumber][0];

        for (int i = 0; i < numbers[lineNumber].length; i++) {
            if (min > numbers[lineNumber][i]) {
                min = numbers[lineNumber][i];
            }
        }

        return min;
    }

    public int sum(int lineNumber) {
        int sum = 0;

        for (int i = 0; i < numbers[lineNumber].length; i++) {
            sum += numbers[lineNumber][i];
        }

        return sum;
    }

}