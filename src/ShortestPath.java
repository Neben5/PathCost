package src;

class ShortestPath {
	ShortestPath(int V) {
		this.V = V;
	}

	int V = 9;
	/**
	 * Gets the closest vertex not yet examined
	 * @param dist array of distances of each node 
	 * @param sptSet array of which nodes have been examined
	 * @return closest node in sptSet
	 */
	int minDistance(int dist[], Boolean sptSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}
	/**
	 * Implement's dijkstra's algorith, gets each node's distance from node 0.
	 * @param graph adjacency matrix of nodes and their costs
	 * @param src starting node
	 * @param target target node
	 */
	void dijkstra(int graph[][], int src, int target) {
		int dist[] = new int[V]; // The output array. dist[i] will hold
		// the shortest distance from src to i

		// sptSet[i] will true if vertex i is included in shortest
		// path tree or shortest distance from src to i is finalized
		Boolean sptSet[] = new Boolean[V];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, sptSet);

			sptSet[u] = true;

			for (int v = 0; v < V; v++) {
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}

		System.out.println(dist[target - 1]);
	}
}