package gfg.problemsolving.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GFG_002_PushZerosToEnd {
    
    @Test(dataProvider = "arrayData")
    public void pushZerosToEnd(int[] arr, int[] expectedOutput) {
        int index = 0;
        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num;
            }
        }
        while (index < arr.length) {
            arr[index++] = 0;
        }
        Assert.assertEquals(arr, expectedOutput);
    }

    @DataProvider(name = "arrayData")
    public Object[][] arrayData() {
        return new Object[][] {
                { new int[] { 1, 2, 0, 4, 3, 0, 5, 0 }, new int[] { 1, 2, 4, 3, 5, 0, 0, 0 } },
                { new int[] { 10, 20, 30 }, new int[] { 10, 20, 30 } },
                { new int[] { 0, 0 }, new int[] { 0, 0 } }
        };
    }
}
