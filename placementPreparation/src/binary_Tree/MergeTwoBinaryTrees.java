package binary_Tree;
/*Problem link : https://leetcode.com/problems/merge-two-binary-trees/
 * 
 *                      LEETCODE 617
 *                      
 * Description : Imagine that when you put one of them to cover the other,
 *               some nodes of the two trees are overlapped while the others
 *               are not. You need to merge the two trees into a new binary
 *               tree. The merge rule is that if two nodes overlap, then sum
 *               node values up as the new value of the merged node. Otherwise,
 *               the NOT null node will be used as the node of the new tree.
 *               
 * Difficulty : Easy
 */
public class MergeTwoBinaryTrees {
	
	//approach
	public Node mergeTrees(Node root1, Node root2) {
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;
        
        Node temp = new Node(root1.data + root2.data);
        temp.left = mergeTrees(root1.left, root2.left);
        temp.right = mergeTrees(root1.right, root2.right);
        
        return temp;
    }
}
