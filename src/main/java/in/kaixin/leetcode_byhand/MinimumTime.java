package in.kaixin.leetcode_byhand;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumTime {
    //    https://leetcode.cn/problems/minimum-time-to-make-array-sum-at-most-x/?envType=daily-question&envId=2024-01-19
//    hard
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int sum = 0;
        int sum2 = 0;


        for (int i = 0; i < nums1.size(); i++) {
            sum += nums1.get(i);
            sum2 += nums2.get(i);
        }
        int v = sum;
        for (int i = 0; i < nums1.size(); i++) {
            int idx = i % nums1.size();
            v += sum2 - (idx + 1) * nums2.get(idx) - nums1.get(idx);
            if (v <= x) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumTime m = new MinimumTime();
        int v = m.minimumTime(Arrays.asList(4, 4, 9, 10), Arrays.asList(4, 4, 1, 3), 16);
        System.out.println(v);


    }
}
