class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, prdt = 1;
        for(int i = 0;i<nums.length;i++){
            prdt *= nums[i];
            res = Math.max(res, prdt);
            if(nums[i]==0) prdt =1;
        }
        prdt=1;
        for(int j = nums.length-1;j>0;j--){
            prdt*= nums[j];
            res = Math.max(res, prdt);
            if(nums[j]==0) prdt =1;
        }
        return res;
    }
}