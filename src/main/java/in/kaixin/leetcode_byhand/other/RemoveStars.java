package in.kaixin.leetcode_byhand.other;

import java.util.Stack;

public class RemoveStars {
    public String removeStars(String s) {
//        https://leetcode.cn/problems/removing-stars-from-a-string/description/?envType=daily-question&envId=2024-09-14
//        mid
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (!stack.isEmpty() && stack.peek() != '*') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}
