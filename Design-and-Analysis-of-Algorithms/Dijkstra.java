// Question 3 d

public class Dijkstra {
    int V;

    public Dijkstra(int v) {
        V = v;
    }

    public static void main(String [] a) {
        int graph[][] = new int[][] { { 0, 0, 1, 1, 0, 0, 0, 0},
                { 0, 0, 1, 0, 0, 1, 1, 0},
                { 1, 1, 0, 0, 1, 0, 0, 0},
                { 1, 0, 0, 0, 0, 0, 0, 1},
                { 0, 0, 1, 0, 0, 0, 1, 0},
                { 1, 0, 0, 0, 0, 0, 1, 0},
                { 0, 1, 0, 0, 1, 1, 0, 0},
                { 0, 0, 0, 1, 0, 0, 0, 0} };

        Dijkstra d = new Dijkstra(8);

        //Complexity is O(V^2)
        d.calculatePath(graph,0);

    }

    public int minimumDistance(int [] distance, Boolean [] visited) {
        int value = Integer.MAX_VALUE;
        int index = Integer.MIN_VALUE;

        for(int i=0;i<V;i++) {
            if(!visited[i] && distance[i]<value) {
                value = distance[i];
                index = i;
            }
        }
        return index;
    }

    public void calculatePath(int [][] graph, int source) {

        Boolean [] visited = new Boolean[V];
        int [] distance = new int[V];

        for(int i=0;i<V;i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        for(int count=0;count<V;count++) {

            int u = minimumDistance(distance,visited);
            visited[u] = true;

            for(int v=0;v<V;v++) {
                if(!visited[v] && graph[u][v]!=0 && distance[u]!=Integer.MAX_VALUE && distance[u]+graph[u][v]<distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }

        }

        printDistances(distance);
    }

    public void printDistances(int [] distance) {
        System.out.println("Shortest distance from vertex 0 to 5 is "+distance[5]);
    }
}

//References: https://www.geeksforgeeks.org