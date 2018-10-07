package test;

import java.util.Stack;

public class StackTest {
//    public static void main(String[] args) {
//
//        String exp = "a+b*(c^d-e)^(f+g*h)-i";
//        String expC = convertToPrefix(exp);
//        System.out.println("Converted Expression: "+ expC);
//
//    }

    public static String convertToPrefix(String exp){
        Stack<Character> s = new Stack<Character>();
        String result = "" ;
        Character c;
        for(int i = 0; i < exp.length(); i++){
            c = exp.charAt(i);
            if (isOperand(c)){
                result = result + c;
            }else if(isOperator(c)){
                while (!s.empty() && getOperatorPrecedence(c) <= getOperatorPrecedence(s.peek())){
                            result = result + s.pop();
                        }
                        s.push(c);
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')'){
                while (!s.empty() && s.peek() != '(') {
                    System.out.println(s.peek());
                    result = result + s.pop();
                }
                s.pop();
            } else {
                System.out.println("invalid character" + c);
            }
        }
        while (!s.empty()) {
            result = result + s.pop();
        }
        return result;
    }

    public static int getOperatorPrecedence(char ch){
        if (ch == '+' || ch == '-'){
            return 1;
        }else if(ch == '*' || ch == '/'){
            return 2;
        }else if(ch == '^'){
            return 3;
        }else{
            return 0;
        }
    }

    public static boolean isOperator(char ch){
        if (ch == '+' || ch ==  '-' || ch == '*' || ch == '/' || ch == '^'){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isOperand(char ch){
        if (!isOperator(ch) || ch == '(' || ch == ')'){
            return true;
        }else{
            return false;
        }
    }

    public static Stack removeByInt(Stack s, int i){
        Stack sTemp = new Stack();
        while(!s.empty()){
            if (i == s.peek().hashCode()){
                s.pop();
            }else{
                sTemp.push(s.pop());
            }
        }
        while(!sTemp.empty()) {
            s.push(sTemp.pop());
        }
        return s;
    }

    public static void printStack(Stack s){
        Stack sTemp = (Stack) s.clone();
        String l = "";
        while(!sTemp.empty()){
            if(l == ""){
                l = sTemp.pop().toString();
            }else
                l = l + ',' + sTemp.pop().toString();
        }

        System.out.println(l);
    }
}