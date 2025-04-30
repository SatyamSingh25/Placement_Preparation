package sliding_Window;
/**
 * @Sliding_Window
 * @Leetcode_904_FruitsAndBaskets
 * Problem : You are visiting a farm that has a single row of fruit trees arranged from left to right. 
 *           The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *           
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *   - You only have two baskets, and each basket can only hold a single type of fruit. 
 *   - There is no limit on the amount of fruit each basket can hold.
 *   - Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
 *   - The picked fruits must fit in one of your baskets.
 *   - Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 *   - Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 */
import java.util.*;
public class FruitsAndBaskets {
	
	//Sliding  Window
	//TC : O(n)
	//Sc : O(k)
	public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>(); //fruit -> count
        int start = 0;
        int res = 0;
        int baskets = 2;

        for(int end = 0; end < fruits.length; end++){
            map.put(fruits[end], map.getOrDefault(fruits[end], 0)+1);

            if(map.size() > baskets){
                map.put(fruits[start], map.get(fruits[start])-1);
                
                if(map.get(fruits[start]) <=0)
                    map.remove(fruits[start]);
                
                start++;
            }

            res = Math.max(res, end - start + 1);
        }

        return res;
    }

	public static void main(String[] args) {
		System.out.println(totalFruit(new int[] {1,2,3,2,2})); //4 [2,3,2,2]
	}

}
