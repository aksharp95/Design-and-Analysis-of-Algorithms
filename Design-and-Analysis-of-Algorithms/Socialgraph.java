// Question 3

import java.util.LinkedList;
import java.util.Queue;

public class Socialgraph {
    private int V;
    private LinkedList<Integer> [] adjacency;

    Socialgraph(int V){
        this.V = V;
        adjacency = new LinkedList[V];
        for(int i=0;i<V;i++)
            adjacency[i] = new LinkedList<Integer>();
    }

    public void addEdge(int start, int end){
        adjacency[start].add(end);
    }

    public void BFS(int s){
        boolean [] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty()){
            int element = queue.poll();
            System.out.print(element+" ");
            LinkedList<Integer> childrens = adjacency[element];
            for(Integer i: childrens){
                if(!visited[i]){
                    queue.add(i);
                    visited[i]= true;
                }
            }
        }
    }

    public void DFS(int s){
        boolean [] visited = new boolean[V];

        DFSUtil(s,visited);
    }

    public void DFSUtil(int s, boolean [] visited){
        visited[s] = true;
        System.out.print(s+" ");

        LinkedList<Integer> childrens = adjacency[s];
        for(Integer n: childrens){
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }
}

class GraphMain{
    public static void main(String[]args){
        Socialgraph g = new Socialgraph(8);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(1,5);
        g.addEdge(1,6);
        g.addEdge(2,0);
        g.addEdge(2,1);
        g.addEdge(2,4);
        g.addEdge(3,0);
        g.addEdge(3,7);
        g.addEdge(4,2);
        g.addEdge(4,6);
        g.addEdge(5,1);
        g.addEdge(5,6);
        g.addEdge(6,1);
        g.addEdge(6,4);
        g.addEdge(6,5);
        g.addEdge(7,3);

        System.out.println("BFS Traversal ");
        g.BFS(0);

        System.out.println("\nDFS Traversal ");
        g.DFS(0);



    }
}