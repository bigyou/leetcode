package in.kaixin.leetcode_byhand;

import java.util.Arrays;

/**
 * @Author bigyou
 * @Create 2023/10/23 19:50
 */
public class MaxSatisfaction {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum=0;
        int res=0;
        for(int i= satisfaction.length-1;i>=0;i--){
            int v= satisfaction[i];
            if(sum+v<0){
                break;
            }
            sum=sum+v;
            res+=sum;
        }
        return res;
    }
}
