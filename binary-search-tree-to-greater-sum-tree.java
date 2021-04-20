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
    public ArrayList<Integer> arr;
    public TreeNode bstToGst(TreeNode root) {
        arr = new ArrayList<>();
        inorder(root);
        
        ArrayList<Integer> sums = new ArrayList<Integer>();
        for (int i = 0; i < arr.size(); i++) {
            int check = arr.get(i);
            int sum = 0;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j) >= check) {
                    sum += arr.get(j);
                }
            }
            
            sums.add(sum);
        }
        System.out.println(sums.get(0));
        
        TreeNode newGuy = GST(root, sums);
        return newGuy;
    }
    
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            arr.add(root.val);
            inorder(root.right);
        }
    }
             
             
             
    public TreeNode GST(TreeNode root, ArrayList<Integer> a) {
        if (root == null) {
            return root;
        }
        TreeNode guy = new TreeNode();
        for (int i = 0; i < a.size(); i++) {
            if (arr.get(i) == root.val) {
                guy = new TreeNode(a.get(i));
                
            }
        }
        guy.left = GST(root.left, a);
        guy.right = GST(root.right, a);
        return guy;
    }
}
