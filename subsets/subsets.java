class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subAry(nums, 0 , new ArrayList());
        return res;
    }
    
    private void subAry(int[] nums, int first , List<Integer> cur){
        res.add(new ArrayList(cur));
        for(int i = first ; i< nums.length;i++){
            cur.add(nums[i]);
            subAry(nums, i+1, cur);
            cur.remove(cur.size()-1);
        }
    }
}