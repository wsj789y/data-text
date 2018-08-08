package com.leetCode;


import sun.nio.cs.ext.ISCII91;

import java.util.Stack;

public class Solution {

    //栈    匹配括号
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(' )
                stack.push(c);
            else{
                if (stack.isEmpty())
                    return  false;
                char top = stack.pop();
                if (c == '}' && top != '{')
                    return false;
                if (c == ']' && top != '[')
                    return false;
                if (c == ')' && top != '(')
                    return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{{{{})"));
        System.out.println(new Solution().isValid("{}[]()"));
    }
}
