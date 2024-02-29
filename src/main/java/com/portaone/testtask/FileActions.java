package com.portaone.testtask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FileActions {
    static Path path = Path.of("C:\\Users\\pisar\\IdeaProjects\\testtask\\10m.txt");

    //ToDo change names
    public static int findMax() throws IOException {
        IntStream arrOfInt = Files.lines(path).mapToInt(Integer::parseInt);
        return arrOfInt.max().orElseThrow(IOException::new);
    }

    public static int findMin() throws IOException {
        IntStream arrOfInt = Files.lines(path).mapToInt(Integer::parseInt);
        return arrOfInt.min().orElseThrow(IOException::new);
    }

    public static int median() throws IOException {
        IntStream arrOfInt = Files.lines(path).mapToInt(Integer::parseInt);
        int[] arr = arrOfInt.sorted().toArray();
        if (arr.length%2 == 1) {
            return arr[arr.length/2];
        } else {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        }
    }

    public static double average() throws IOException {
        return Files.lines(path).mapToInt(Integer::parseInt).average().orElseThrow(IOException::new);
    }

    public static List<Integer> increaseSequence() throws IOException {
        IntStream arrOfInt = Files.lines(path).mapToInt(Integer::parseInt);
        int[] arr = arrOfInt.toArray();
        int count = 0;
        int tempCount = 1;
        List<Integer> result = new ArrayList<>();
        List<Integer> tempArr = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]<arr[i+1]) {
                tempCount++;
                tempArr.add(arr[i]);
            } else {
                if (tempCount > count) {
                    count = tempCount;
                    result = new ArrayList<>(tempArr);
                }
                tempCount = 1;
                tempArr.clear();
            }
        }
        return result;
    }

    public static List<Integer> decreaseSequence() throws IOException {
        IntStream arrOfInt = Files.lines(path).mapToInt(Integer::parseInt);
        int[] arr = arrOfInt.toArray();
        int count = 0;
        int tempCount = 1;
        List<Integer> result = new ArrayList<>();
        List<Integer> tempArr = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]>arr[i+1]) {
                tempCount++;
                tempArr.add(arr[i]);
            } else {
                if (tempCount > count) {
                    count = tempCount;
                    result = new ArrayList<>(tempArr);
                }
                tempCount = 1;
                tempArr.clear();
            }
        }
        return result;
    }


}
