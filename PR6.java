import java.util.Scanner;

public class PR6 {
    private int[] dist;
    private int V;
    public static final int INF = 999;

    public Ford(int V) {
        this.V = V;
        dist = new int[V + 1];
    }

    public void bellmanFord(int source, int[][] graph) {
        for (int i = 1; i <= V; i++) dist[i] = INF;
        dist[source] = 0;

        for (int i = 1; i <= V - 1; i++) {
            for (int u = 1; u <= V; u++) {
                for (int v = 1; v <= V; v++) {
                    if (graph[u][v] != INF && dist[u] != INF && dist[v] > dist[u] + graph[u][v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        // Negative cycle check
        for (int u = 1; u <= V; u++) {
            for (int v = 1; v <= V; v++) {
                if (graph[u][v] != INF && dist[u] != INF && dist[v] > dist[u] + graph[u][v]) {
                    System.out.println("Graph contains a negative edge cycle!");
                    return;
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            System.out.println("Distance from source " + source + " to " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        int[][] graph = new int[V + 1][V + 1];

        System.out.println("Enter adjacency matrix:");
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                graph[i][j] = sc.nextInt();
                if (i == j) graph[i][j] = 0;
                else if (graph[i][j] == 0) graph[i][j] = INF;
            }
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        Ford bf = new Ford(V);
        bf.bellmanFord(source, graph);
        sc.close();
    }
}
