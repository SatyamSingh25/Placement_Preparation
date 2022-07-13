package graph;
import java.util.*;
public class CourseShdeuling_2 {
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph  = new ArrayList<>(numCourses);
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        if(detectCycle(numCourses, graph) == true){
            return new int[0];
        }
        return toposort(numCourses, graph);
    }
    
    public static int[] toposort(int vertices, ArrayList<ArrayList<Integer>> graph){
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[vertices];
        
        for(int i=0; i<vertices; i++){
            if(visited[i] == false){
                toposortUtil(i, visited, graph, stack);
            }
        }
        int[] res = new int[vertices];
        for(int i=0; i<vertices; i++){
            res[i] = stack.pop();
        }
        return res;
    }
    
    public static void toposortUtil(int source, boolean[] visited, ArrayList<ArrayList<Integer>> graph, Stack<Integer> stack){
        visited[source] = true;
        for(int i: graph.get(source)){
            if(visited[i] == false){
                toposortUtil(i, visited, graph, stack);
            }
        }        
        stack.push(source);
    }
    
    public static boolean detectCycle(int vertices, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[vertices];
        boolean[] recVisited = new boolean[vertices];
        for(int i=0; i<vertices; i++){
            if(visited[i] == false){
                if(isCycleUtil(i, visited, recVisited, graph)==true){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean isCycleUtil(int source, boolean[] visited, boolean[] recVisited, ArrayList<ArrayList<Integer>> graph){
        visited[source] = true;
        recVisited[source] = true;
        
        for(int i: graph.get(source)){
            if(visited[i] == false){
                if(isCycleUtil(i, visited, recVisited, graph) == true){
                    return true;
                }
            }
            else if(recVisited[i] == true){
                return true;
            }
        }
        recVisited[source] = false;
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
