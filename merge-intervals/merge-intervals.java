class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        LinkedList<int[]> res = new LinkedList();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        for(int[] interval:intervals){
            if(res.isEmpty()||res.getLast()[1]<interval[0]){
                res.add(interval);
            }else{
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}