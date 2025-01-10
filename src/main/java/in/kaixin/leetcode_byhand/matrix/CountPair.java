//package in.kaixin.leetcode_byhand.matrix;
//
//import java.util.*;
//
///**
// * @Author bigyou
// * @Create 2023/10/23 21:06
// */
//public class CountPair {
//    //https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/?envType=daily-question&envId=2023-10-21
//    //mid
//todo

//    public long countPairs(int n, int[][] edges) {
//        ArrayList<Set<Integer>> list = new ArrayList(n);
//        for (int i = 0; i < edges.length; i++) {
//            int a = edges[i][0];
//            int b = edges[i][1];
//            putV(list, a, b);
//            putV(list, b, a);
//        }
//        Set<Integer> allDiscoverIds = new HashSet<>();
//        List<Set<Integer>> groups = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            if (allDiscoverIds.contains(i)) {
//                continue;
//            }
//            Set<Integer> ids = new HashSet<>();
//            ids.add(i);
//
//
//
//
//        }
//
//
//    }
//
//    public void putV(ArrayList<Set<Integer>> list, int a, int b) {
//        Set<Integer> l = list.get(a);
//        if (l == null) {
//            l = new HashSet<>();
//            list.set(a, l);
//        }
//        l.add(b);
//    }
//}
