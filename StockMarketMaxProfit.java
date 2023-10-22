public class StockMarketMaxProfit {
    public static void main(String[] args) {
        int kek[] = {1, 2, 3, 4, 5, 6};
        System.out.println(maxProfit(kek));
    }

    public static int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int minPrice=prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            else{
                int profit=prices[i]- minPrice;
                profit=Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }
}
