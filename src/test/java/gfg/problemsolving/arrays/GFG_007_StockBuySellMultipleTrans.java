package gfg.problemsolving.arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GFG_007_StockBuySellMultipleTrans {

    @Test(dataProvider = "InputOutputData")
    public void main(int[] prices, int expectedMaxProfit) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        Assert.assertEquals(maxProfit, expectedMaxProfit);

    }

    @DataProvider(name = "InputOutputData")
    public Object[][] inputOutputData() {
        return new Object[][] {
                { new int[] { 100, 180, 260, 310, 40, 535, 695 }, 865 },
                { new int[] { 4, 2, 2, 2, 4 }, 2 }
        };
    }
}
