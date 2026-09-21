class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = Integer.MIN_VALUE;
        for(int price:prices) {
            minPrice = Math.min(minPrice,price);
            profit=Math.max(profit,price-minPrice);
        }
        return profit;
        
    }
}