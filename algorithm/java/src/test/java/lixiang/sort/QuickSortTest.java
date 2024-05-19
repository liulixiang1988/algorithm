package lixiang.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void quickSort() {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{5, 4, 3, 2, 1};

        quickSort.quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+" "+arr[i]);
        }
    }
}