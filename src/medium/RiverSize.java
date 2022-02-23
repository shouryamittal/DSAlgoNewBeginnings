package medium;
import java.util.*;

/**
 * Q: Given a matrix of size m*n. It only contains 0 and 1. 1's signify river, 0 signifiy land. You have to calculate all river sizes.
 * For each 1, we can look at 4 of its neightbors, up, down, left, right.
 */
public class RiverSize {
    //method: This is graph traversal problem as we need to traverse the neighbors. For each node in matrix, we would also have visited array.
    // if a node is visited once, we wont count it again in any river.
    // Time: O(mn) ~ O(N), where N is total elements in matrix.
    // Space: O(mn) ~ O(N).
    static int[] findRiverSize(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int visited [][] = new int[row][col];
        ArrayList<Integer> sizes = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0 ; j < col; j++) {

                if(visited[i][j] == 1) {
                    continue;
                }
                RiverSize.traverseElement(i, j, matrix, visited, sizes);
            }
        }

        int size = sizes.size();
        int riverSizes [] = new int[size];
        int i = 0;
        Iterator<Integer> itr = sizes.iterator();
        while(itr.hasNext()) {
            int ele = (int)itr.next();
            riverSizes[i] = ele;
            i++;
        }
        return riverSizes;
    }

    static void traverseElement(int i,int j, int [][]matrix, int [][]visited, ArrayList<Integer> sizes) {
        int riverCount = 0;
        LinkedList<ArrayList> nodesToExplore = new LinkedList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(i);
        indexes.add(j);
        nodesToExplore.addLast(indexes);
        while(!nodesToExplore.isEmpty()) {
            ArrayList<Integer> indexEntry = nodesToExplore.removeFirst();
            int row = indexEntry.get(0);
            int col = indexEntry.get(1);
            System.out.println("i = " + row +", j = " + col  + ", visited[i][j] = " + visited[row][col]);
            if (visited[row][col] == 1) {
                continue;
            }
            visited[row][col] = 1;
            if (matrix[row][col] == 0) {
                continue;
            }
            riverCount += 1;
            ArrayList<ArrayList<Integer>> neighbors = getAllUnvisitedNeighbors(row, col, matrix, visited);

            Iterator itr = neighbors.iterator();
            while (itr.hasNext()) {
                ArrayList<Integer> ind = (ArrayList<Integer>) itr.next();
                nodesToExplore.addLast(ind);
            }
        }
        if (riverCount > 0) {
            sizes.add(riverCount);
        }
    }

    static ArrayList<ArrayList<Integer>> getAllUnvisitedNeighbors(int i, int j, int[][]matrix, int [][]visited) {
        ArrayList<ArrayList<Integer>> neighbors = new ArrayList<>();


        if(i > 0 && visited[i-1][j] == 0) {
            ArrayList<Integer> indexes = new ArrayList<>();
            indexes.add(i-1);
            indexes.add(j);
            neighbors.add(indexes);
        }
        if(i < matrix.length - 1 && visited[i+1][j] == 0) {
            ArrayList<Integer> indexes = new ArrayList<>();
            indexes.add(i+1);
            indexes.add(j);
            neighbors.add(indexes);
        }
        if(j > 0 && visited[i][j-1] == 0) {
            ArrayList<Integer> indexes = new ArrayList<>();
            indexes.add(i);
            indexes.add(j-1);
            neighbors.add(indexes);
        }
        if(j < matrix[0].length -1 && visited[i][j+1] == 0) {
            ArrayList<Integer> indexes = new ArrayList<>();
            indexes.add(i);
            indexes.add(j+1);
            neighbors.add(indexes);
        }
        return neighbors;
    }
    public static void main(String[] args) {
        RiverSize r = new RiverSize();
        int matrix [][]= {{1,0,0,1,0},{1,0,1,0,0},{0,0,1,0,1},{1,0,1,0,1},{1,0,1,1,0}};
        int riverSizes [] = r.findRiverSize(matrix);
        for(int ele: riverSizes) {
            System.out.println(ele);
        }
    }
}
