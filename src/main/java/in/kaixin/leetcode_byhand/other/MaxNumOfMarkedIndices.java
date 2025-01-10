package in.kaixin.leetcode_byhand.other;

import java.util.Arrays;

public class MaxNumOfMarkedIndices {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int mid = (nums.length - 1) / 2 + 1;
        int right = mid;
        int res=0;
        while (left < mid && right < nums.length) {
            if(2*nums[left]<=nums[right]){
                res++;
                left++;
                right++;
            }else {
                right++;
            }
        }
        return res;
    }
}
