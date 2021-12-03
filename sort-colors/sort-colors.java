class Solution {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length<=1) return;
        int i=0, j=0, k = nums.length-1;
        while(j<=k){
            if(nums[j]==0){
                swap(nums,i++,j++);
            }else if(nums[j]==1){
                j++;
            }else{
                swap(nums,j,k--);
            }
        }
        
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}