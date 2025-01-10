package in.kaixin.leetcode_byhand.other;

import java.util.*;
import java.util.stream.Collectors;

public class MaximizeWin {
    //    https://leetcode.cn/problems/maximize-win-from-two-segments/?envType=daily-question&envId=2024-09-10
//    mid
    public int maximizeWin(int[] prizePositions, int k) {
        int res = 0;
        int start = prizePositions[0];
        int end = prizePositions[prizePositions.length - 1];
        int offset = end - start + 1;
        if (2 * k >= offset) {
            return prizePositions.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prizePositions.length; i++) {
            Integer key = prizePositions[i];
            if (!map.containsKey(key)) {
                map.put(key, 0);
            }
            map.put(key, map.get(key) + 1);
        }
        List<MaxGift> gifts = caculateLeftMax(map, k);
        res = caculateRightMax(map, k, gifts);

        return res;
    }

    public List<MaxGift> caculateLeftMax(Map<Integer, Integer> map, int k) {
        List<MaxGift> maxGifts = new LinkedList<>();
        List<Integer> giftPositions = map.keySet().stream().sorted().collect(Collectors.toList());
        int premax = 0;
        for (int i = 0; i < giftPositions.size(); i++) {
            int max = 0;
            MaxGift gift = new MaxGift();
            gift.start = giftPositions.get(i);
            gift.end = giftPositions.get(i);
            if (!maxGifts.isEmpty()) {
                premax = maxGifts.get(maxGifts.size() - 1).max;
            }
            gift.max = premax;
            maxGifts.add(gift);
            for (int j = i; j >= 0; j--) {
                if (giftPositions.get(j) >= giftPositions.get(i) - k) {
                    max += map.get(giftPositions.get(j));
                    gift.max = Math.max(max, gift.max);
                    gift.start = giftPositions.get(j);
                } else {
                    break;
                }
            }
        }
        return maxGifts;
    }

    public Integer caculateRightMax(Map<Integer, Integer> map, int k, List<MaxGift> gifts) {
        List<MaxGift> maxGifts = new LinkedList<>();
        List<Integer> giftPositions = map.keySet().stream().sorted().collect(Collectors.toList());
        int premax = 0;
        int totalMax = 0;
        for (int i = giftPositions.size() - 1; i > 0; i--) {
            int max = 0;
            for (int j = i; j < giftPositions.size(); j++) {
                if (giftPositions.get(j) <= giftPositions.get(i) + k) {
                    max += map.get(giftPositions.get(j));
                    premax = Math.max(premax, max);
                    totalMax = Math.max(totalMax, gifts.get(i - 1).max + premax);
                } else {
                    break;
                }
            }
            System.out.println("position="+giftPositions.get(i)+"totalMax=" + totalMax + ",left=" + gifts.get(i - 1).max + ",rightMax=" + premax);

        }
        return totalMax;
    }
}

class MaxGift {
    Integer max;
    Integer start;
    Integer end;

}