class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.putIfAbsent(sorted, new ArrayList<String>());
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }
}