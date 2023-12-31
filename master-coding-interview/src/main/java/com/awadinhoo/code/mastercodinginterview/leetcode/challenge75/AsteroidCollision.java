package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {


    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> asteroidsStack = new Stack<>();

        for (int i = 0 ; i < asteroids.length ; i++){

            int asteroid = asteroids[i];
            // if the stack is empty or the value is positive , we don't care
            // there will not be a collision, so we add the value to the stack
            if(asteroidsStack.isEmpty() || asteroid > 0){
                asteroidsStack.push(asteroid);
            }else {
                // if the value is negative and the stack is not empty and the top of the stack is positive
                // now the collision will happen, and needs to check which one will be exploded :)
                while ( !asteroidsStack.isEmpty() && asteroid < 0 && asteroidsStack.peek() > 0  ){

                    int diff = asteroid + asteroidsStack.peek();
                    // the asteroid on the top of the stack will be exploded
                    if(diff < 0){
                        asteroidsStack.pop();
                    // both asteroid will be exploded
                    }else if(diff == 0){
                        asteroidsStack.pop();
                        asteroid = 0 ;
                    // the asteroid will be exploded
                    }else {
                        asteroid = 0;
                    }
                }

                // if the asteroid is 0, it is already exploded :)
                if(asteroid != 0)
                    asteroidsStack.push(asteroid);
            }
        }

        int[] lastAsteroids = new int[asteroidsStack.size()];

        for(int i = lastAsteroids.length - 1 ; i >= 0 ; i --){
            lastAsteroids[i] = asteroidsStack.pop();
        }

        return lastAsteroids;

    }


    public static void main(String[] args){

        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8,-8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10,2,-5})));
    }
}
