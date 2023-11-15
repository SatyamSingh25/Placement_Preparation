package binary_Tree;
import java.util.*;
public class MinimumSwapsToSortBST_Level_wise {
	
	public int minimumSwapToSortBST_levelwise(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> innerList = new ArrayList<>();
			
			while(size-- != 0) {
				Node curr = queue.poll();
				innerList.add(curr.val);
				
				if(curr.left != null) queue.offer(curr.left);
				if(curr.right != null) queue.offer(curr.right);
			}
			
			count += minimumSwapToSort(innerList);
		}
		
		return count;
	}
	
	public int minimumSwapToSort(List<Integer> arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.size(); i++) 
			map.put(arr.get(i), i);
		
		List<Integer> sorted = new ArrayList<>(arr);
		Collections.sort(sorted);
		
		int swap = 0;
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i) == sorted.get(i))
				continue;
			
			swap++;
			map.put(arr.get(i), map.get(sorted.get(i)));
			arr.set(map.get(sorted.get(i)), arr.get(i));
		}
		return swap;
	}
	
	
	class Node{
		int val;
		Node right, left;
		
		Node(){}
		Node(int val){
			this.val = val;
			this.right = null;
			this.left = null;
		}
	}

}
