class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int min = nums[0], max=nums[0],res=nums[0];
        for(int i=1;i<nums.length;i++){
            int tmp = max;
            max = Math.max(Math.max(nums[i]*max, nums[i]*min),nums[i]);
            min = Math.min(Math.min(nums[i]*tmp, nums[i]*min),nums[i]);
            res = Math.max(max,res);
        }
        return res;
    }
}