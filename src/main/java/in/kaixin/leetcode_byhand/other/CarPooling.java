//package in.kaixin.leetcode_byhand.other;
//
//import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.PriorityQueue;
//
///**
// * @Author bigyou
// * @Create 2023/12/2 00:33
// */
//public class CarPooling {
//    //    https://leetcode.cn/problems/car-pooling/description/?envType=daily-question&envId=2023-12-02
////    mid
//    public boolean carPooling(int[][] trips, int capacity) {
//        PriorityQueue<Info> priorityQueue = new PriorityQueue<>((a, b) -> (a.off - b.off));
//        int cntOnCar = 0;
//        List<Info> list = new LinkedList<>();
//
//        for (int i = 0; i < trips.length; i++) {
//            Info info = new Info();
//            info.setCnt(trips[i][0]);
//            info.setUp(trips[i][1]);
//            info.setOff(trips[i][2]);
//        }
//        list.sort(new Comparator<Info>() {
//            @Override
//            public int compare(Info o1, Info o2) {
//                if (o1.getUp() > o1.getUp()) {
//                    return 1;
//                } else if (o1.getUp() == o1.getUp()) {
//                    return o1.getOff() - o2.off > 0 ? 1 : -1;
//                } else {
//                    return -1;
//                }
//            }
//        });
//        int cursor = 0;
//        int j = 0;
//        for (; j < list.size(); ) {
//            Info info = list.get(j);
//            while()
//        }
//
//
//    }
//
//
//}
//
//
//class Info {
//    int cnt;
//    int off;
//    int up;
//
//    public int getCnt() {
//        return cnt;
//    }
//
//    public void setCnt(int cnt) {
//        this.cnt = cnt;
//    }
//
//    public int getOff() {
//        return off;
//    }
//
//    public void setOff(int off) {
//        this.off = off;
//    }
//
//    public int getUp() {
//        return up;
//    }
//
//    public void setUp(int up) {
//        this.up = up;
//    }
//}
