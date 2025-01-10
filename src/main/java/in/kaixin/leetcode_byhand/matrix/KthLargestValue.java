package in.kaixin.leetcode_byhand.matrix;

import java.util.PriorityQueue;

public class KthLargestValue {
//    https://leetcode.cn/problems/find-kth-largest-xor-coordinate-value/?envType=daily-question&envId=Invalid%20Date

    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);
        Integer lineXor = null;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    lineXor = matrix[i][0];
                }
                int v = matrix[i][j];
                if (j > 0) {
                    lineXor = matrix[i][j] ^ lineXor;
                    v = lineXor;
                }
                if (i > 0) {
                    v = matrix[i - 1][j] ^ v;
                }

                matrix[i][j] = v;
                p.add(v);
            }
        }
        Integer ret = null;
        for (int i = 1; i <= k; i++) {
            ret = p.poll();
        }
        return ret;


    }

    public static void main(String[] args) {
        KthLargestValue k = new KthLargestValue();
        int v = k.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3);
        System.out.println(v);
    }

}
