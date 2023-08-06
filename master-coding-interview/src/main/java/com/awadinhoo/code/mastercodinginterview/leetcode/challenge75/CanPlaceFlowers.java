package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        // case1 : [1,0,0,0,1] , n = 1 --> true
        // case2 : [1,0,0,0,1] , n = 2 --> false
        // case3 : [1,1,0,0,1] , n = 1 --> false
        // case4 : [0,0,1,0,1] , n = 1 --> true
        // case5 : [1,0,0,0,0,1] , n = 2 --> false

        // Time complexity --> O(n)
        // Space Complexity --> o(1)

        int index = 0;
        while(index < flowerbed.length){

            int currentFlower = flowerbed[index];

            // is empty slot and can insert flower
            if(currentFlower == 0 && isValidSlot(index, flowerbed)){
                flowerbed[index] = 1;
                n--;
            }
            index++;
        }
        return n <= 0;
    }

    private static boolean isValidSlot(int index , int[] flowerbed){

        if(hasLeft(index) && hasRight(index, flowerbed)){
            return  flowerbed[index + 1] == 0 && flowerbed[index - 1] == 0;
        }else if(hasLeft(index)){
            return flowerbed[index - 1] == 0 ;
        }else if (hasRight(index, flowerbed)){
            return flowerbed[index + 1] == 0 ;
        }
        return true;
    }

    private static boolean hasLeft(int index){
        return index - 1 >= 0;
    }

    private static boolean hasRight(int index, int[] flowerbed){
        return index + 1 < flowerbed.length;
    }
    public static void main(String[] args) {

        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 1)); // true
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 2)); // false
        System.out.println(canPlaceFlowers(new int[] {1,1,0,0,1}, 1)); // false
        System.out.println(canPlaceFlowers(new int[] {0,0,1,0,1}, 1)); // true
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,0,1}, 2)); // false
        System.out.println(canPlaceFlowers(new int[] {0,0,1,0,0}, 1)); // true

    }
}
