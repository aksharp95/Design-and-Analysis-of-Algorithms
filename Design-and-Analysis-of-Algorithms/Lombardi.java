//Question 7

import java.util.*;

class Lombardi
{

    static void BFS(LinkedList<Integer>[] adjacency, int src,
                    int dist[], int paths[], int n)
    {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            visited[i] = false;
        dist[src] = 0;
        paths[src] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;
        while (!queue.isEmpty()){
            int curr = queue.peek();
            queue.poll();


            for (int x : adjacency[curr]){
                if (visited[x] == false)
                {
                    queue.add(x);
                    visited[x] = true;
                }

                if (dist[x] > dist[curr] + 1)
                {
                    dist[x] = dist[curr] + 1;
                    paths[x] = paths[curr];
                }else if (dist[x] == dist[curr] + 1)
                    paths[x] += paths[curr];
            }
        }
    }

    static void findShortestPaths(LinkedList<Integer> adjacency[],
                                  int s, int n){
        int[] dist = new int[n], paths = new int[n];

        for (int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
            paths[i] = 0;

        BFS(adjacency, s, dist, paths, n);

        System.out.print("Numbers of shortest paths from 0 to 7 are  "+paths[6]);
    }

    static void addEdge(LinkedList<Integer> adjacency[],
                        int u, int v){
        adjacency[u].add(v);
    }

    public static void main(String[] args)
    {
        int n = 8;

        LinkedList<Integer>[] adjacency = new LinkedList[n];
        for (int i = 0; i < n; i++)
            adjacency[i] = new LinkedList<>();

        addEdge(adjacency, 0, 2);
        addEdge(adjacency, 0, 3);
        addEdge(adjacency, 1, 2);
        addEdge(adjacency, 1, 5);
        addEdge(adjacency, 1, 6);
        addEdge(adjacency, 2, 0);
        addEdge(adjacency, 2, 1);
        addEdge(adjacency, 2, 4);
        addEdge(adjacency, 3, 0);
        addEdge(adjacency, 3, 7);
        addEdge(adjacency, 4, 6);
        addEdge(adjacency, 4, 2);
        addEdge(adjacency, 5, 6);
        addEdge(adjacency, 5, 1);
        addEdge(adjacency, 6, 1);
        addEdge(adjacency, 6, 4);
        addEdge(adjacency, 6, 5);
        addEdge(adjacency, 7, 3);
        findShortestPaths(adjacency, 0, n);
    }
}

//References: https://www.geeksforgeeks.org