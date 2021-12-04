class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, hold = 0-prices[0];
        for(int price: prices){
            int pre_sold = sold;
            sold = Math.max(hold + price, sold);
            hold = Math.max(hold, pre_sold-price);
        }
        
        return sold;
    }
}