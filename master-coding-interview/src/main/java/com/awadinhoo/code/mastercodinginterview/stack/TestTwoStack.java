package com.awadinhoo.code.mastercodinginterview.stack;

public class TestTwoStack {


    public static void main(String[] args) {
        TwoStack twoStack = new TwoStack();
        twoStack.push1(4);
        twoStack.push1(5);
        twoStack.push2(6);
        System.out.println(twoStack);
        System.out.println(twoStack.isFull1());
        System.out.println(twoStack.isFull2());
        System.out.println(twoStack);
        twoStack.push2(8);

        twoStack.push1(10);
        twoStack.push2(12);
        System.out.println(twoStack);

        System.out.println(twoStack.pop1());
        System.out.println(twoStack.pop2());
        System.out.println(twoStack);

        System.out.println(twoStack.isEmpty1());
        System.out.println(twoStack.isEmpty2());

        System.out.println(twoStack);
    }
}
