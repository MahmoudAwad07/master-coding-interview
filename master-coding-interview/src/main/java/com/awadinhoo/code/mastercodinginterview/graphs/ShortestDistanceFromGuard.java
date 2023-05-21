package com.awadinhoo.code.mastercodinginterview.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ShortestDistanceFromGuard {


    public static int[][] findDistance(char matrix[][]) {

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] distanceMatrix = new int[rows][columns];
        Queue<Cell> cellsQueue = new ArrayDeque<>();
        Set<Cell> visited = new HashSet<>();


        for (int i = 0 ; i < rows ; i++){
            for (int j= 0 ; j < columns ; j++){

               distanceMatrix[i][j]  = -1;
               if(matrix[i][j] == 'G'){
                   distanceMatrix[i][j] = 0;
                   cellsQueue.add(new Cell(i,j,0));
               }

            }
        }

        while (!cellsQueue.isEmpty()){

            Cell currentCell = cellsQueue.remove();
            int row = currentCell.row;
            int column = currentCell.column;
            int dis = currentCell.distance;

            visited.add(currentCell);
            if(!isGuard(currentCell, matrix) && !isWall(currentCell, matrix) ){


            }
        }

        return distanceMatrix;
    }

    private static boolean isWall(Cell currentCell, char[][] matrix) {
        return matrix[currentCell.row][currentCell.column] == 'W';
    }

    private static boolean isGuard(Cell currentCell, char[][] matrix) {
        return matrix[currentCell.row][currentCell.column] == 'G';
    }

    private static class Cell{
        int row;
        int column;
        int distance;

        public Cell(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {


        char matrix[][] = { { 'O', 'O', 'O', 'O', 'G' },
                { 'O', 'W', 'W', 'O', 'O' },
                { 'O', 'O', 'O', 'W', 'O' },
                { 'G', 'W', 'W', 'W', 'O' },
                { 'O', 'O', 'O', 'O', 'G' } };

        findDistance(matrix);

    }
}
