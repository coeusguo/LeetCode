package Accepted;

/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
import java.util.LinkedList;
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		int trueNumCourses = 0;
		if(prerequisites.length == 0)
			return true;
		
        Vertex[] course = new Vertex[numCourses];
        
        for(int i = 0;i< numCourses;i++)
        	course[i] = null;
        
        for(int i = 0;i < prerequisites.length;i++){
        	int courseNumber1 = prerequisites[i][0];
        	int courseNumber2 = prerequisites[i][1];
        	if(course[courseNumber1] == null){
        		course[courseNumber1] = new Vertex(courseNumber1);
        		trueNumCourses ++;
        	}
        	if(course[courseNumber2] == null){
        		course[courseNumber2] = new Vertex(courseNumber2);
        		trueNumCourses ++;
        	}
        	course[courseNumber1].addInEdge(courseNumber2);
        	course[courseNumber2].addOutEdge(courseNumber1);
        }
        
        int num = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
        	if(course[i] == null)
        		continue;
        
        	if(course[i].getNumberOfInEdge() == 0){
        		queue.addLast(i);
        		num++;
        	}
        }
        
        while(!queue.isEmpty()){
        	int number = queue.pollFirst();
        	Vertex node = course[number];
        	LinkedList<Integer> out = node.getOutEdge();
        	while(!out.isEmpty()){
        		int in = out.pollFirst();
        		course[in].removeInEdge(number);
        		if(course[in].getNumberOfInEdge() == 0){
        			queue.addLast(in);
        			num++;
        		}
        	}
        }
        
        if(num == trueNumCourses)
        	return true;
        else
        	return false;
    }

}

class Vertex{
	private LinkedList<Integer> in;
	private LinkedList<Integer> out;
	private int vertexNumber;
	public Vertex(int vertexNumber){
		in = new LinkedList<>();
		out = new LinkedList<>();
		this.vertexNumber = vertexNumber;
	}
	public void addInEdge(Integer i){
		in.addLast(i);
	}
	public boolean removeInEdge(Integer i){
		return in.remove(i);
	}
	public void addOutEdge(Integer i){
		out.addLast(i);
	}
	public LinkedList<Integer> getOutEdge(){
		return out;
	}
	public int getVertexNumber(){
		return vertexNumber;
	}
	public int getNumberOfOutEdge(){
		return out.size();
	}
	public int getNumberOfInEdge(){
		return in.size();
	}
}