package binary_Tree;
/*description : https://practice.geeksforgeeks.org/problems/symmetric-tree/0/?track=amazon-trees&batchId=192#
 *difficulty : Easy
 */
public class Is_Symmetric_Tree_or_Not {
	
	public static boolean check(Node root1,Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        
        if((root1 != null && root2 != null) && (root1.data == root2.data) )
            return check(root1.left, root2.right) && check(root1.right, root2.left);
            
        return false;
    }
	
    public static boolean isSymmetric(Node root)
    {
        if(root == null || (root.left == null && root.right == null))
            return true;
        return check(root.left, root.right);
    }

}
