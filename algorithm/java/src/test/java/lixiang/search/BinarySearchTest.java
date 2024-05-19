package lixiang.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    public void binarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = new int[]{1, 2, 3, 4, 5};

        assertEquals(0, binarySearch.binarySearch(arr, 1));
        assertEquals(1, binarySearch.binarySearch(arr, 2));
        assertEquals(2, binarySearch.binarySearch(arr, 3));
        assertEquals(3, binarySearch.binarySearch(arr, 4));
        assertEquals(4, binarySearch.binarySearch(arr, 5));
        assertEquals(-1, binarySearch.binarySearch(arr, 6));
    }
}