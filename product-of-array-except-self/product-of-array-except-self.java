class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for(int i=0,tmp=1;i<len;i++){
            res[i]=tmp;
            tmp*=nums[i];
        }
        for(int i=len-1,tmp=1;i>=0;i--){
            res[i]*=tmp;
            tmp*=nums[i];
        }
        return res;
    }
}