package greedy;
/**
 * @StriverSheet
 * @Fractional_Knapsack
 * @Greedy
 * @Can_use_some_part_pf_item_as_use_that_amount_only
 * Link : https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 * Problem : The weight of N items and their corresponding values are given.
 *            We have to put these items in a knapsack of weight W such that the total value obtained is maximized
 *            
 * Note: We can either take the item as a whole or break it into smaller units.
 * 
 * Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.
 * Output: 240.00
 * Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken. 
 *              Total value = 100 + 60 + 80 = 240.00
 */
import java.util.*;
public class _4_Fractional_Knapsack {
	
    static class Item{
        int weight, value;
        Item(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    }
    
    // Function to get the maximum total value in the knapsack.
    //TC : O(n) + O(nlog(n)) + O(n) = O(n)
    //Sc : O(n) for result
    static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = wt.size();
        Item[] items = new Item[n];
        
        for(int i=0; i<n; i++){
            items[i] = new Item(val.get(i), wt.get(i));
        }
        
        Arrays.sort(items, (a, b) -> Double.compare(
            (double)b.value/b.weight,
            (double)a.value/a.weight
        ));
        
        int idx = 0;
        double totalValue = 0;
        while(idx < n && capacity > 0){
            if(items[idx].weight <= capacity){
                totalValue += items[idx].value;
                capacity -= items[idx].weight;
            }
            else{
                double fractionValue = (((double)items[idx].value/items[idx].weight)*capacity);
                totalValue += fractionValue;
                break;
            }
            idx++;
        }
        return totalValue;
    }

	//Driver code 
	public static void main(String[] args) {
		System.out.println(fractionalKnapsack(Arrays.asList(100,60,120), Arrays.asList(20,10,30), 50)); //240.000
	}

}
