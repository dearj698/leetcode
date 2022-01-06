class Solution {
    public int countBinarySubstrings(String s) {
        int[] fre = new int[s.length()];
        int t=0;
        fre[0]=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)!=s.charAt(i)){
                fre[++t]=1;
            }
            else{
                fre[t]++;
            }
        }
        int res =0;
        for(int i=1;i<fre.length;i++){
            res+=Math.min(fre[i-1],fre[i]);
        }
        return res;
    }
}