package in.kaixin.leetcode_byhand.other;

public class MinimumSteps {
    //    https://leetcode.cn/problems/separate-black-and-white-balls/?envType=daily-question&envId=2024-06-06
    //mid
    public long minimumSteps(String s) {
        int[] arr = new int[s.length()];
        int cursor = 0;
        int size = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                arr[i] = i;
                arr[cursor] = i;
                cursor++;
            }
        }
        long step = 0;
        for (int i = cursor - 1; i >= 0; i--) {
            step += size - 1 - (cursor - 1 - i) - arr[i];
        }
        return step;
    }
}
