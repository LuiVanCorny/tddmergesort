package de.kohnlehome;

import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort implements IMergeSort{
    private IMerger merger;

    public ParallelMergeSort(IMerger merger) {
        this.merger = merger;
    }

    @Override
    public int[] sort(int[] unsortedArray) {
        SortierenTask sortierenTask = new SortierenTask(unsortedArray, merger);
        sortierenTask.invoke();

        return sortierenTask.join();
    }
}
