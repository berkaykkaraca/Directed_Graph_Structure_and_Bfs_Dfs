import java.util.ArrayList;
import java.util.List;

class Graph {
    private int numberOfRows;
    private int numberOfCols;
    private char[][] maze;
    private boolean[][] adjecencyMatrix;
    public List<Character> route;
    private int count;
    private boolean[][] isVisited;

    public Graph(char[][] maze) {
        this.maze = maze;
        this.numberOfRows = maze.length;
        this.numberOfCols = maze[0].length;
        this.adjecencyMatrix = new boolean[numberOfCols][numberOfRows];
        this.count =0;
        route = new ArrayList<Character>();
        this.isVisited = new boolean[numberOfCols][numberOfRows];
        buildGraph();
    }

    private void buildGraph() {
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                if (maze[row][col] != '+'&&maze[row][col] != '|'&&maze[row][col] != '-') {
                    int currentNode = row * numberOfCols + col;

                    if (row - 1 >= 0 && maze[row - 1][col] != '+'&& maze[row - 1][col] != '|'&& maze[row - 1][col] != '-') {
                        int neighborNode = (row - 1) * numberOfCols + col;
                        adjecencyMatrix[currentNode][neighborNode]=true;
                        adjecencyMatrix[neighborNode][currentNode]=true;
                    }
                    if (row + 1 < numberOfRows && maze[row + 1][col] != '+'&& maze[row + 1][col] != '|'&& maze[row + 1][col] != '-') {
                        int neighborNode = (row + 1) * numberOfCols + col;
                        adjecencyMatrix[currentNode][neighborNode]=true;
                        adjecencyMatrix[neighborNode][currentNode]=true;

                    }
                    if (col - 1 >= 0 && maze[row][col - 1] != '+'&& maze[row][col - 1] != '|'&& maze[row][col - 1] != '-') {
                        int neighborNode = row * numberOfCols + col - 1;
                        adjecencyMatrix[currentNode][neighborNode]=true;
                        adjecencyMatrix[neighborNode][currentNode]=true;

                    }
                    if (col + 1 < numberOfCols && maze[row][col + 1] != '+'&& maze[row][col + 1] != '|'&& maze[row][col + 1] != '-') {
                        int neighborNode = row * numberOfCols + col + 1;
                        adjecencyMatrix[currentNode][neighborNode]=true;
                        adjecencyMatrix[neighborNode][currentNode]=true;

                    }
                }
            }
        }
    }
    public void solveMazeWithGraph() {
        

        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                if (maze[row][col] == 'a'||maze[row][col] == 'b'||maze[row][col] == 'c') {
                	
                    dfs(row, col);
                }
            }
        }
    }

    private void dfs(int row, int col) {
        
        int currentNode = row * numberOfCols + col;
        isVisited[row][col]=true;
        char cell = maze[row][col];
        if (cell == 'E') {
            for(int i =0;i<count;i++) {
            	System.out.println(route.get(i));
            }
           
            return;
        }

        
        for(int i =0;i<numberOfRows;i++) {
        	if(adjecencyMatrix[currentNode][i]&&!isVisited[currentNode][i]) {
        		int neighbor = i;
        		int neighborRow = neighbor / numberOfCols;
                int neighborCol = neighbor % numberOfCols;
                route.add(maze[currentNode][i]);
                count++;
                dfs(neighborRow, neighborCol);
                count--;
                route.remove(route.size()-1);
     
        	}
        }
        
    }

   
    
}


