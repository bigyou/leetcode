package in.kaixin.leetcode_byhand;

public class CanArrangeByK {
    public boolean canArrange(int[] arr, int k) {
        int[] modArr = new int[k];
        for (int i : arr) {
            Integer mod = i % k;
            mod = mod < 0 ? mod + k : mod;
            modArr[mod] = modArr[mod] + 1;
        }
        if (modArr[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (modArr[i] != modArr[k - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanArrangeByK canArrangeByK = new CanArrangeByK();
        System.out.println(canArrangeByK.canArrange(new int[]{1, 2, 3, 4, 5, 6}, 7));
        System.out.println(canArrangeByK.canArrange(new int[]{-1, -1, -1, -1, 2, 2, -2, -2}, 3));
        System.out.println(canArrangeByK.canArrange(new int[]{2, 3, 7, -9, 4, 4, 7, 3, 2, 10, 8, 15, 2, 1, -8, 10, -5, 10, -2, 21, 9, 20, 0, 4, 24, 5, 12, -10, 8, 9, 18, 13, -8, 10, -4, -3, 0, 16, -4, 8, 14, 15, -9, 0, 0, -6, 11, -3, 10, 11, 7, -1, -5, 5, 11, 2, 5, 9, -2, 8, 9, -10, 6, -2, 7, 8, 3, 0, -2, 11}, 18));
        System.out.println(canArrangeByK.canArrange(new int[]{2153, 7, -1, 2, 8, 8, 4, 2149, 2153, 5, 0, 7, 4, 2147, -4, 0, -3, 8, -3, 2147, 7, -9, -1, -6, -7, 2145, 2159, 3, 2154, -8, -6, 5, 7, 2155, 3, 4, -2, -9, -6, 0, 2156, 3, -9, 1, 10, 8, -6, 0, 2145, 2155, 4, -6, 0, 3, -10, 4, -2, 1, -3, -10, 2154, 5, 7, -5, 6, 10, 9, 2148, 2158, 9, 2147, 3, 2153, -9, 2146, -2, 5, 9, -8, 2146, 2150, 3, 2, 2158, 2145, -2, 5, 1, -8, 5, -4, -4, 4, 2152, -9, 7, 1, -4, -1, 2, -5, -3, -9, 8, 5, 2148, -2, 1, -10, 2148, 4, 6, 2, 6, 4, 2, -3, 2155, -7, -6, 4, -9, -4, 2145, 2149, -3, 0, 10, 2147, 8, 2150, -10, -2, 6, -7, 6, 1, -6, 9, 3, 6, 2151, 2145, 7, 2, -1, 9, 3, 2, 1, -6, 8, 6, 7, 2150, 9, 0, -4, 9, -2, -3, 1, -9, 2155, 1, 8, 2148, -8, -8, -1, 7, 10, 2155, 8, -1, 7, 7, 2, -3, -6, 1, -2, 8, 2154, -1, 2153, 8, 6, 6, 8, -4, 3, 3, -10, 4, 9, 2150, 5, 0, 2146, 2152, 2152, 6, 1, 2153, -4, -3, -1, 1, 9, -5, 2152, 2153, -8, 7, 2161, -2, 2146, 2147, -3, -8, 2154, 2153, 1, 7, -2, 6, 9, -8, -9, -8, 0, -8, 6, 0, -10, 2151, 2, 5, 2150, -6, 2148, -1, 4, -6, 2145, 2159, 3, -1, 5, 7, -6, -8, 2152, 2146, -7, -7, -1, 5, 2145, 2160, 5, 2157, -1, 3, 5, 6, 10, -1, 2151, 2146, 2146, 8, -1, 6, 2151, 7, 2155, -2, -2, 7, 2153, 4, 0, -4, 8, -8, 2149, -2, 2, 7, 6, -5, 2152, 4, 10, -6, 3, 0, 0, 2153, 1, 7, 2152, 2157, 9, 5, -1, -9, -5, 7, -2, -6, 2147, 2145, 3, 1, 8, 3, 9, -6, -1, 0, -4, 7, 7, 9, 6, 9, -5, -10, 2146, 3, 2145, 8, 2154, 2155, 2148, 1, 5, -10, 9, 10, 8, -7, 10, -3, -5, 2146, 0, -3, 7, 10, 1, 7, 2148, 0, 2161, 2145, 2147, 9, 5, 2149, 10, 3, 6, 2147, 6, 2148, 2151, 4, 0, 2151, 6, 6, 8, 5, 4, -1, 2146, -6, -2, 9, -2, -10, 2, -1, 2147, -2, 2151, 0, -7, -6, -3, 2163, 0, 9, -4, 5, -6, -6, 10, 5, -6, -9, 7, 10, -6, -2, 3, 2159, 8, 9, 10, 9, 4, 0, 2, 6, 2157, 2154, 2160, 2145, 10, 6, 2145, -3, 6, -4, 8, 5, 9, 2146, 2145, 0, -1, 2152, 8, 0, 4, 2151, -4, 2148, -2, -5, 7, 2154, 10, -5, 6, 2, 2154, -2, 5, 1, -6, 7, 9, 2152, 2150, 3, 10, 3, 2151, 1, -5, 3, -3, 2149, 4, 2153, 2148, 2151, 2148, 8, 5, 3, -5, -6, -7, -6, 9, -8, -1, -6, 1, 3, 2151, -3, -2, 6, 2159, -3, -1, -8, -6, 9, -4, 2156, 2162, -1, 2153, -7, 2, 4, 5, 2146, 8, -9, 2149, 2148, 2157, -3, 2152, 2159, -1, 2148, -4, 6, 4, 10, -4, -5, 2159, 6, 2156, -2, 8, -4, 10, -10, 2, -4, 2146, -9, 5, 7, 2154, 7, 6, 10, -5, 2148, 1, 6, 2146, 9, 7, 2151, 5, 10, -9, 2149, 2154, -3, -2, -6, 2148, 6, 2156, 2161, 2, 0, -9, -10, -8, 0, 0, 2155, 2160, -8, -10, -2, 2147, -4, 2150, 9, 2154, 7, 3, -2, 4, -8, -2, 2, 2158, 2156, 5, -2, 2151, 3, 2146, 2146, 2154, 3, 5, 2156, 2149, -7, 0, 6, 10, 8, 1, 8, 2150, 2155, -9, 7, 2159, 6, 2158, 1, -10, 10, 9, -7, 4, -6, 2146, -7, -6, -1, -7, 6, 10, -5, -8, 3, 10, 2157, 8, 2148, 2154, 7, -6, 0, -2, -4, -8, 3, -2, 6, 7, 2, 8, 8, 7, -3, 10, 2152, 2146, 3, 7, 8, 8, 4, -4, -3, -10, 2151, 2151, 2154, -2, 3, -5, -5, 4, 2153, 2151, 5, 7, -2, 1, 1, 2154, 9, -3, -9, -8, 3, -3, 7, 2146, 4, 9, -4, 6, -5, 4, 2, 9, 2, 8, 2157, 2, -5, 2150, 2154, 8, 9, 10, 2151, 1, 4, -7, 2152, 9, 2148, -8, 2150, 10, 10, 10, 5, 2149, 8, 2147, 2152, -4, -8, 2149, 2, -9, -1, -5, 0, 4, 6, 2155, -4, -10, 1, 3, 7, 3, 1, -6, -3, -5, 10, -1, 9, 8, -7, 10, 3, 4, -2, -1, -8, 10, 7, 4, 4, 3, 2147, -8, -1, -2, 10, 2, -7, -8, 2154, 7, -4, 2160, 0, -8, 9, -6, -10, 2148, 2149, 2, 2145, 8, -1, -6, -7, 2147, -10, 2145, -8, 9, 4, -1, 2148, 10, 3, -3, -7, -1, -10, 10, 5, 2159, 7, 2145, 4, 6, -2, 2154, 8, 2150, 7, 2153, -5, 7, -4, -10, 5, 10, 2148, -7, -2, 2158, 2157, -6, -5, 8, 6, 8, -10, 8, 2156, 2148, 9, -1, 2149, 10, 9, -10, 1, 2161, 2152, 8, -4, 2147, 2156, -4, -5, 3, -8, 0, 10, -10, 2163, 5, -2, 4, 2, -6, 1, 1, 2147, 2149, 2, -1, -10, -10, 0, 6, 2160, 2160, 6, 10, -10, 6, -4, 10, 2155, 2, -3, 4, 10, 3, 2145, 4, -10, 9, -8, 7, 6, 2, -8, 10, -7, 4, 5, 2157, -5, 0, 4, -7, 9, 2147, 2157, 9, -10, -8, 1, -2, 6, 2146, -10, 3, 10, 2157, -3, -1, 2153, 6, -5, 5, 8, 7, 2155, 2148, 8, -10, 8, -9, 2159, 2, -2, 10, 9, 2149, 2149, -7, -2, 2, 1, 2147, -5, -6, -10, 9, 5, 2162, 2157, 1, -3, 0, 5, -6, -10, -4, 10, 9, -7, 2163, 2150, 2150, -1, -1, -5, 2159, 9, 2, -8, 4, 9, 2146, 2153, 6, 5, -9, 2, 5, 2161, 10, 4, 6, -4, 2160, -6, -6, 2147, 4, 2156, 0, -1, 9, 6, -9, -7, -1, -2, 0, 7, -4, 5, -8, 0, 2145, 10, 2151, 2145, 7, 2159, 2147, 2154, 2161, 2152, 3, -8, 7, 2, -2, -8, -9, 4, 9, 7, 2147, 8, 6, -9, -4, 1, 10, -2, 2146, 8, 2157, 10, 0, 1, -4, -2, -8, 1, -5, -2, 2150, 6, 2, -6, 2150, 10, 7, -2, 2156, 1, -9, 2152, 1, 1, -4, 7, 9, 4, 8, 7, 2, -4, 4, 9, -2, 6, -8, -4, 2149, 7, 2152, -9, 10, 7, -9, 2154, -4, -7, -4, -7, -6, -9, 2153, -7, 2155, -6, -7, 6, 1, 6, -1, 2146, 6, 8, 2150, 2145, 1, 3, 2147, 4, 8, 8, 6, 4, 3, 9, 10, -6, 2157, 9, 8, 2161, 6, 2156, 2146, 3, 2152, -6, 7, 2, 2147, -10, -10, 2159, 2153, 2151, 1, 4, 2150, 1, 5, -3, 7, 2154, -7, 2, 2145, 5, -1, -9, -7, 2157, -9, 7, 5, 2150, -2, 8, 2146, 5, 4, 0, 0, 2154, -10, 10, 7, 1, 6, -6, 4, 9, -10, 10, 1, 2156, -10, 8, -4, 2150, -3, -8, 2145, 2150, -2, 0, 1, -10, 2145, 2151, 0, 2157, 0, 6, -2, 0, 5, -4, 6, 2153, 3, 2146, -6, 8, 2150, 7, 6, 10, -3, -8, 2155, -2, -2, 9, 3, -4, 5, 2154, -1, 2156, 2, 1, -3, 0, -9, 4, 2155, 2, 2145, 2149, 2154, 2154, 8, -7, -1, 9, 9, -8, 2157, -4, 0, 10, 1, -4, 1, 3, 2147, -4, 8, 5, 2158, -3, 7, -10, 2161, -8, 2146, -9, -4, 10, -6, -1, 3, -10, -1, -9, 9, -8, 2154, 4, -8, -2, -6, 10, 2149, 6, 2146, 2147, 2155, 10, -1, 2147, 2156, 9, -2, -9, 2153, 2149, 2147, 3, -2, 2146, 2159, 4, 4, 6, -8, 2, 10, 0, 10, 10, 10, 9, 9, 2154, 1, 2157, 3, -1, 2148, 6, -1, 7, 4, 9, 6, -6, 1, 7, -9, 2156, 2, -1, 4, 2151, 8, 2145, 2145, 0, -1, 2155, -6, 9, 2145, -5, 2146, 9, 0, 2149, 7, 4, 3, 4, 7, 6, -6, 4, 9, 4, 2146, -7, -1, -7, 1, -10, 8, 2, 2145, 2147, -10, 2145, 2148, 2145, 2145, 10, -1, 5, 2159, 2149, -7, 4, 2150, 5, 4, 10, 2151, 9, 4, 7, -1, -1, 6, -9, -6, 2156, 4, 2, 2154, 9, 0, -8, 4, -10, 4, 4, 7, 2153, -3, 5, -8, 0, -1, 9, 2156, -1, 7, -1, 10, -2, -2, 0, 2147, -3, 9, -2, 2151, -1, 4, 2145, 2156, 10, -8, 2152, -1, 1, 2146, 1, 2156, 2146, 2152, -10, -6, 4, 6, 9, 6, 2149, -10, -7, 2149, 2148, 10, 2, 9, 0, -4, 2163, -4, 2146, 4, 3, 9, -1, 7, -8, 6, 1, 1, 2157, 3, 1, 2159, 2155, 9, -6, -3, 2150, 9, -2, 7, 10, 2147, 0, 5, 3, -3, 0, 5, 10, 10, 5, 7, 2145, -3, 2146, 10, 0, 6, 0, 5, 2145, 2154, -8, -8, -8, 4, 3, 5, -2, 6, -6, 2, -4, -3, 3, 8, -8, 4, 9, -8, -9, 2151, -4, 2157, 2, 10, 2147, 9, 2146, 2152, -7, 2155, 2151, -5, 2153, -1, 8, 8, 2146, 0, -2, 8, 4, -8, 1, -10, -8, 2158, -3, -3, -8, 9, 2148, 2161, 10, 2153, 5, -5, 2157, -4, 2148, 9, 2145, 10, 2155, -9, 2149, 2148, 2152, 2153, 5, -10, 10, 10, 5, 10, -1, 2145, -9, -8, 4, 9, 7, 6, 2, 0, 4, 2146, 3, 2155, 1, -5, 2, 1, -4, 2147, 10, 3, 8, 1, -9, 8, 8, -2, 6, -7, -7, 6, 10, 2152, 2145, 5, 2147, 3, -1, -1, -5, -4, 7, -9, -6, -6, -3, 2147, -2, 2147, 2, 2150, -4, -5, 3, 6, 9, 2146, 1, 1, 6, 8, -5, 9, 2157, 2148, -2, 2163, 3, 2151, 4, 8, 9, 2153, -6, -4, 8, 2157, 2147, 2147, 9, -8, 0, -1, 1, 2156, 2147, -8, -2, 4, 2, 2147, -6, -2, -2, 2155, 2146, 6, 5, 0, -1, 2152, 8, -2, 6, 2156, 2155, 2151, 2146, -7, 0, -7, 10, 2157, 6, 5, 10, 5, -10, 2, -4, 6, -1, 8, 2147, 0, -7, 2151, -1, 10, 3, 2, 2163, 0, 7, 2161, 1, 8, 2, -6, 0, 2145, -1, 6, 2148, 8, 2149, 2149, -4, -3, -8, 10, -1, -1, 4, 2149, -6, -5, 5, -7, -10, 2149, 6, -1, -7, -9, 8, -10, 0, 8, -6, 8, -1, 2161, 2153, 2146, 0, 8, 2149, 2148, 2145, 1, 2147, -5, 7, 7, -4, 2153, -4, 5, -6, 2158, 2151, 10, -5, 9, 10, 2, 9, 0, 8, -3, 1, 2147, -8, -5, 2146, 8, -1, 5, -2, 9, 0, 7, 8, 2, -9, -6, 2163, 2148, -5, 8, 2159, 2148, 10, 7, 2, 1, 1, 6, 7, 5, 7, 2145, -3, -3, 0, -7, 5, -4, -4, 2, 2152, -1, 2146, 4, 6, -6, 2150, 2148, 6, -3, 5, 2162, -10, 2149, 7, 7, 7, 8, 2153, -2, 3, -6, 2146, 7, 2158, 2150, 2153, 2154, 4, -4, 9, -2, -3, -8, -9, -3, 8, 2146, 8, 2150, -3, -8, 1, 9, -9, -2, 10, -1, 9, 0, -4, 1, 2150, 2149, 0, 2163, -8, 10, 9, 1, 0, -3, -7, 2147, -6, 0, 0, -7, -6, 2161, 6, 2154, -5, 6, 9, 2156, 2156, 2, -8, 3, 3, 1, 0, -9, -3, 3, -10, 2154, 2, 3, 1, 2147, 2151, 6, 10, 9, 2149, 2149, -2, 9, 2145, -8, -10, -10, -1, 7, 8, 4, -7, -3, -9, -8, 9, -3, 2, 2155, -1, -3, 1, 2153, -7, 2145, 2, 6, 2, -1, 2164, -3, 8, 2, 10, 6, -6, 0, -10, 10, 6, 8, 4, 2155, 7, 2147, 7, -4, 0, -7, 4, -7, -8, 7, 9, 2149, 10, 0, 10, -5, 2148, 4, 7, 6, -2, -5, -8, -7, 10, 2146, 7, 2148, -7, 0, 8, 2148, 5, 2152, 10, 2149, 2155, -7, -2, -2, 2145, -2, 0, 8, -2, 6, 2158, 4, 5, -2, 1, 3, 5, -2, -2, 7, -5, -6, -1, 8, -4, -8, 9, 6, -5, -5, -1, 3, 7, 9, 2, -3, 2155, 2160, -3, 10, -6, -10, -9, -2, 4, -10, -5, -4, 2160, -8, 2152, 2156, 2147, 8, 4, 2156, 5, 8, -6, 10, 0, 9, -9, 3, -5, -2, 2146, 2, -1, 2145, 2151, -5, 2156, 5, 2, -10, -4, 4, -7, 4, 8, 2, 7, 3, 2148, 8, 7, -3, 7, -4, 2, -9, 1, 2151, 10, -3, 6, -4, 2146, 2152, 2156, 8, 2153, 2152, 8, 2152, 10, -2, 6, -8, -6, 2145, 4, -7, 7, 0, 7, 10, 0, 6, 8, 2147, 1, 5, 2153, 3, 2, 6, 2, 2, -6, 4, 2146, -8, 9, 2158, 7, 2146, 2156, 5, 2160, 2153, -5, 8, 8, 9, -1, -2, 10, 8, 8, -1, -4, 10, 7, -9, 4, -9, -4, -4, -8, 4, 2153, -1, 10, 4, -4, -1, 10, 10, 10, 2, 9, 2154, 2153, 3, -6, -6, 10, 2148, 4, -2, 2156, 7, -8, -6, 9, 9, -7, -1, -1, -6, -4, 7, -9, 9, 2158, 6, 2159, 7, 2149, -7, 8, 7, 2151, 2146, 2155, 9, 2148, 10, -8, 8, 2, -1, 3, 1, -5, -8, 1, 2146, 10, 2157, -1, -7, 10, 0, 2157, 5, 2156, 0, 2, -5, 1, 7, -8, 4, -2, -2, 1, 5, 6, 2145, -7, -10, -5, 2155, 2158, 10, -4, 9, 2150, 7, -5, -1, 4, 1, -8, -8, 1, 2, 9, 4, -9, -8, 2148, 2145, 0, 7, 5, -4, 2, -5, -10, -7, 6, 2, 1, 2154, -7, 2154, 1, 2147, 2151, -4, 8, -9, -7, 10, 4, 2151, -9, 9, 10, -3, 2, 2156, 2145, 8, 1, -5, 4, 5, 2152, 2161, 8, 7, 2146, 2159, 2146, 2148, -10, -9, 2152, -8, 10, -9, 2156, 2147, -10, -9, -3, 1, -3, -1, 6, -10, 2157, 8, 2158, 4, 6, 3, -1, 0, 3, 10, 3, 2, 6, 3, 2, 5, -9, -8, 2, 0, -1, 2148, -9, 5, -8, 5, 2146, 2, 2150, 2145, 4, 6, -1, 6, 2149, 2154, 2146, 2162, 2152, -8, 2, 3, 7, -3, 6, 1, 2157, 8, -5, -6, -9, 2150, 1, 2154, 8, 5, 8, 2, 4, -5, -5, 7, 2145, 9, 7, 8, 4, -3, 1, 3, 9, 1, 2162, 10, 2156, -6, 3, 5, -6, -6, 2149, 2162, -3, 3, -2, 2154, 6, 2149, -2, -7, 9, 2149, -6, 4, -5, 9, -10, 4, 2150, 2154, -5, 7, -6, -2, -10, 2156, 4, 3, 2156, 2, 0, 2, 8, 8, 2148, -6, -10, -1, 0, 3, 10, 4, 8, 4, 1, 6, 2155, 9, 8, 4, 8, 1, 6, 2, 3, -1, 6, 0, 7, 2152, 4, -8, 2156, 10, 8, 10, 4, -6, 2, 3, -5, 10, 2, -3, 2, 2146, 9, 2148, 10, 8, 8, 9, -5, 2145, 3, 1, -1, 10, 6, -6, 2146, 7, 5, 2145, -5, 6, 1, 3, 4, -7, -5, -10, -6, 0, 5, 1, 8, -6, -4, -6, -10, 1, -5, 8, -10, 5, -2, -4, 8, 5, 2147, 1, -2, 2153, 3, -3, 2160, 6, -2, 0, 9, -4, 1, -3, 5, 2149, 2150, 7, -4, -1, 5, 1, 9, 9, 2157, 2149, 1, 3, 2152, -1, 2151, 2145, -5, -2, -10, 2, 5, -7, 10, 5, 5, 2153, -6, 9, -8, -3, 2149, 3, 2, 8, 5, -5, 2151, 2153, 8, 2148, -1, -4, 2146, -3, 10, -1, 8, 3, 6, 2, 8, -2, -10, 7, 5, 10, -1, 3, -1, 1, 2148, 7, 9, -3, -8, 2155, 2, 3, 9, 0, 6, 2153, 2163, 0, 7, 2, -1, 7, 5, 10, -9, 6, 0, -10, 7, 1, 6, 2157, 5, 4, 5, 10, 10, 9, 7, 5, 4, -3, -6, 0, 0, 2, 10, 1, 8, -7, -3, 1, 3, 9, -4, -2, 2157, 2145, 6, -10, -10, 2148, 4, 9, 1, -6, 1, 7, 6, -6, 5, -9, 2148, 9, -8, 2158, -6, 2154, -10, 9, -1, 1, 9, 2161, 10, 8, 2149, 6, 1, 2148, -4, 4, -6, 2157, -6, 0, 1, -10, 1, -8, 8, -1, -9, -2, 10, -9, 2146, -7, 6, 6, 8, 2146, 4, 8, 6, -5, -8, 1, 2152, 5, 9, -2, 2153, -10, -10, 7, 9, -2, 9, 10, 2146, -10, 7, 4, 2155, 9, 2157, 6, 2147, -4, 10, 10, 1, 2, -7, 2150, 2151, 1, 9, -10, -9, 6, 7, 7, 6, 7, 2145, 8, -8, 2148, 1, 3, 2149, 2161, 5, -7, 2150, 10, 2151, -2, -1, 10, -6, 2151, 2159, 4, -1, -5, 9, -7, -5, 2159, 7, -3, 1, -5, 1, 10, 2157, 7, -6, 6, -1, 2154, -4, -9, 2153, 8, -4, 0, 8, -4, 10, 2146, 2149, 2, 2154, -6, -7, 2150, 2153, -9, -2, 2, -5, 2, 2152, 2, -8, 2150, -7, 2146, 4, 2, 2148, 2152, 10, 2147, 2149, 10, 2155, 2149, -3, 1, 2155, 2147, 2145, 2146, -10, -4, -1, 6, 7, 0, 5, 8, 10, -8, -2, 2158, 5, 2155, 2148, -6, -5, 3, 7, 6, 6, 2, 2152, 2156, -4, -8, -4, -10, 7, 4, 8, 10, 0, -10, -6, 1, 9, 2148, 0, 10, 5, -3, 8, 7, -8, 2147, 2151, 2148, -9, -5, 2151, 5, 9, -4, -4, -1, -10, 2148, 2159, 2152, 3, 2, 8, -8, -9, 2, 6, 1, 2148, 8, 5, 8, 6, 2155, 10, -1, 5, -1, 1, -1, -7, 2, -10, -2, 2161, -4, 1, -10, 9, -9, -1, -1, -10, -1, 2147, 2161, -5, 10, 3, -4, 1, 2161, 3, 2153, -2, 9, 10, 2, -7, 8, -5, 2150, -10, 6, 5, -7, 2149, -4, 8, 4, 4, 7, 4, 6, -4, 10, 2, 0, 2146, -7, -7, 2, 5, 4, 9, -10, -10, 9, 3, -6, 5, -8, -5, 5, 2146, -9, -3, 3, -1, -10, 6, 2150, -6, 2150, 9, 2145, 6, -10, 2146, -9, 2148, 1, 0, 2150, 4, 2147, -9, 2158, 2156, -2, -8, 7, 7, 3, 2, 1, 2, 2145, 2158, 6, -4, 10, -3, -5, 3, 2157, 0, -1, -2, 2148, 2150, 8, 2155, 0, 9, -4, -3, 4, -1, -4, -1, 2145, 2150, 2147, -6, 9, -8, 2150, 7, -4, -9, 2, -2, 2153, 2154, 9, 10, 8, 5, 8, 6, -5, -6, 2, -7, -7, 10, 8, 2148, -4, 2152, 2158, 9, 6, 2149, -8, 10, 10, 9, -1, 5, 7, 2149, 2, -3, 2147, 5, 2150, -10, 2154, 2148, 2160, 9, -6, 2145, 8, -9, -4, 8, -2, -3, -7, 3, 1, -7, 2151, 2158, 5, 2150, -3, -4, 2157, 2, -7, 8, 2, 8, 2150, 7, 2151, -10, 6}, 2155));
    }
}
