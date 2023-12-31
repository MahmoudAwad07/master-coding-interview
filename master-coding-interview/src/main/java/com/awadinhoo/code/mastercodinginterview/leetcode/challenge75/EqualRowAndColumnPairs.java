package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {



    public static int equalPairs(int[][] grid) {

        // brute force solution
        // loop for each row and check it against each column
        // Time Complexity --> O(n^3)
        // Space Complexity --> O(1)

        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0 ;
        boolean match;

        for(int row = 0; row < rows; row++){
            for(int column = 0 ; column < columns ; column++){
                match = true;
                for (int i = 0 ; i < rows ; i++){
                    if(grid[row][i] != grid[i][column]){
                        match = false;
                        break;
                    }
                }

                if(match){
                    count++;
                }
            }
        }

        return count;
    }

    public static int equalPairs_enhanced(int[][] grid) {

        // more enhanced solution
        // transpose the matrix, ana check rows against rows
        // Time Complexity --> O(n^2)
        // Space Complexity --> O(n^2)

        int rows = grid.length;
        int columns = grid[0].length;
        int[][] transposedGrid = new int[columns][rows];
        int count = 0 ;

        // create the transposed matrix
        for(int row = 0; row < rows; row++){
            for(int column = 0 ; column < columns ; column++){
                transposedGrid[column][row] = grid[row][column];
            }
        }

        // check each row on the original matrix against each row on the transposed matrix
        // if equal increase the count
        for (int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){

                if(Arrays.equals(grid[i], transposedGrid[j])){
                    count++;
                }
            }
        }

        return count;
    }

    public static int equalPairs_enhanced_v2(int[][] grid) {

        // more enhanced solution
        // transpose the matrix, ana check rows against rows
        // Time Complexity --> O(n^2)
        // Space Complexity --> O(n^2)

        int rows = grid.length;
        int columns = grid[0].length;
        Map<String, Integer> rowsOccurrence= new HashMap<>();
        Map<String, Integer> columnsOccurrence= new HashMap<>();
        StringBuilder rowKey ;
        StringBuilder columnKey ;
        int count = 0;

        // create the hashed keys for rows and columns from the matrix
        for(int row = 0; row < rows; row++){
            rowKey = new StringBuilder();
            columnKey = new StringBuilder();

            for(int column = 0 ; column < columns; column++){
                rowKey.append(grid[row][column]);
                columnKey.append(grid[column][row]);

                if(column != columns - 1 ){
                    rowKey.append("_");
                    columnKey.append("_");
                }
            }
            rowsOccurrence.merge(rowKey.toString(),1 , Integer::sum);
            columnsOccurrence.merge(columnKey.toString(), 1 , Integer::sum);
        }

        // check if the hashed row exist in the hashed columns
        // if exist multiply the occurrence, as it can match more than once
        for(String rowString :rowsOccurrence.keySet()){
            if(columnsOccurrence.containsKey(rowString)){
                count+= rowsOccurrence.get(rowString) * columnsOccurrence.get(rowString);
            }
        }

        return count;
    }

    public static void main (String[] args) {

        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        int[][] grid2 = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};

        System.out.println(equalPairs(grid));
        System.out.println(equalPairs(grid2));

        System.out.println("********************************");

        System.out.println(equalPairs_enhanced(grid));
        System.out.println(equalPairs_enhanced(grid2));

        System.out.println("********************************");

        System.out.println(equalPairs_enhanced_v2(grid));
        System.out.println(equalPairs_enhanced_v2(grid2));

    }
}
