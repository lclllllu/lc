/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> nodeSet = new HashSet<>(Arrays.asList(nodes));
        return findCommonAncestor(root, nodeSet);
    }
    
    private TreeNode findCommonAncestor(TreeNode root, Set<TreeNode> nodeSet) {
        if(root == null || nodeSet.contains(root)) {
            return root;
        }
        
        TreeNode left = findCommonAncestor(root.left, nodeSet);
        TreeNode right = findCommonAncestor(root.right, nodeSet);
        
        if(left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
