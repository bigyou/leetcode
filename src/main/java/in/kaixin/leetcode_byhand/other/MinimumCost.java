package in.kaixin.leetcode_byhand.other;

public class MinimumCost {
    //    https://leetcode.cn/problems/minimum-cost-for-cutting-cake-i/?envType=daily-question&envId=2024-12-25
//    mid
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int cnt = 0;
        if (m == 1 && n == 1) {
            return cnt;
        }
        for (int i = 0; i < horizontalCut.length; i++) {
            cnt += horizontalCut[i];
        }
        for (int i = 0; i < verticalCut.length; i++) {
            cnt += verticalCut[i];
        }
        if (m == 1 & n > 1 || n == 1 && m > 1) {
            return cnt;
        }
        for (int i = 0; i < horizontalCut.length; i++) {
            for (int j = 0; j < verticalCut.length; j++) {
                cnt += Math.min(horizontalCut[i], verticalCut[j]);
            }
        }
        return cnt;
    }

}
