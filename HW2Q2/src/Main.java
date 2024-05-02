import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
public class Main {

    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
            System.out.print("Enter maze file name: ");
            String mazeFileName = reader.readLine();
            reader.close();

            char[][] maze = readMazeFromFile("src/"+mazeFileName);

            Graph graph = new Graph(maze);

            graph.solveMazeWithGraph();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    private static char[][] readMazeFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        line = reader.readLine();
        
        int numCols=0;
        LineNumberReader lnr = new LineNumberReader(reader);
        int numRows=lnr.getLineNumber();
        for(int i =0;i<line.length();i++) {
        	numRows++;
        	
        }
        char[][] maze = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            line = reader.readLine();
            for (int j = 0; j < numCols; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

        reader.close();
        return maze;
    }
}
