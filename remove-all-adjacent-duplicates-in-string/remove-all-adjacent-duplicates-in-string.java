class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack();
        for(char c : s.toCharArray()){
            if(stk.isEmpty()||stk.peek()!=c){
                stk.push(c);
            }else {
                stk.pop();
            }
            
        }
                StringBuilder stringBuilder = new StringBuilder();
        stk.stream().forEach(c->stringBuilder.append(String.valueOf(c)));
        return stringBuilder.toString();
    }
}