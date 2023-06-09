package com.awadinhoo.code.mastercodinginterview.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {


    public static int numIslands(char[][] grid) {


        int rows = grid.length;
        int columns = grid[0].length;
        Set<String> visited = new HashSet<>();
        int numOfIslands = 0;

        for (int i = 0 ; i < rows ; i++){
            for(int j=0 ; j < columns ; j++){

                if(grid[i][j] == '1'){
                    exploreDFS(grid, i , rows, j, columns);
                    //exploreBFS(grid, i , rows, j, columns);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    private static void exploreDFS(char[][] grid, int i, int rows , int j, int columns) {

        if(i < 0 || j < 0 || i >= rows || j >= columns || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        exploreDFS(grid, i, rows, j+1, columns);
        exploreDFS(grid, i-1 , rows, j, columns);
        exploreDFS(grid, i+1 , rows , j , columns);
        exploreDFS(grid, i , rows , j-1, columns);
    }


    private static void exploreBFS(int[][] grid, int i, int rows , int j, int columns) {

        Queue<Cell> cells = new ArrayDeque<>();

        cells.add(new Cell(i,j));
        while (!cells.isEmpty()){

            Cell cell = cells.remove();
            int row = cell.row;
            int column = cell.column;

            if(row < 0 || column < 0 || row >= rows || column >= columns || grid[row][column] == '0'){
                continue;
            }

            grid[row][column] = '0';
            cells.add(new Cell(row, column +1));
            cells.add(new Cell(row, column - 1));
            cells.add(new Cell(row -1 , column));
            cells.add(new Cell(row +1, column));

        }
    }


    private static class Cell{
        int row ;
        int column;

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args) {

//  grid = [
//      ["1","1","1","1","0"],
//      ["1","1","0","1","0"],
//      ["1","1","0","0","0"],
//      ["0","0","0","0","0"]
//      ]

        char[][] grid = new char[4][5];
        char[] row1 = new char[]{'1','1','1','1','0'};
        char[] row2 = new char[]{'1','1','0','1','0'};
        char[] row3 = new char[]{'1','1','0','0','0'};
        char[] row4 = new char[]{'0','0','0','0','0'};

        grid[0] = row1;
        grid[1] = row2;
        grid[2] = row3;
        grid[3] = row4;

        System.out.println(numIslands(grid));


//  grid = [
//      ["1","1","0","0","0"],
//      ["1","1","0","0","0"],
//      ["0","0","1","0","0"],
//      ["0","0","0","1","1"]
//  ]
        char[][] grid2 = new char[4][5];
        char[] row10 = new char[]{'1','1','0','0','0'};
        char[] row11 = new char[]{'1','1','0','0','0'};
        char[] row12 = new char[]{'0','0','1','0','0'};
        char[] row13 = new char[]{'0','0','0','1','1'};

        grid2[0] = row10;
        grid2[1] = row11;
        grid2[2] = row12;
        grid2[3] = row13;

        System.out.println(numIslands(grid2));


    }
}
