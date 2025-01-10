package in.kaixin.leetcode_byhand.numbers;

import java.util.HashSet;
import java.util.Set;

public class FindMissingAndRepeatedValues {
//    easy
//
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ret = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length * grid.length; i++) {
            set.add(i + 1);
        }
        Integer duplicateValue = null;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (!set.contains(grid[i][j])) {
                    duplicateValue = grid[i][j];
                } else {
                    set.remove(grid[i][j]);
                }
            }

        }
        Integer notExist = set.iterator().next();
        ret[0] = duplicateValue;
        ret[1] = notExist;
        return ret;

    }
}
