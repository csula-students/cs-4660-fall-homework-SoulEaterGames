package csula.cs4660.exercises;

import com.google.common.collect.Lists;

import java.io.File;
<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.util.Scanner;
=======
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
>>>>>>> 6c705035dd2e0fc0493533e929b85392ac775ab2

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
<<<<<<< HEAD
    public FileRead(File file) throws FileNotFoundException {

        Scanner input = new Scanner(file);

        for (int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++){
                numbers[i][j] = input.nextInt();
            }
        }

=======
    public FileRead(File file) {
        // TODO: read the file content and store content into numbers
        List<List<Integer>> listOfNumbers = Lists.newArrayList();
        try (Stream<String> stream = Files.lines(file.toPath())) {
            stream.forEach(line -> {
                List<Integer> lineNumbers = Lists.newArrayList();
                for (String token: line.split(" ")) {
                    lineNumbers.add(Integer.parseInt(token));
                }
                System.out.println(line);
                listOfNumbers.add(lineNumbers);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        numbers = converList(listOfNumbers);
>>>>>>> 6c705035dd2e0fc0493533e929b85392ac775ab2
    }

    /**
     * Read the file assuming following by the format of split by space and next
     * line. Display the sum for each line and tell me
     * which line has the highest mean.
     *
     * lineNumber starts with 0 (programming friendly!)
     */
    public int mean(int lineNumber) {
<<<<<<< HEAD
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

=======
        return sum(lineNumber) / numbers[lineNumber].length;
    }

    public int max(int lineNumber) {
        int max = Integer.MIN_VALUE;
        for (int i : numbers[lineNumber]) {
            max = Integer.max(max, i);
        }
>>>>>>> 6c705035dd2e0fc0493533e929b85392ac775ab2
        return max;
    }

    public int min(int lineNumber) {
<<<<<<< HEAD
        int min = numbers[lineNumber][0];

        for (int i = 0; i < numbers[lineNumber].length; i++) {
            if (min > numbers[lineNumber][i]) {
                min = numbers[lineNumber][i];
            }
        }

=======
        int min = Integer.MAX_VALUE;
        for (int i : numbers[lineNumber]) {
            min = Integer.min(min, i);
        }
>>>>>>> 6c705035dd2e0fc0493533e929b85392ac775ab2
        return min;
    }

    public int sum(int lineNumber) {
        int sum = 0;
<<<<<<< HEAD

        for (int i = 0; i < numbers[lineNumber].length; i++) {
            sum += numbers[lineNumber][i];
        }

        return sum;
    }

=======
        for (int i : numbers[lineNumber]) {
            sum += i;
        }
        return 0;
    }

    private int[][] converList(List<List<Integer>> arrayList) {
        int[][] array = new int[arrayList.size()][];
        for (int i = 0; i < arrayList.size(); i++) {
            List<Integer> row = arrayList.get(i);
            array[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j ++) {
                array[i][j] = row.get(j);
            }
        }
        return array;
    }
>>>>>>> 6c705035dd2e0fc0493533e929b85392ac775ab2
}
