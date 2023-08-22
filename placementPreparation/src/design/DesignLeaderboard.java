package design;
/*
 * ---------------------------------------Design the leaderboard--------------------------------------------
 * 
 * AddScore [playerId, score] -> Update the leaderboard by adding a score to the given player’s score.
 * 								If there doesn’t exist any player, add such id on the leaderboard.
 * 
 * Top [k] -> Return the top sum of K players
 * 
 * reset [playerId] -> Reset the score of the given player ID. 
 */
import java.util.*;

import dynamic_Programming.Min_JumpToEnd_zeroJumpPossible;
public class DesignLeaderboard {
	//-----playerId--score
	HashMap<Integer, Integer> map;
	
	//-------score----count
	TreeMap<Integer, Integer> sorted;
	
	public DesignLeaderboard() {
		map = new HashMap<>();
		sorted = new TreeMap<>(Collections.reverseOrder()); //max at first
	}
	
	//Adding player with its score
	void addScore(int playerId, int score) {
		if(map.containsKey(playerId) == false) {
			map.put(playerId, score);
			sorted.put(score, sorted.getOrDefault(score, 0)+1);
		}
		else {
			int preScore = map.get(playerId);
			sorted.put(preScore, sorted.get(preScore)-1);
			if(sorted.get(preScore) <= 0)
				sorted.remove(preScore);
			
			int newScore = preScore + score;
			map.put(playerId, newScore);
			sorted.put(newScore, sorted.getOrDefault(newScore, 0)+1);
		}
	}
	
	//top K score sum
	int top(int k) {
		int sum = 0; 
		
		//getting top score with there [number of count]->how many time score is stored into DB
		for(int score: sorted.keySet()) {
			int count = sorted.get(score);
			if(k == 0) break;
			
			if(k - count >= 0) {
				sum += score * count;
				k -= count;
			}
			else {
				sum += (score * k);
				k -= k;
			}	
		}
		
		return sum;
	}
	
	//Reseting the score of the given player ID
	void reset(int playerId) {
		int preScore = map.get(playerId);
		
		//decrease that playerId score count by 1 because its score is vanished
		sorted.put(preScore, sorted.getOrDefault(preScore, 0)-1); 
		if(sorted.get(preScore) <= 0)
			sorted.remove(preScore);
		
		map.remove(playerId); //if score is 0 then there is no means to get that player into DB
	}

	public static void main(String[] args) {
		DesignLeaderboard obj  = new DesignLeaderboard();
		obj.addScore(1, 10);
		obj.addScore(1, 20);
		
		obj.addScore(2, 20);
		obj.addScore(3, 30);
		obj.addScore(4, 20);
		obj.addScore(5, 10);
		System.out.println("sorted: " + obj.sorted);
		System.out.println("map: " + obj.map);
		System.out.println("top 3 sum: " + obj.top(3));
		
		obj.reset(1);
		System.out.println("After reset 1");
		System.out.println("sorted: " + obj.sorted);
		System.out.println("map: " + obj.map);
		
	}

}
