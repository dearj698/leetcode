class Solution {

    public int trap(int[] height) {
        int i = 0, j = height.length-1;
        int res = 0;
        int l_max=0, r_max=0;
        while(i<j){
            if(height[i]<height[j]){
                if(l_max<height[i]){
                    l_max = height[i];
                }else{
                    res+=l_max-height[i];
                }
                i++;
            }else{
                if(r_max<height[j]){
                    r_max = height[j];
                }else{
                    res+=r_max-height[j];
                }
                j--;
            }
        }
        return res;
    }
}