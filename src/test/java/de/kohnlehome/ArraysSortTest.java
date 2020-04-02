package de.kohnlehome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArraysSortTest {
    private ArraysSort arraysSort;

    @BeforeEach
    public void init(){
        arraysSort = new ArraysSort();
    }

    @Test
    public void test_53124(){
        int[] unsorted = {5,3,1,2,4};
        //Act
        int[] sorted = arraysSort.sort(unsorted);

        //Assert
        int[]expected = {1,2,3,4,5};
        assertThat(sorted).isEqualTo(expected);
    }

    @Test
    public void test_432571(){
        int[] unsorted = {4,3,2,5,7,1};
        //Act
        int[] sorted = arraysSort.sort(unsorted);

        //Assert
        int[]expected = {1,2,3,4,5,7};
        assertThat(sorted).isEqualTo(expected);
    }

    @Test
    public void test_9841546(){
        int[] unsorted = {9,8,4,1,5,4,6};
        //Act
        int[] sorted = arraysSort.sort(unsorted);

        //Assert
        int[]expected = {1,4,4,5,6,8,9};
        assertThat(sorted).isEqualTo(expected);
    }
}
