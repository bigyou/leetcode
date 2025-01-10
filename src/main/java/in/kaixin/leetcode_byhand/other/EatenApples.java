package in.kaixin.leetcode_byhand.other;

import javafx.scene.layout.Priority;

import java.util.PriorityQueue;

public class EatenApples {
    //    https://leetcode.cn/problems/maximum-number-of-eaten-apples/?envType=daily-question&envId=2024-12-24
//    mid
    PriorityQueue<AppleInfo> priorityQueue = new PriorityQueue<AppleInfo>((a, b) -> {
        return a.idx - b.idx;
    });

    public int eatenApples(int[] apples, int[] days) {
        int eatenAppleCnt = 0;

        for (int i = 0; i < apples.length; i++) {
            if (apples[i] != 0) {
                priorityQueue.add(new AppleInfo(i + days[i]-1, apples[i]));
            }
            eatenAppleCnt += getOneApple(i);
        }
        int idx = apples.length;
        while (!priorityQueue.isEmpty()) {
            eatenAppleCnt += getOneApple(idx++);
        }
        return eatenAppleCnt;


    }

    public int getOneApple(int idx) {
        int apple = 0;
        while (priorityQueue.peek() != null) {
            AppleInfo appleInfo = priorityQueue.peek();
            if (appleInfo.idx < idx || priorityQueue.peek().cnt == 0) {
                priorityQueue.poll();
            } else {
                priorityQueue.peek().setCnt(priorityQueue.peek().cnt - 1);
                apple = 1;
                break;
            }
        }
        return apple;
    }

    public static void main(String[] args) {
        int[] apples = new int[]{1, 2, 3, 5, 2};
        int[] days = new int[]{3, 2, 1, 4, 2};
        EatenApples ep = new EatenApples();
        ep.eatenApples(apples, days);
    }
}

class AppleInfo {
    int idx;
    int cnt;

    public AppleInfo(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
