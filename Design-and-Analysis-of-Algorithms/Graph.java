//Question 4

import java.util.Stack;

public class Graph {
    private int V;
    private int [] [] list = {{0,1},{0,2},{0,3},{1,4},{2,3},{2,5},{3,1},{3,4},{3,6},{3,5},{5,6},{6,4}};

    public Graph(int V){
        this.V = V;
    }


    public void topologicalSort(){
        int [] indegree = new int[V];

        for(int i=0;i<list.length;i++){
            indegree[list[i][0]]++;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                stack.push(i);
        }

        while(!stack.isEmpty()){
            int current = stack.pop();
            System.out.print((char)(current+'a')+" ");

            for(int i=0;i<list.length;i++){
                if(list[i][1]==current){
                    indegree[list[i][0]]--;

                    if(indegree[list[i][0]]==0)
                        stack.push(list[i][0]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        System.out.println("Topological sort order");
        graph.topologicalSort();
    }
}
