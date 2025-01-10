package in.kaixin.leetcode_byhand.numbers;

public class HammingWeight {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n > 0) {
            int tmp = n / 2;
            cnt += n - tmp*2;
            n = tmp;
        }
        return cnt;


    }
}
