package de.kohnlehome;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class SortPerformanceTest {

    private final int size = 100000000;
    private int[] unsortedArray;

    @Test
    public void testPerformance(){

        //großes Array mit Zufallszahlen erstellen
        Random rand = new Random();
       unsortedArray = new int[size];
        for(int i = 0; i< size;i++){
            unsortedArray[i] = rand.nextInt(size+1);
        }

        doAnPerformanceTest(new ParallelMergeSort(new Merger()));
        doAnPerformanceTest(new MergeSort(new Merger()));
        doAnPerformanceTest(new ArraysParallelSort());
        doAnPerformanceTest(new ArraysSort());
        doAnPerformanceTest(new ParallelSortThreshold(new Merger(), 100000));
        doAnPerformanceTest(new StreamsParallelSort());

    }

    private void doAnPerformanceTest(ISortAlgorithm sortAlgorithm){

        int[] copyArray = unsortedArray.clone();
        //Startzeit messen
        long start = System.nanoTime();
        //sortieren
        sortAlgorithm.sort(copyArray);
        //Endzeit messen
        long ende = System.nanoTime();
        //Differenz berechnen
        long dif= (ende-start)/1000000;
        //Differenz ausgeben
        System.out.println(sortAlgorithm.getClass().getSimpleName()+":\t" + dif + "ms");
    }
}
