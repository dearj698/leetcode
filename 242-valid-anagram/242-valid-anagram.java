class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap();
        for(char letter: s.toCharArray()){
            map.put(letter, map.getOrDefault(letter,0)+1);
        }
        
        for(char letter: t.toCharArray()){
            map.put(letter,map.getOrDefault(letter,0)-1);
        }
                for (Map.Entry<Character,Integer> pair : map.entrySet()) {
            if(pair.getValue()!=0) return false;
        }
        return true;
    }
}