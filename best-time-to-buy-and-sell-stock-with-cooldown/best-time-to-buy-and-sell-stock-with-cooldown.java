class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, rest=0, hold = rest-prices[0];
        for(int price: prices){
            int pre_sold =sold;
            sold = hold + price;//updated sold
            hold = Math.max(hold, rest-price);
            rest = Math.max(rest,pre_sold);
        }
        return Math.max(rest, sold);
    }
}