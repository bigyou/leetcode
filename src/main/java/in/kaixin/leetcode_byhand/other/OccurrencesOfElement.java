package in.kaixin.leetcode_byhand.other;

import java.util.*;

public class OccurrencesOfElement {
    //    https://leetcode.cn/problems/find-occurrences-of-an-element-in-an-array/?envType=daily-question&envId=2024-12-27
//    mid
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] res = new int[queries.length];
        int cnt = 0;
        for (int i = 0; i < queries.length; i++) {
            res[i] = -1;
            if (queries[i] <= nums.length) {
                List<Integer> list = map.getOrDefault(queries[i], new LinkedList<>());
                list.add(i);
                map.put(queries[i], list);
                cnt++;
            }
        }
        int xcnt = 0;
        for (int i = 0; i < nums.length && cnt >= 0; i++) {
            if (nums[i] == x) {
                xcnt++;
                if (map.containsKey(xcnt)) {
                    for (Integer idx : map.get(xcnt)) {
                        res[idx] = i;
                        cnt--;
                    }

                }
            }


        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 3, 1, 7};
        int[] queries = new int[]{1, 3, 2, 4};
//        int[] num = new int[]{1,3,2,2,3,3,1,3,1};
//        int[] queries = new int[]{5,6,1,5,6,4,1,5};
        OccurrencesOfElement o = new OccurrencesOfElement();
        int[] res = o.occurrencesOfElement(num, queries, 3);

    }
}
