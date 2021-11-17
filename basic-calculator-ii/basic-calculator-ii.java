class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int operand = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char operator = '+';// treat all the operator as +, but assign signs to numbers
        
        for(int i=0;i<s.length();i++) {// No () included in expression, traverse from beginning 
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){// if the char is digit, evaluate it until we see other operator
                operand =  (cur-'0') + operand * 10;
            }
            if(!Character.isDigit(cur)&&!Character.isWhitespace(cur)||i==s.length()-1){//when the ch is the last, we need to make sure * and / operations are evaluated and saved on stack
                if(operator == '-'){
                    stack.push(0-operand); 
                }
                else if(operator == '+'){
                    stack.push(operand);
                }
                else if(operator == '*'){
                    stack.push(stack.pop()*operand);
                }
                else if(operator == '/'){
                    stack.push(stack.pop()/operand);
                }
                operator = cur;
                operand = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}