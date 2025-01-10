package in.kaixin.leetcode_byhand.other;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxConsecutive {
    //    https://leetcode.cn/problems/maximum-consecutive-floors-without-special-floors/?envType=daily-question&envId=2025-01-09
//    mid
    public int maxConsecutive(int bottom, int top, int[] special) {
        int max = 0;
        if (special.length == 0) {
            return top - bottom + 1;
        }
        Arrays.sort(special);
        max = Math.max(max, special[0] - bottom);
        max = Math.max(max, top - special[special.length - 1]);
        for (int i = 1; i < special.length; i++) {
            max = Math.max(max, special[i] - special[i - 1] - 1);
        }
        return max;
    }
}
