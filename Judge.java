import java.util.*;

public class Judge {

	public int findJudge(int N, int[][] trust) {
	
		int[] incomingEdge=new int[N+1];
		int[] outgoingEdge=new int[N+1];
		//incomingEdge = # of incoming edges to the vertex 1
		//outgoingEdge = # of outgoing edges to vertex
		for(int i=0; i<trust.length; i++) 
		{
			outgoingEdge[trust[i][0]]++;
			incomingEdge[trust[i][1]]++;	
		}

		//if there are incoming edges from whole population (minus itself) but no outoging edges, then that vertex is a judge
		for(int i=1;i<=N;i++) 
		{
			if(incomingEdge[i]==N-1 && outgoingEdge[i]==0)
				return i;
		}
		return -1;
		//if the above conditional does not occur, then there is no judge, -1 is returned
	}
	public static void main(String[] args) 
	{
		
		//creates 5 arrays with the examples given in the lab instructions
		int[][] trust = {{1, 2}};
		int[][] trust2={{1,3}, {2, 3}};
		int[][] trust3 = {{1, 3}, {2, 3}, {3, 1}};
		int[][] trust4 = {{1, 2}, {2, 3}};
		int[][] trust5 = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};

		//runs the 5 examples through the findJudge method
		int ex1 = new Judge().findJudge(2, trust);
		int ex2 = new Judge().findJudge(3, trust2);
		int ex3 = new Judge().findJudge(3, trust3);
		int ex4 = new Judge().findJudge(3, trust4);
		int ex5 = new Judge().findJudge(4, trust5);

		//prints results of each example
		System.out.println("Example 1: "+ ex1);
		System.out.println("Example 2: "+ ex2);
		System.out.println("Example 3: "+ ex3);
		System.out.println("Example 4: "+ ex4);
		System.out.println("Example 5: "+ ex5);

	}
}