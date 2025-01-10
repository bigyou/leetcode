package in.kaixin.leetcode_byhand.link;

import com.alibaba.fastjson.JSON;

import java.util.PriorityQueue;
import java.util.Stack;

public class RemoveNodes {
//    mid
//    https://leetcode.cn/problems/remove-nodes-from-linked-list/?envType=daily-question&envId=2024-05-27

    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cursor = head;
        while (cursor != null) {
            while (!stack.empty()){
                if(stack.peek().val<cursor.val){
                    stack.pop();
                }else{
                    break;
                }
            }
            stack.push(cursor);
            cursor=cursor.next;
        }
        ListNode ret=null;
        while(!stack.empty()){
            ListNode v = stack.pop();
            if(ret==null){
                ret=v;
            }else {
                v.next=ret;
                ret=v;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        RemoveNodes r = new RemoveNodes();
        ListNode header= new ListNode(5);
        ListNode a= new ListNode(2);
        ListNode b= new ListNode(13);
        ListNode c= new ListNode(3);
        ListNode d= new ListNode(8);
        header.next=a;
        a.next=b;
        b.next=c;
        c.next=d;
        ListNode res = r.removeNodes(header);
        System.out.println(JSON.toJSONString(res));
    }

}
