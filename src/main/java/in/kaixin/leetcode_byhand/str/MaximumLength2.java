//package in.kaixin.leetcode_byhand.str;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//public class MaximumLength2 {
//    //    https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-i/?envType=daily-question&envId=2024-05-29
////    mid
//    public int maximumLength(String s) {
//        int ret = -1;
//        Map<String, List<Integer>> positionList = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            String c = s.charAt(i) + "";
//            List<Integer> list = positionList.get(c);
//            if (list == null) {
//                list = new LinkedList<>();
//                positionList.put(c, list);
//            }
//            list.add(i);
//        }
//        if (positionList.values().size() == 1) {
//            return s.length() - 2;
//        }
//        for (int i = 0; i < s.length() - 2; i++) {
//            String c = s.charAt(i) + "";
//            List<Integer> list = positionList.get(c);
//            if (list.size() < 3) {
//                continue;
//            } else {
//                ret = Math.max(ret, 1);
//                int len = ret + 1;
//                boolean match = doMatch(positionList, s, i, len);
//                while (match) {
//                    ret = len;
//                    len++;
//                    match = doMatch(positionList, s, i, len);
//                }
//            }
//        }
//        return ret;
//    }
//
//    public boolean doMatch(Map<String, List<Integer>> map, String s, int idx, int len) {
//        String str = s.charAt(idx) + "";
//        List<Integer> stringPositionList = map.get(str);
//        if (idx + len > s.length()) {
//            return false;
//        }
////        if (!str.equals(s.charAt(idx + len - 1) + "")) {
////            return false;
////        }
//        String subStr = s.substring(idx, idx + len);
//
//        int count = 0;
//        for (int i = 0; i < stringPositionList.size(); i++) {
//            int offset = stringPositionList.get(i);
//            if (offset <= idx) {
//                continue;
//            }
//
//            if (offset + len > s.length()) {
//                break;
//            }
//            String sub = s.substring(offset, offset + len);
//            if (sub.equals(subStr)) {
//                count++;
//            }
//            if (count > 1) {
//                System.out.println("ret=" + len + ",substr=" + subStr);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        MaximumLength2 l = new MaximumLength2();
////        System.out.println(l.maximumLength("aaaa"));
////        System.out.println(l.maximumLength("abcdef"));
////        System.out.println(l.maximumLength("abcaba"));
////        System.out.println(l.maximumLength("abcccccdddd"));
////        System.out.println(l.maximumLength("ereerrrererrrererre"));
//        System.out.println(l.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"));
//    }
//}
