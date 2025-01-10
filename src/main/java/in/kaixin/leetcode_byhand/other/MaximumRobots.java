package in.kaixin.leetcode_byhand.other;

public class MaximumRobots {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int preMax = 0;
        int n = 1;//
        long preSum = 0;
        while (budget > 0) {
            int deltaCost = 0;
            if (chargeTimes[n - 1] > preMax)    
            budget = budget - deltaCost - (preSum + n * runningCosts[n - 1]);
            preSum += runningCosts[n - 1];
            n++;
        }
        if(budget<0){
            n-=2;
        }
        return n;
    }

    public static void main(String[] args) {
        MaximumRobots r= new MaximumRobots();
        int k=r.maximumRobots(new int[]{8,76,74,9,75,71,71,42,15,58,88,38,56,59,10,11},new int[]{1,92,41,63,22,37,37,8,68,97,39,59,45,50,29,37},412);
        System.out.println(k);
    }
}
