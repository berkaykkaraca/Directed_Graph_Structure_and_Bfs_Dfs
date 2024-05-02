class BFS {
    private Digraph graph;

    public BFS(Digraph graph) {
        this.graph = graph;
    }

    public void findCitiesWithinHops(String sourceCity, int maxHops) {
        int sourceIndex = graph.getIndex(sourceCity);
        if (sourceIndex == -1) {
            System.out.println("Source city not found.");
            return;
        }

        boolean[] visited = new boolean[graph.getIndex(sourceCity) + 1];

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(sourceIndex);
        visited[sourceIndex] = true;

        int hops = 0;

        while (!queue.isEmpty() && hops <= maxHops) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentCityIndex = queue.dequeue();
                System.out.print(graph.getCity(currentCityIndex) + " ");

                int[] neighbors = graph.getAdjacencyMatrix()[currentCityIndex];
                for (int j = 0; j < neighbors.length; j++) {
                    if (neighbors[j] == 1 && !visited[j]) {
                        queue.enqueue(j);
                        visited[j] = true;
                    }
                }
            }
            hops++;
        }
    }
}
