package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.twopointers;

public class TargetSumSolution {


    public static int[] search(int[] arr, int targetSum) {

        int leftIndex = 0;
        int rightIndex = arr.length -1;
        int currentSum = 0;
        int[] res = {-1,-1};

        while (leftIndex < rightIndex){

            currentSum = arr[leftIndex] + arr[rightIndex];

            if(currentSum == targetSum){
                res[0] = leftIndex;
                res[1] = rightIndex;
                break;
            }else if(currentSum > targetSum){
                rightIndex--;
            }else {
                leftIndex++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
