class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,count=0;
        HashSet<Character> set = new HashSet();
        while(i<s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                count = (count<set.size())?set.size():count;
                i++;
            }
            else{
                set.remove(s.charAt(j++));
            }
        }
        return count;
    }
}