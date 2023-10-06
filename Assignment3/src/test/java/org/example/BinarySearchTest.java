package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTest {
    static int[] arr;

    int x;
    @BeforeClass
    public static void init() {
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
    }
    @After
    public void clean() {
        x = 0;
    }

    /**
     * Test 1:
     * Input: arr = 1, 2, 3, 4, 5, 6, 7
     *        x = 3
     * Expected Output: 2 (vì index của 3 trong arr là 2)
     */
    @Test
    public void testBinarySearch1() {
        x = 3;
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        Assert.assertEquals(2, BinarySearch.binarySearch(arr, x));
    }

    /**
     * Test 2:
     * Input: arr = 1, 2, 3, 4, 5, 6, 7
     *        x = 0
     * Expected Output: -1 (vì -1 không xuất hiện trong arr)
     */
    @Test
    public void testBinarySearch2() {
        x = 0;
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        Assert.assertEquals(-1, BinarySearch.binarySearch(arr, x));
    }

    @Test
    public void testConstructorBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();
    }
}