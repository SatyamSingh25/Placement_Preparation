package binary_Tree;
/* Problem Link : https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1#
 * difficulty : Easy
 */
public class inPlace_Convert_BinaryTree_to_its_SumTree {

	public int convertB_TreeToSumTree(Node root) {
		if(root == null) {
			return 0;
		}
		
		int x = convertB_TreeToSumTree(root.left);
		int y = convertB_TreeToSumTree(root.right);
		int curr = root.data;
		root.data = x+y;
		
		return root.data + curr;
	}

}
