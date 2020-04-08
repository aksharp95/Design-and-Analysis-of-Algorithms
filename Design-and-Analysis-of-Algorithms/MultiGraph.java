// Question 6

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MultiGraph {
    private int V;
    private LinkedList<Integer> [] adjacency;
    private HashSet<Integer> [] answer;

    MultiGraph(int V){
        this.V = V;
        adjacency = new LinkedList[V];
        for(int i=0;i<V;i++)
            adjacency[i] = new LinkedList<Integer>();

        answer = new HashSet[V];
        for(int i=0;i<V;i++)
            answer[i] = new HashSet<>();
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
            //System.out.print(element+" ");
            LinkedList<Integer> childrens = adjacency[element];
            for(Integer i: childrens){
                if(element!=i)
                    answer[element].add(i);

                if(!visited[i]){
                    queue.add(i);
                    visited[i]= true;
                }
            }
        }
    }

    public void printAdjacencyList(){
        for(int i=0;i<V;i++){
            LinkedList<Integer> child = adjacency[i];
            System.out.print("\nFor Node "+i+" : ");
            for(Integer n: child){
                System.out.print(n+" ");
            }
        }
    }

    public void printNewAdjacencyList(){
        for(int i=0;i<V;i++){
            HashSet<Integer> child = answer[i];
            System.out.print("\nFor Node "+i+" : ");
            for(Integer n: child){
                System.out.print(n+" ");
            }
        }
    }

    public static void main(String[]args){
        MultiGraph g = new MultiGraph(8);
        g.addEdge(0,2);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(1,5);
        g.addEdge(1,5);
        g.addEdge(1,6);
        g.addEdge(2,0);
        g.addEdge(2,0);
        g.addEdge(2,1);
        g.addEdge(2,4);
        g.addEdge(3,0);
        g.addEdge(3,0);
        g.addEdge(3,7);
        g.addEdge(4,2);
        g.addEdge(4,6);
        g.addEdge(4,6);
        g.addEdge(5,1);
        g.addEdge(5,6);
        g.addEdge(5,6);
        g.addEdge(6,1);
        g.addEdge(6,4);
        g.addEdge(6,4);
        g.addEdge(6,5);
        g.addEdge(7,3);
        g.addEdge(7,3);

        System.out.println("Adjacency list before sorting");
        g.printAdjacencyList();
        g.BFS(0);

        System.out.println("\n\nAdjacency list after sorting");
        g.printNewAdjacencyList();

    }
}