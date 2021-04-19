/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        //start with 2
        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> tree = new ArrayList<>();
        tree.add(root);
        int sum = 0;
        for (int i = 0; i < tree.size(); i++) {
            TreeNode t = tree.get(i);
            if (t.left != null) {
                tree.add(t.left);
            }
            if (t.right != null) {
                tree.add(t.right);
            }
            
            if (t.val % 2 == 0) {
                sum += sumOfGrandchildren(t, 2);
            }
        }
        return sum;
    }
    
    public int sumOfGrandchildren(TreeNode root, int g) {
        if (root == null) {
            return 0;
        }
        if (g == 0) {
            return root.val;
        } else {
            return sumOfGrandchildren(root.left, g - 1) + sumOfGrandchildren(root.right, g - 1);
        }
    }
}
