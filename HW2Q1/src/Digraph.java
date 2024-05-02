public class Digraph
{
	private CityNode[] cities;
    private boolean[][] adjacencyMatrix;
    private int size;

    public Digraph(int maxSize) {
        this.cities = new CityNode[maxSize];
        this.adjacencyMatrix = new boolean[maxSize][maxSize];
        this.size = 0;
    }

    public void addEdge(String sourceCity, String destinationCity) {
        CityNode sourceNode = getOrCreateNode(sourceCity);
        CityNode destinationNode = getOrCreateNode(destinationCity);

        int sourceIndex = sourceNode.getIndex();
        int destinationIndex = destinationNode.getIndex();
        adjacencyMatrix[sourceIndex][destinationIndex] = true;
    }

    private CityNode getOrCreateNode(String cityName) {
        for (int i = 0; i < size; i++) {
            if (cities[i].getName().equals(cityName)) {
                return cities[i];
            }
        }
        CityNode newNode = new CityNode(cityName, size);
        cities[size] = newNode;
        size++;
        return newNode;
    }

    public void printGraph() {
        for (int i = 0; i < size; i++) {
            System.out.print(cities[i].getName() + " -> ");
            for (int j = 0; j < size; j++) {
                if (adjacencyMatrix[i][j]) {
                    System.out.print(cities[j].getName() + " ");
                }
            }
            System.out.println();
        }
}
    public void findRoutes(String sourceCity, int numHops) {
        CityNode sourceNode = findNodeByName(sourceCity);
        if (sourceNode != null) {
            int[] routesCount = {0}; // Counter for routes found
            System.out.println("Finding routes from " + sourceCity + " with " + numHops + " hops...");
            
            String[] currentRoute = new String[numHops + 1];
            currentRoute[0] = sourceCity;
            findRoutesDFS(sourceNode, numHops, 1, currentRoute, routesCount);

            // Print the number of routes found
            System.out.println("Total routes found: " + routesCount[0]);
        } else {
            System.out.println("Source city not found.");
        }
    }

    private void findRoutesDFS(
            CityNode currentNode, int numHops, int hopCount, String[] currentRoute, int[] routesCount) {
        if (hopCount > numHops) {
            printRoute(currentRoute);
            routesCount[0]++; // Increment the routes counter
            return;
        }

        int currentIndex = currentNode.getIndex();
        for (int i = size - 1; i >= 0; i--) {
            if (adjacencyMatrix[currentIndex][i]) {
                CityNode nextNode = cities[i];
                currentRoute[hopCount] = nextNode.getName();
                findRoutesDFS(nextNode, numHops, hopCount + 1, currentRoute, routesCount);
                currentRoute[hopCount] = null;
            }
        }
    }


    private void printRoute(String[] route) {
        int hops = 0;
        for (String city : route) {
            if (city != null) {
                hops++;
            }
        }

        System.out.print("Route (" + hops + " hops): ");
        for (String city : route) {
            if (city != null) {
                System.out.print(city + " ");
            }
        }
        System.out.println();
    }
    private CityNode findNodeByName(String cityName) {
        for (int i = 0; i < size; i++) {
            if (cities[i] != null && cities[i].getName().equals(cityName)) {
                return cities[i];
            }
        }
        return null;
    }
    } 
class CityNode {
    private String name;
    private int index;

    public CityNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}