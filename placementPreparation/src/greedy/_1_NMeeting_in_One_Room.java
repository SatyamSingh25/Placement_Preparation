package greedy;
/**
 * @StriverSheet
 * @NMeeting_IN_Single_room
 * @Greedy
 * @Sort_As_End_Time_of_interval
 */
import java.util.*;
public class _1_NMeeting_in_One_Room {
	static class Meeting{
		int start, end, index;
		
		Meeting(int start, int end, int index){
			this.start = start;
			this.end = end;
			this.index = index;
		}
	}
	//Approach
	//TC : O(n) + O(nlog(n)) + O(n)
	//SC : O(n)
	public static int nMeetingInOneRoom(int[] start, int[] end) {
		
		ArrayList<Meeting> meetings = new ArrayList<>();
		for(int i=0; i<start.length; i++) {
			meetings.add(new Meeting(start[i],end[i], i+1));
		}
		
		//sort acc-to meeting END TIME, if they equal then acc-to INDEX
		Collections.sort(meetings, (a, b) -> {
			if(a.end != b.end)
				return Integer.compare(a.end, b.end);
			else
				return Integer.compare(a.index, b.index); 
		});
		
		ArrayList<Integer> acceptedMeetings = new ArrayList<>();
		
		//First meeting 
		acceptedMeetings.add(meetings.get(0).index);
		int currEnd = meetings.get(0).index;
		
		//starting from second meeting 
		for(int i=1; i<meetings.size(); i++) {
			if(currEnd < meetings.get(i).start) { //new meeting possible
				currEnd = meetings.get(i).end;
				acceptedMeetings.add(meetings.get(i).index);
			}
		}
		
		System.out.println(acceptedMeetings); //sequence of meeting
		return acceptedMeetings.size();
	}

	//Driver Code
	public static void main(String[] args) {
		System.out.println(
				nMeetingInOneRoom(new int[] {1,3,0,5,8,5}, //[1, 2, 4, 5]
						         new int [] {2,4,5,7,9,9}));//4 
		
	}

}
