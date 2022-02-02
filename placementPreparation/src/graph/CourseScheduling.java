package graph;
/**
 * @Toposort
 * @DFS
 * @Backtracking
 * @Graph
 * @Leetcode_207
 */
import java.util.*;
public class CourseScheduling {

	//Method
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//Graph creation
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numCourses);
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        //Adding edge
        for(int i=0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //Detect Cycle (because if there is cycle in graph so thats means one course is dependent to another course & that is on that node) 
        if(isCycle(numCourses, graph)){
            return false;
        }
        
        return true;
    }
	//method to detect a cycle in Directed graph
    public boolean isCycle(int vertices, ArrayList<ArrayList<Integer>> graph){
    	//visited marking
        boolean[] visited = new boolean[vertices];
        boolean[] recVisited = new boolean[vertices];
        
        for(int i=0; i<vertices; i++){
            if(visited[i] == false){
                if(isCycleUtil(i, graph, visited, recVisited)){
                    return true;
                }
            }
        }
        
        return false;
    }
    //Is Cycle supporter method
    public boolean isCycleUtil(int source, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] recVisited){
    	//marking current node TRUE
        visited[source] = true;
        recVisited[source] = true;
        //visiting all adjacent connected node
        for(int i: graph.get(source)){
            if(visited[i] == false){
                if(isCycleUtil(i, graph, visited, recVisited)){
                    return true;
                }
            }
            else if(recVisited[i] == true){
                return true;
            }
        }
        //for re-visit we have to make itn false
        recVisited[source] = false;
        
        return false;
    }
}
