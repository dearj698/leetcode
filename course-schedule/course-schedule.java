class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] neigh = new LinkedList[numCourses];// how many courses depend on cur course
        Queue<Integer> queue = new LinkedList<>();// the courses that you can take(means that you've taken all the pre courses)
        int[] indegree = new int[numCourses];//  how many pre courses does cur course have
        int count = 0;
        for (int i = 0; i < numCourses; i++) neigh[i] = new LinkedList<>();
        for (int[] pair : prerequisites) {
            neigh[pair[1]].add(pair[0]);
            indegree[pair[0]]++;
        }
        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0) {
                queue.offer(i); 
                count++;
            }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int adj : neigh[course])
                if (--indegree[adj] == 0) {
                    queue.offer(adj);
                    count++;
                }
        }
        return count == numCourses;        
    }
}