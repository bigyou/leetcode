package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author bigyou
 * @Create 2023/11/2 18:02
 */
public class MaximumInvitations {
    //    https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/?envType=daily-question&envId=2023-11-02
//    hard
    int max = 0;

    public int maximumInvitations(int[] favorite) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < favorite.length; i++) {
            List<Integer> list = map.get(favorite[i]);
            list = list == null ? new LinkedList<>() : list;
            map.put(favorite[i], list);
            list.add(i);
        }
        int[] tableArr = new int[favorite.length];
        if (map.size() == 1) {
            return favorite.length > 2 ? 3 : favorite.length;
        }
        for (int i = 0; i < favorite.length; i++) {
            if (i >= favorite.length - max) {
                break;
            }
            arrangeOrder(map, i, i, tableArr, 0);
        }
        return max;


    }

    /**
     * @param start       开始的下标
     * @param map         喜欢的人员列表
     * @param idx         当前第i个人给他安排顺序
     * @param tableArr    当前已经安排的顺序
     * @param tableCursor 当前表格已经安排的人的下标
     * @return
     */
    public void arrangeOrder(Map<Integer, List<Integer>> map, int start, int idx, int[] tableArr, int tableCursor) {
        tableArr[tableCursor] = idx;
        List<Integer> list = map.get(idx);
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.contains(tableArr[0])) {
            max = Math.max(max, tableCursor + 1);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= start) {
                continue;
            }
            arrangeOrder(map, start, list.get(i), tableArr, tableCursor + 1);
        }
    }

    public static void main(String[] args) {
        MaximumInvitations m = new MaximumInvitations();
        m.maximumInvitations(new int[]{2, 2, 1, 2});
        System.out.println(m.max);
    }
}
