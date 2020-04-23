package de.kohnlehome;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SortierenTaskThreshold extends RecursiveTask<int[]> {

    private int[] unsortedArray;
    private IMerger merger;
    private int threshhold;

    public SortierenTaskThreshold(int[] unsortedArray, IMerger merger, int threshold) {
        this.unsortedArray = unsortedArray;
        this.merger = merger;
        this.threshhold = threshold;
    }

    @Override
    protected int[] compute() {
        if(unsortedArray.length <= threshhold){
            Arrays.sort(unsortedArray);
            return unsortedArray;
        }
        else{
            int mid = unsortedArray.length/2;

            int[] leftSideOfArray = Arrays.copyOfRange(unsortedArray,0,mid);
            int[] rightSideOfArray= Arrays.copyOfRange(unsortedArray, mid, unsortedArray.length);

            //leftSideOfArray = sort(leftSideOfArray);
            //rightSideOfArray = sort(rightSideOfArray);
            SortierenTaskThreshold leftTask = new SortierenTaskThreshold(leftSideOfArray, merger, threshhold);
            SortierenTaskThreshold rightTask = new SortierenTaskThreshold(rightSideOfArray, merger, threshhold);
            invokeAll(leftTask, rightTask);


            int[] resultArray = merger.merge(leftTask.join(), rightTask.join());

            return resultArray;

        }
    }
}
