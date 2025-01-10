package in.kaixin.leetcode_byhand.other;

public class SemiOrderedPermutation {
    public int semiOrderedPermutation(int[] nums) {
        int oneIndex=-1;
        int endIndex= -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                oneIndex=i;
            }else if(nums[i]== nums.length){
                endIndex=i;
            }
        }
        int res= oneIndex+nums.length-endIndex;
        res= oneIndex>endIndex?res-1:res;
        return res;

    }
}
