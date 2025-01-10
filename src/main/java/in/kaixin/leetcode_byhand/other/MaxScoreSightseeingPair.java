package in.kaixin.leetcode_byhand.other;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.PriorityQueue;

public class MaxScoreSightseeingPair {
    //    https://leetcode.cn/problems/best-sightseeing-pair/?envType=daily-question&envId=2024-09-23
//    mid
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int[] left = new int[values.length];
        PriorityQueue<ValueSubPosition> p = new PriorityQueue<>((a, b) -> b.v - a.v);
        for (int i = 0; i < values.length; i++) {
            left[i] = values[i] + i;
            p.add(new ValueSubPosition(values[i] - i, i));

        }
        for (int i = 0; i < left.length - 1; i++) {
            while (!p.isEmpty() && p.peek().position <= i) {
                p.remove();
            }
            res = Math.max(res, left[i] + p.peek().v);
        }
        return res;

    }
}

class ValueSubPosition {
    int v;
    int position;

    ValueSubPosition(int v, int position) {
        this.v = v;
        this.position = position;
    }
}