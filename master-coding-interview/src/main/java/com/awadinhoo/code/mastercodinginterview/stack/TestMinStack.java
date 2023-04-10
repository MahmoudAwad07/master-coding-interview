package com.awadinhoo.code.mastercodinginterview.stack;

public class TestMinStack {


    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        System.out.println(minStack.getMin());
        System.out.println(minStack);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack);
        System.out.println(minStack.getMin());

        // ["MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"]
        // [[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]

        MinStack minStack2 = new MinStack();

        minStack2.push(-10); //[-10] // [-10]
        minStack2.push(14); //[-10, 14] // [-10,-10]
        System.out.println(minStack2.getMin()); // -10
        System.out.println(minStack2.getMin()); // -10
        minStack2.push(-20); //[-10, 14,-20] // [-10,-10,-20]
        System.out.println(minStack2.getMin()); // -20
        System.out.println(minStack2.top()); // -20
        System.out.println(minStack2.getMin()); // -20
        minStack2.pop(); //[-10, 14] // [-10,-10]
        minStack2.push(10); //[-10, 14, 10] // [-10,-10,-10]
        minStack2.push(-7); //[-10, 14, 10, -7] // [-10,-10,-10, -10]
        System.out.println(minStack2.getMin()); // -10
        minStack2.push(-7); //[-10, 14, 10, -7, -7] // [-10,-10,-10, -10,-10]
        minStack2.pop(); //[-10, 14, 10, -7] // [-10,-10,-10, -10]
        System.out.println(minStack2.top()); // -7
        System.out.println(minStack2.getMin()); // -10
        minStack2.pop();  //[-10, 14, 10] // [-10,-10,-10]


    }
}
