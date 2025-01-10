package in.kaixin.leetcode_byhand.numbers;


import java.util.Stack;

//https://leetcode.cn/problems/clear-digits/?envType=daily-question&envId=Invalid%20Date
//easy
public class ClearDigits {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        String res = stack.toString();
        res=res.replace("[","");
        res=res.replace("]","");
        res=res.replace(",","");
        return res;

    }

}
