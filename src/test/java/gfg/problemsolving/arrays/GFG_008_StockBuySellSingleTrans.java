package gfg.problemsolving.arrays;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GFG_008_StockBuySellSingleTrans {

    @Test(dataProvider = "InputOutputData")
    public void maxProfitBuyAndSellSingleTransaction(int[] prices, int expectedMaxProfit) {
        int maxProfit = 0, maxStockPrice = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            maxStockPrice = Math.max(maxStockPrice, prices[i]);
            maxProfit = Math.max(maxProfit, maxStockPrice - prices[i]);
        }
        Assert.assertEquals(maxProfit, expectedMaxProfit);
    }

    @DataProvider(name = "InputOutputData")
    public Object[][] inputOutputData() {
        return new Object[][] {
                { new int[] { 100, 180, 260, 310, 40, 535, 695 }, 655 },
                { new int[] { 7, 10, 1, 3, 6, 9, 2 }, 8 },
                { new int[] { 7, 6, 4, 3, 1 }, 0 },
                { new int[] { 1, 3, 6, 9, 11 }, 10 }
        };
    }
}
