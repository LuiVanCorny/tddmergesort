package de.kohnlehome;

import java.util.Arrays;

public class StreamsParallelSort implements ISortAlgorithm {
    @Override
    public int[] sort(int[] unsortedArray) {

        int[] resultArray = Arrays.stream(unsortedArray).parallel().sorted().toArray();

        return resultArray;
    }
}
