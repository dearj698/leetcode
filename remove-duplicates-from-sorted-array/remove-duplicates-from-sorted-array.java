class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j=0;
        while(j<nums.length){
            if(j==0||nums[j]!=nums[i-1]){
                swap(nums, i++,j);
            }
            j++;
        }
        return i;
    }
    
    private void swap(int[] n, int i, int j){
        int tmp = n[i];
        n[i]=n[j];
        n[j]=tmp;
    }
}