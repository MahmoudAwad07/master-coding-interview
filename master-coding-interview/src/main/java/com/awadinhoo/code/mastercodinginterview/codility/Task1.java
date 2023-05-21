package com.awadinhoo.code.mastercodinginterview.codility;

import java.util.ArrayDeque;
import java.util.Queue;

public class Task1 {


    public String solution(int[][] A) {
        // Implement your solution here

        int rows = A.length;
        int columns = A[0].length;
        String path = "";

        for(int i =0 ; i < rows; i++){
            for (int j = 0 ; j < columns ; j++){

                path += exploreBFS(i, j , rows, columns, A);
            }
        }

        return path;
    }

    private String exploreBFS(int i , int j , int rows , int columns , int[][] A ){

        String path = "";
        Queue<Cell> cellsQueue = new ArrayDeque<>();

        cellsQueue.add(new Cell(i,j));

        while (!cellsQueue.isEmpty()){

            Cell currentCell = cellsQueue.remove();
            int row = currentCell.row;
            int column = currentCell.column;
            path += A[row][column];

//            int rightNode = if(column +1 >= columns) ? 0 : A[row][column+1];
//            int nextRight = A[row][column + 2];
//            int nextRightDown = A[row+1][j+1];
//            if( +  +   >
//                    A[row+1][j] + A[row+1][j+2] + A[row+2][j]  ){
//                cellsQueue.add(new Cell(row, column+1));
//            }

        }


        return "";
    }

    private class Cell {

        int row;
        int column;

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }



    public static void main(String[] args) {

        int matrix[][] = { { 9 , 9, 7 },
                { 9,7,2},
                { 6,9,5 },
                { 9,1,2 }};



    }
}
