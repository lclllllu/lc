/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node nodeP = p;
        Node nodeQ = q;
        
        while(nodeP != nodeQ){
            nodeP = nodeP == null ? q : nodeP.parent;
            nodeQ = nodeQ == null ? p : nodeQ.parent;
        }
        
        return nodeP;
    }
}

