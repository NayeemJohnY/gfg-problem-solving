package gfg.problemsolving.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GFG_013_SmallestPositiveMissing {

    @Test(dataProvider = "InputOutputData")
    public void missingNumber(int[] arr, int expectedOutput) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0 && arr[i] <= arr.length && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i + 1 != arr[i]) {
                Assert.assertEquals(i + 1, expectedOutput);
                return;
            }
        }

        Assert.assertEquals(arr.length + 1, expectedOutput);
    }

    @DataProvider(name = "InputOutputData")
    public Object[][] inputOutputData() {
        return new Object[][] {
                { new int[] { 2, -3, 4, 1, 1, 7 }, 3 },
                { new int[] {5, 3, 2, 5, 1 }, 4 },
                { new int[] {-8, 0, -1, -4, -3 }, 1 },
                { new int[] { 1, 2, 3,4, 5 }, 6 },
                { new int[] { -3, 5, 1, -6 }, 2 }
        };
    }
}
