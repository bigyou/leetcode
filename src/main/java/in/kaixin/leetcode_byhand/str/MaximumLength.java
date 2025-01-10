package in.kaixin.leetcode_byhand.str;

import java.util.*;

public class MaximumLength {
    //    https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-i/?envType=daily-question&envId=2024-05-29
//    mid
    public int maximumLength(String s) {
        int ret = -1;
        Map<String, List<Integer>> positionList = new HashMap<>();
        for (int i = 0; i < s.length(); ) {
            String c = s.charAt(i) + "";
            List<Integer> list = positionList.get(c);
            if (list == null) {
                list = new LinkedList<>();
                positionList.put(c, list);
            }
            int j = i + 1;
            for (; j < s.length(); j++) {
                if (c.equals(s.charAt(j) + "")) {
                    continue;
                } else {
                    break;
                }
            }
            list.add(j - i);
            i = j;
        }
        for (String key : positionList.keySet()) {
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
            List<Integer> integers = positionList.get(key);
            for (Integer integer : integers) {
                q.add(integer--);
                q.add(integer--);
                q.add(integer--);
            }
            q.poll();
            q.poll();
            Integer v = q.poll();
            ret = Math.max(ret, v);
        }
        return ret <= 0 ? -1 : ret;
    }


    public static void main(String[] args) {
        MaximumLength l = new MaximumLength();
        System.out.println(l.maximumLength("acc"));
        System.out.println(l.maximumLength("aaaa"));
        System.out.println(l.maximumLength("abcdef"));
        System.out.println(l.maximumLength("abcaba"));
        System.out.println(l.maximumLength("abcccccdddd"));
        System.out.println(l.maximumLength("ereerrrererrrererre"));
        System.out.println(l.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"));
    }
}
