class Solution {
    public int minSteps(String s, String t) {
        if(s.length()!=t.length()) return -1;
        int[] freq=new int[26];
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
		/*
count the negative frequency because if t string contains the character of s string then
 the frequency become 0 if not the frequency <0 therefore we have to calculate the character which is not present in s string
note:- u can count freq[i]>0  or freq[i]<0 both are same
*/
        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]<0) count+=freq[i];  
        }
        return count*(-1);
    }
}