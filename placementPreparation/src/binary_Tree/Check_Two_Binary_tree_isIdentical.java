package binary_Tree;

public class Check_Two_Binary_tree_isIdentical {
	
	//recursive method
	public boolean isIdentical(Node root1, Node root2) {
		if(root1 ==  null && root2 == null) {
			return true;
		}
		
		return (root1 != null && root2 != null) &&
				(root1.data == root2.data) &&
				isIdentical(root1.left, root2.left) &&
				isIdentical(root1.right, root2.right);
	}
	
	//naive method
	public static int s1 = 0, s2 = 0;
	
	public boolean isIdentical_Naive(Node root1, Node root2) {
		inOrder(root1);
		s2 = s1;
		s1 = 0;
		inOrder(root2);
		if(s1 == s2) {
			return true;
		}
		return false;
	}
	public static void inOrder(Node root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		s1 = s1*10 + root.data;
	}

}
