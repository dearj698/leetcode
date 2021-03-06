class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int l =0, r=nums.length-1;
        if(nums[r]>nums[0]) return nums[0];
        
        int res = Integer.MAX_VALUE;
        
        while(l<=r){
            int mid = l+ (r-l)/2;
            
            if(nums[mid+1]<nums[mid]){
                return nums[mid+1];
            }
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            if(nums[mid]>nums[0]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
}