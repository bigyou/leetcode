package in.kaixin.leetcode_byhand.link;

public class MergeNodes {
//    https://leetcode.cn/problems/merge-nodes-in-between-zeros/?envType=daily-question&envId=2024-09-09

    public ListNode mergeNodes(ListNode head) {
        ListNode current = head;
        head = new ListNode();
        ListNode rescursor = head;
        Integer v = null;
        while (current != null) {
            if (current.val == 0) {
                if (v != null) {
                    ListNode node = new ListNode();
                    node.val = v;
                    v = null;
                    rescursor.next = node;
                    rescursor = rescursor.next;
                }
            } else {
                if (v == null) {
                    v = current.val;
                } else {
                    v += current.val;
                }
            }
            current = current.next;
        }
        return head.next;
    }
}

