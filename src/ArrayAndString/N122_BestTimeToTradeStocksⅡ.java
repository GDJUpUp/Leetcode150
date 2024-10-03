package ArrayAndString;

public class N122_BestTimeToTradeStocksⅡ {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;
        int sellPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            if ((prices[i]<buyPrice&&!(sellPrice>buyPrice))||i==0){
                buyPrice = prices[i];
                sellPrice = prices[i];
            }else {
                if (prices[i]>sellPrice){
                    sellPrice = prices[i];
                }else {
                    profit+=sellPrice-buyPrice;
                    buyPrice = prices[i];
                    sellPrice = prices[i];

                }
            }
        }
        profit+=sellPrice-buyPrice;
        return profit;
    }
}
