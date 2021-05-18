package binary_Tree;
/*
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
}
