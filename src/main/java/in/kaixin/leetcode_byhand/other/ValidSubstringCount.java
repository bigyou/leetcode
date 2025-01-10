package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSubstringCount {
    //https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/?envType=daily-question&envId=2025-01-09
//    mid
    public long validSubstringCount(String word1, String word2) {
        long total = 0;
        int wordLength = word1.length();
        Map<String, Integer> word2Map = new HashMap<>();
        Map<String, Integer> tempMap = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word2.length(); i++) {
            String w = String.valueOf(word2.charAt(i));
            word2Map.put(w, word2Map.getOrDefault(w, 0) + 1);
            set.add(w);

        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < word1.length(); i++) {
            String w = String.valueOf(word1.charAt(i));
            if (!word2Map.containsKey(w)) {
                continue;
            }
            int v = tempMap.getOrDefault(w, 0);
            tempMap.put(w, v + 1);
            if (v + 1 >= word2Map.get(w)) {
                set.remove(w);
            }
            if(set.isEmpty()){
                right=i;
                for(int j=left;j<=right;j++){
                    total+=word1.length()-i;
                    String wl = String.valueOf(word1.charAt(j));
                    if (!word2Map.containsKey(wl)) {
                        continue;
                    }
                    int vl = tempMap.getOrDefault(wl, 0);
                    tempMap.put(wl, vl - 1);
                    if (vl - 1 < word2Map.get(wl)) {
                        set.add(wl);
                        left=j+1;
                        break;
                    }
                }
            }


        }
        return total;

    }

    public static void main(String[] args) {
        ValidSubstringCount v =new ValidSubstringCount();
        System.out.println(v.validSubstringCount("bcca","abc"));
        System.out.println(v.validSubstringCount("abcabc","abc"));
        System.out.println(v.validSubstringCount("abcabc","aaabc"));
        System.out.println(v.validSubstringCount("bbbb","b"));
    }
}
