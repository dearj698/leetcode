class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        for(char c : s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else{
                    if(!stack.isEmpty()
                       &&((stack.peek()=='('&&c==')')
                       ||(stack.peek()=='{'&&c=='}')
                       ||(stack.peek()=='['&&c==']'))
                      ){
                        stack.pop();
                    }
                    else return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}