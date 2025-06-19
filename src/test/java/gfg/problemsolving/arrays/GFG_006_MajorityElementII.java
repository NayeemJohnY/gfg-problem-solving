package gfg.problemsolving.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GFG_006_MajorityElementII {

    @Test(dataProvider = "InputOutputData")
    public void findMajority(int[] nums, List<Integer> expectedOutputList) {
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 0;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        List<Integer> list = new ArrayList<>();

        if (count1 > nums.length / 3) {
            list.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            list.add(candidate2);
        }

        Collections.sort(list);
        Assert.assertEquals(list, expectedOutputList);
    }

    @DataProvider(name =  "InputOutputData")
    public Object[][] inputOutputData() {
        return new Object[][] {
                { new int[] { 2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6 }, Arrays.asList(5, 6) },
                { new int[] { 1, 2, 3, 4, 5 }, new ArrayList<>()}
        };
    }

}
