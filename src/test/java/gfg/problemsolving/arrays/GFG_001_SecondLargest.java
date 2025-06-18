package gfg.problemsolving.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GFG_001_SecondLargest {

    @Test(dataProvider = "arrayData")
    public void getSecondLargest(int[] arr, int expectedOutput) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num != max && num > secondMax) {
                secondMax = num;
            }
        }
        secondMax = secondMax == Integer.MIN_VALUE ? -1 : secondMax;
        System.out.println(secondMax);
        Assert.assertEquals(secondMax, expectedOutput);
    }

    @DataProvider(name = "arrayData")
    public Object[][] arrayData() {
        return new Object[][] {
                { new int[] { 10, 10, 5 }, 5 },
                { new int[] { 12, 35, 1, 10, 34, 1 }, 34 },
                { new int[] { 10, 10, 10 }, -1 },
        };
    }
}
