package in.kaixin.leetcode_byhand.other;

import java.util.HashSet;
import java.util.Set;

public class SubstringPresent {
    //    https://leetcode.cn/problems/existence-of-a-substring-in-a-string-and-its-reverse/?envType=daily-question&envId=2024-12-26
//    mid
    public boolean isSubstringPresent(String s) {
        boolean find = false;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                find = true;
                break;
            }
            String str = s.charAt(i) + "" + s.charAt(i + 1);
            String reverseStr = "" + s.charAt(i + 1) + s.charAt(i);
            if (set.contains(str)) {
                find = true;
                break;
            } else {
                set.add(reverseStr);
            }
        }
        return find;
    }

    public static void main(String[] args) {
        SubstringPresent sp = new SubstringPresent();
        boolean res = sp.isSubstringPresent("abcba");
        System.out.print(res);
    }
}
