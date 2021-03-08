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
class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode node = findLCA(root, p, q);
        int distance1 = getDistance(node, p, 0);
        int distance2 = getDistance(node, q, 0);
        
        return distance1 + distance2;
    }
    
    public TreeNode findLCA(TreeNode root, int p, int q){
        if(root == null) {
            return null;
        }
        
        if(root.val == p || root.val == q) {
            return root;
        }
        
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        
        if(left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
    
    public int getDistance(TreeNode root, int p, int distance){
        if(root == null) {
            return 0;
        }
        
        if(root.val == p) {
            return distance;
        }
        
        int left = getDistance(root.left, p, distance+1);
        int right = getDistance(root.right, p, distance+1);
        
        return Math.max(left, right);
    }

}
