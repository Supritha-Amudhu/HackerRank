package com.matrix;

import java.util.List;
import java.util.ArrayList;

public class LongestIncresingPath {

    List<Integer> finalLongestPath;
    int rows, columns;
    int[][] matrix;

    LongestIncresingPath() {
        finalLongestPath = new ArrayList<>();
        matrix = new int[][]{
                {12,    -1,     18,     -1},
                {1,     16,     1,      22},
                {-1,    26,     25,     -1},
                {-1,    27,     -1,     -1},
                {1,     28,     30,     45}
        };
        rows = matrix.length;
        columns = matrix[0].length;
    }

    void findLongestIncreasingPath() {
        List<Integer> longestPath;
        int[][] visited;
        for(int row=0;row<rows;row++) {
            for(int column=0;column<columns;column++) {
                if(matrix[row][column] == -1) {
                    continue;
                }
                longestPath = new ArrayList<>();
                visited = getVisited();
                System.out.println(">>>>>>>>>>>>> Parent row and column:" +row + " " + column);
                System.out.println("Initial node: "+matrix[row][column]);
                longestIncreasingPath(row, column, visited, longestPath);
            }
        }

    }

    void longestIncreasingPath(int row, int column, int[][] visited, List<Integer> longestPath) {
        int currentValue = matrix[row][column];
        longestPath.add(currentValue);
        System.out.println("Longest path: "+longestPath);
        visited[row][column] = 1;
        if(longestPath.size() > finalLongestPath.size()) {
            finalLongestPath.clear();
            finalLongestPath.addAll(longestPath);
        }
        if(checkValid(row, column+1, currentValue, visited)) {
            System.out.println("The next value row "+(row) + " column "+(column+1) + " is greater than the current value: "+currentValue);
            longestIncreasingPath(row, column+1, visited, longestPath);
            visited[row][column+1] = 0;
        }
        if(checkValid(row, column-1, currentValue, visited)) {
            System.out.println("The next value row "+(row) + " column "+(column-1) + " is greater than the current value: "+currentValue);
            longestIncreasingPath(row, column-1, visited, longestPath);
            visited[row][column-1] = 0;
        }
        if(checkValid(row+1, column, currentValue, visited)) {
            System.out.println("The next value row "+(row+1) + " column "+(column) + " is greater than the current value: "+currentValue);
            longestIncreasingPath(row+1, column, visited, longestPath);
            visited[row+1][column] = 0;
        }
        if(checkValid(row-1, column, currentValue, visited)) {
            System.out.println("The next value row "+(row-1) + " column "+(column) + " is greater than the current value: "+currentValue);
            longestIncreasingPath(row-1, column, visited, longestPath);
            visited[row-1][column] = 0;
        }
        if(checkValid(row+1, column-1, currentValue, visited)) {
            System.out.println("The next value row "+(row+1) + " column "+(column-1) + " is greater than the current value: "+currentValue);
            longestIncreasingPath(row+1, column-1, visited, longestPath);
            visited[row+1][column-1] = 0;
        }
        if(checkValid(row+1, column+1, currentValue, visited)) {
            System.out.println("The next value row "+(row+1) + " column "+(column+1) + " is greater than the current value: "+currentValue);
            longestIncreasingPath(row+1, column+1, visited, longestPath);
            visited[row+1][column+1] = 0;
        }
        if(checkValid(row-1, column+1, currentValue, visited)) {
            System.out.println("The next value row "+(row-1) + " column "+(column+1) + " is greater than the current value: "+currentValue);
            longestIncreasingPath(row-1, column+1, visited, longestPath);
            visited[row-1][column+1] = 0;
        }
        if(checkValid(row-1, column-1, currentValue, visited)) {
            System.out.println("The next value row "+(row-1) + " column "+(column-1) + " is greater than the current value: "+currentValue);
            longestIncreasingPath(row-1, column-1, visited, longestPath);
            visited[row-1][column-1] = 0;
        }
        System.out.println("Removing the last element: "+longestPath.get(longestPath.size()-1));
        longestPath.remove(longestPath.size()-1);

    }

    boolean checkValid(int row, int column, int current, int[][] visited) {
        if((row >= 0 && row < rows) && (column >= 0 && column < columns) && visited[row][column] == 0) {
            int newValue = matrix[row][column];
            if(newValue != -1 && newValue > current) {
                return true;
            }
        }
        return false;
    }

    int[][] getVisited() {
        int[][] visited = {
                {0,     0,      0,      0},
                {0,     0,      0,      0},
                {0,     0,      0,      0},
                {0,     0,      0,      0},
                {0,     0,      0,      0},
        };
        return visited;
    }

    public static void main(String[] args) {
        LongestIncresingPath path = new LongestIncresingPath();
        path.findLongestIncreasingPath();
        System.out.println(path.finalLongestPath);
    }
}
