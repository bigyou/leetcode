package in.kaixin.leetcode_byhand.other;

import com.alibaba.fastjson.JSON;

public class MissingRolls {
//    https://leetcode.cn/problems/find-missing-observations/description/?envType=daily-question&envId=2024-05-27
    //mid
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0;
        for(int i=0;i<rolls.length;i++){
            sum+=rolls[i];
        }
        int totalcnt= rolls.length+n;
        int totalScore = totalcnt*mean;
        int diff= sum+n*6-totalScore;
        int [] ret= new int[n];
        for(int i=0;i<n;i++){
            ret[i]=6;
        }
        int cursor=0;
        if(diff<0 || diff>5*n){
            return new int[]{};
        }
        while(diff>0&&cursor<n){
            if(diff<6){
                ret[cursor]-=diff;
                diff=0;
            }else {
                ret[cursor]-=5;
                diff-=5;
                cursor++;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        MissingRolls r = new MissingRolls();
        int[] ret = r.missingRolls(new int[]{3, 2, 4, 3}, 4, 2);
        System.out.println(JSON.toJSONString(ret));
          ret = r.missingRolls(new int[]{1,5,6}, 3,4);
        System.out.println(JSON.toJSONString(ret));

        ret = r.missingRolls(new int[]{1,2,3,4}, 6,4);
        System.out.println(JSON.toJSONString(ret));
        ret = r.missingRolls(new int[]{1}, 3,1);
        System.out.println(JSON.toJSONString(ret));

        ret = r.missingRolls(new int[]{6,3,4,3,5,3}, 1,6);
        System.out.println(JSON.toJSONString(ret));
    }
}
