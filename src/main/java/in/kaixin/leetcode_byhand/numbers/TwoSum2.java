package in.kaixin.leetcode_byhand.numbers;

import java.util.Arrays;

public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {

        int[] temp= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i]=nums[i];
        }
        Arrays.sort(temp);
        int left=0;int right=nums.length-1;

        while(left<right){
            int temsum =temp[left]+temp[right];
            if(temsum<target){
                left++;
            }else if(temsum>target){
                right--;
            }else {
                break;
            }
        }
        int leftNum=-1;
        int rightNum=-1;
        for(int i=0;i<nums.length;i++){
           if(leftNum==-1&&nums[i]==temp[left]){
               leftNum=i;
           }
           if(rightNum==-1&&leftNum!=i&&nums[i]==temp[right]){
               rightNum=i;
           }
           if(leftNum!=-1&&rightNum!=-1){
               break;
           }
        }
        return new int[]{leftNum,rightNum};
    }
}
