package binary_Tree;
/* problem link : https://leetcode.com/problems/binary-tree-paths/
 * Difficulty : easy
 */
import java.util.*;

public class All_Paths_from_Root_to_leaf {
	
	//Approach for learning and understanding the concept with easy method
	//iterative approach
	public List<String> binaryTreePaths(Node root) {
        List<String> paths = new ArrayList<String>();
        
        if(root == null){
            return paths;
        }
        
        if(root.left == null && root.right == null){
            paths.add(root.data +"");
            return paths;
        }
        
        for(String path: binaryTreePaths(root.left)){
            paths.add(root.data + "->" + path);
        }
        
        for(String path: binaryTreePaths(root.right)){
            paths.add(root.data + "->" + path);
        }
        
        return paths;
    }

	//recursive approach and efficient approach 
	public List<String> binaryTreePathsFromRootToLeaf(Node root){
		List<String> result = new ArrayList<>();
		if(root != null) {
			searchingPaths(root, "", result);
		}
		return result;
	}
	
	public void searchingPaths(Node root, String path, List<String> result) {
		if(root.left == null && root.right == null ) {
			result.add(path + root.data );
		}
		
		if(root.left != null ) {
			searchingPaths(root.left, path + root.data + "->", result);
		}
		
		if(root.right != null) {
			searchingPaths(root.right, path + root.data + "->", result);
		}
	}
	
	
	//GFG approach
	// link : https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        if(root != null)
            solve(root, new ArrayList<Integer>(), arr);
        
        return arr;
    }
    
    public static void solve(Node root, ArrayList<Integer> innerList, ArrayList<ArrayList<Integer>> arr){
        innerList.add(root.data);
        
        if (root.left == null && root.right == null) {
            arr.add(new ArrayList<>(innerList)); 
        } 
        else {
            if (root.left != null)
                solve(root.left, innerList, arr);

            if (root.right != null)
                solve(root.right, innerList, arr);
        }
            
        innerList.remove(innerList.size()-1);
    }
}
