package de.kohnlehome;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class SortPerformanceTest {

    private final int size = 100000000;


    @Test
    public void testPerformance(){

        //großes Array mit Zufallszahlen erstellen
        Random rand = new Random();
        int[] unsortedArray = new int[size];
        for(int i = 0; i< size;i++){
            unsortedArray[i] = rand.nextInt(size+1);
        }

        doAnPerformanceTest(unsortedArray, new ParallelMergeSort(new Merger()));
        doAnPerformanceTest(unsortedArray, new MergeSort(new Merger()));

    }

    private void doAnPerformanceTest(int[] unsortedArray, ISortAlgorithm sortAlgorithm){
        //Startzeit messen
        long start = System.nanoTime();
        //sortieren
        sortAlgorithm.sort(unsortedArray);
        //Endzeit messen
        long ende = System.nanoTime();
        //Differenz berechnen
        long dif= (ende-start)/1000000;
        //Differenz ausgeben
        System.out.println(sortAlgorithm.getClass().getSimpleName()+":\t" + dif + "ms");
    }
}
