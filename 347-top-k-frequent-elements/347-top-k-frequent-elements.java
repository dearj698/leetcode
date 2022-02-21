class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> freq = new HashMap();
        for(int num: nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
        (a,b)->freq.get(a)-freq.get(b)
        );
        for (int n: freq.keySet()) {
          heap.add(n);
          if (heap.size() > k) heap.poll();    
        }

        // 3. build an output array
        // O(k log k) time
        for(int i = k - 1; i >= 0; --i) {
            res[i] = heap.poll();
        }
        return res;
    }
}