package in.kaixin.leetcode_byhand;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author bigyou
 * @Create 2023/11/3 18:33
 */
public class ConnectRight {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        List<Node> level = new LinkedList<>();
        List<Node> nextLevel = new LinkedList<>();
        level.add(root);
        while (!level.isEmpty()) {
            for (int i = 0; i < level.size(); i++) {
                Node currentNode = level.get(i);
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                if (i < level.size() - 1) {
                    currentNode.next = level.get(i + 1);
                } else {
                    currentNode.next = null;
                }
            }
            level = nextLevel;
            nextLevel = new LinkedList<>();
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}