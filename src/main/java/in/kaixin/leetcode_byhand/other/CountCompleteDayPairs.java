package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.Map;

public class CountCompleteDayPairs {
    //    https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-ii/?envType=daily-question&envId=Invalid%20Date
//    mid
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Long> hourCntMap = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            int h = hours[i] % 24;
            hourCntMap.put(h, hourCntMap.getOrDefault(h, 0l) + 1);
        }
        int res = 0;
        if (hourCntMap.getOrDefault(0, 0l) > 1) {
            res += hourCntMap.get(0) * (hourCntMap.get(0) - 1) / 2;
        }
        if (hourCntMap.getOrDefault(12, 0l) > 1) {
            res += hourCntMap.get(12) * (hourCntMap.get(12) - 1) / 2;
        }

        for (int i = 1; i < 12; i++) {
            res += hourCntMap.getOrDefault(i, 0l) * hourCntMap.getOrDefault(24 - i, 0l);
        }
        return res;


    }
}
