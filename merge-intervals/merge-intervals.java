class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Deque<int[]> stack = new ArrayDeque();
        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));
        
        for(int[] interval: intervals){
            if(stack.isEmpty()||notOverlap(stack.peek(), interval)){
                stack.push(interval);
            }else{
                // peek: [1,3] interval: [2,6] res: [1,6]
                // peek: [1,4] interval: [2,3] res: [1,4]
                if(stack.peek()[1]<=interval[1]){
                    stack.push(new int[]{stack.pop()[0], interval[1]});
                }else{
                    continue;
                }
            }
        }
        int[][] res = new int[stack.size()][2];
        return stack.toArray(res);
    }
    
    private boolean notOverlap(int[] a, int[] b){
        if(a[0]<b[0]&&a[1]<b[0]){
            return true;
        }
        return false;
    }
}