package design;
import java.util.*;
/**
 * @HashMap
 */
/* --------------------------------2671. Frequency Tracker------------------------------------
 * Design a data structure that keeps track of the values in it and answers some queries regarding their frequencies.
 * 
 * Implement the FrequencyTracker class.
 * 		*FrequencyTracker(): Initializes the FrequencyTracker object with an empty array initially.
 * 		*void add(int number): Adds number to the data structure.
 * 		*void deleteOne(int number): Deletes one occurrence of number from the data structure. 
 * 		                             The data structure may not contain number, and in this case nothing is deleted.
 * 		*bool hasFrequency(int frequency): Returns true if there is a number in the data structure that occurs frequency number of times, 
 *                                         otherwise, it returns false.
 * 
 */
public class FrequencyTracker {
	//num  -> freq
	private HashMap<Integer, Integer> numVsFreq;
	//freq -> count
    private HashMap<Integer, Integer> freqVsCount;

    //O(1)
    public FrequencyTracker() {
        this.numVsFreq = new HashMap<>();
        this.freqVsCount = new HashMap<>();
    }
    //O(1)
    public void add(int number) {
        int prevFreq = numVsFreq.getOrDefault(number, 0);
        numVsFreq.put(number, numVsFreq.getOrDefault(number, 0)+1);

        //decreasing previous frequency count
        if(prevFreq != 0 && freqVsCount.containsKey(prevFreq)){
            // System.out.println("came inside");
            freqVsCount.put(prevFreq, freqVsCount.getOrDefault(prevFreq, 0)-1);

            if(freqVsCount.get(prevFreq) <= 0){
                freqVsCount.remove(prevFreq);
            }
        }
        //increasing current frequency count
        int currFreq = numVsFreq.get(number);
        freqVsCount.put(currFreq, freqVsCount.getOrDefault(currFreq, 0)+1);
    }
    
    //O(1)
    public void deleteOne(int number) {
        if(numVsFreq.containsKey(number) == false) return;

        int prevFreq = numVsFreq.get(number);
        numVsFreq.put(number, prevFreq-1);
        
        if(numVsFreq.get(number) <= 0){
            numVsFreq.remove(number);
        }

        freqVsCount.put(prevFreq, freqVsCount.get(prevFreq)-1);
        if(freqVsCount.get(prevFreq) <= 0){
            freqVsCount.remove(prevFreq);
        }
        
        freqVsCount.put(prevFreq-1, freqVsCount.getOrDefault(prevFreq-1, 0)+1);
    }
    
    //O(1)
    public boolean hasFrequency(int frequency) {
        return freqVsCount.containsKey(frequency);
    }
}
