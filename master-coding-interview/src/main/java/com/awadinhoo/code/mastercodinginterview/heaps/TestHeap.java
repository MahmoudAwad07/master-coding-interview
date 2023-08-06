package com.awadinhoo.code.mastercodinginterview.heaps;

public class TestHeap {

    public static void main(String[] args) {

        //   0   1   2   3   4   5   6   7   8   9
        //  15   14  10  5   7   0   0   0   0   0
        //             15
        //        14         10
        //      5   7

        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(7);
        heap.insert(15);
        System.out.println(heap);
        heap.insert(5);
        heap.insert(14);
        heap.insert(22);
        System.out.println(heap);
        heap.remove();
        System.out.println(heap.size());
        System.out.println(heap);

    }
}
