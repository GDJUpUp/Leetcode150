package ArrayAndString;

public class N121_BestTimeToTradeStocks {
    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<=minPrice){
                minPrice = prices[i];
            }else {
                int temp = prices[i]-minPrice;
                if (temp>profit){
                    profit = temp;
                }
            }
        }
        return profit;
    }
}
