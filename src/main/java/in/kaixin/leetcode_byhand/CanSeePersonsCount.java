package in.kaixin.leetcode_byhand;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class CanSeePersonsCount {
    //https://leetcode.cn/problems/number-of-visible-people-in-a-queue/?envType=daily-question&envId=2024-01-05
    // hard TODO
    public int[] canSeePersonsCount(int[] heights) {
        //生成一个全局的
        int[] res = new int[heights.length];
        Deque<CanSeeInfo> deq = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            if (!deq.isEmpty() && deq.getFirst().getIdx() == i) {
                deq.removeFirst();
            }
            if (deq.size() == 0) {
                generateAsc(deq, heights, i + 1, heights.length);
            } else {
                updateAsc(deq, heights, i + 1);
            }
            res[i] = deq.size();
        }
        return res;
    }

    public Deque<CanSeeInfo> generateAsc(Deque<CanSeeInfo> deq, int[] heights, int start, int end) {
        for (int i = start; i < end; i++) {
            if (deq.isEmpty()) {
                deq.addLast(new CanSeeInfo(i, heights[i]));
            } else {
                if (heights[i] > deq.getLast().getV()) {
                    deq.addLast(new CanSeeInfo(i, heights[i]));
                }
            }
        }
        return deq;
    }

    public Deque<CanSeeInfo> updateAsc(Deque<CanSeeInfo> deq, int[] heights, int start) {
        Deque<CanSeeInfo> newDeq = new ArrayDeque<>();
        for (int i = start; i < deq.getFirst().getIdx(); i++) {
            if (newDeq.isEmpty()) {
                deq.add(new CanSeeInfo(i, heights[i]));
            } else {
                if (heights[i] > deq.getLast().getV()) {
                    deq.add(new CanSeeInfo(i, heights[i]));
                }
            }
        }
        while (!newDeq.isEmpty()) {
            deq.addFirst(newDeq.removeLast());
        }
        return deq;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{10, 6, 8, 5, 11, 9};
        CanSeePersonsCount c = new CanSeePersonsCount();
        int[] v = c.canSeePersonsCount(heights);
        System.out.println(JSON.toJSONString(v));
    }
}

class CanSeeInfo {
    int idx;
    int v;

    public CanSeeInfo(int idx, int v) {
        this.idx = idx;
        this.v = v;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
