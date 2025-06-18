package gfg.problemsolving.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GFG_003_ReverseAnArray {

    @Test(dataProvider = "InputOutputData")
    public void reverseArray(int arr[], int[] expectedOutput) {
        // code here
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
        Assert.assertEquals(arr, expectedOutput);
    }

    @DataProvider(name = "InputOutputData")
    public Object[][] inputOutputData() {
        return new Object[][] {
                { new int[] { 1, 4, 3, 2, 6, 5 }, new int[] { 5, 6, 2, 3, 4, 1 } },
                { new int[] { 4, 5, 2 }, new int[] { 2, 5, 4 } },
                { new int[] { 1 }, new int[] { 1 } }
        };
    }

}
