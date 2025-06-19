package gfg.problemsolving.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GFG_005_NextPermutation {

    void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    void reverse(int[] arr, int start) {
        int right = arr.length - 1;
        while (start < right) {
            swap(arr, start, right);
            start++;
            right--;
        }
    }

    @Test(dataProvider = "InputOutputData")
    void nextPermutation(int[] arr, int[] expectedOutput) {
        // Find index before decreasing order from right
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Find greatest number than index i from right
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            // 2 4 5 7 1 0
            swap(arr, i, j);
        }

        reverse(arr, i + 1); // 2 4 5 0 1 7

        Assert.assertEquals(arr, expectedOutput);
    }

    @DataProvider(name = "InputOutputData")
    public Object[][] inputOutputData() {
        return new Object[][] {
                { new int[] { 5, 1, 1 }, new int[] { 1, 1, 5 } },
                { new int[] { 2, 4, 1, 7, 5, 0 }, new int[] { 2, 4, 5, 0, 1, 7 } },
                { new int[] { 3, 2, 1 }, new int[] { 1, 2, 3 } },
                { new int[] { 3, 4, 2, 5, 1 }, new int[] { 3, 4, 5, 1, 2 } }
        };
    }

}