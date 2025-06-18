package gfg.problemsolving.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GFG_004_RotateArrayLeftByK {

    public void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    @Test(dataProvider = "InputOutputData")
    public void rotateArrayUsingReverse(int[] arr, int d, int[] expectedOutput) {
        d = d % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, arr.length - d - 1);
        reverse(arr, arr.length - d, arr.length - 1);
        Assert.assertEquals(arr, expectedOutput);
    }

    // 1, 2, 3, 4, 5
    // 2 3 4 5 1 temp the first index put to last
    // 3 4 5 1 2
    @Test(dataProvider = "InputOutputData")
    public void rotateArrayUsingNestedForLoop(int[] arr, int d, int[] expectedOutput) {
        d = d % arr.length;
        for (int i = 0; i < d; i++) {
            int temp = arr[0];
            for (int j = 1; j < arr.length; j++) {
                arr[j - 1] = arr[j];
            }
            arr[arr.length - 1] = temp;
        }
        Assert.assertEquals(arr, expectedOutput);
    }

    @DataProvider(name = "InputOutputData")
    public Object[][] testInputData() {
        return new Object[][] {
                { new int[] { 1, 2, 3, 4, 5 }, 2, new int[] { 3, 4, 5, 1, 2 } },
                { new int[] { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 }, 3,
                        new int[] { 8, 10, 12, 14, 16, 18, 20, 2, 4, 6 } },
                { new int[] { 7, 3, 9, 1 }, 9, new int[] { 3, 9, 1, 7 } }
        };
    }
}
