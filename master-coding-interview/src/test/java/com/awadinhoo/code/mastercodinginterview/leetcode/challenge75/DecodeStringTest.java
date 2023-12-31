package com.awadinhoo.code.mastercodinginterview.leetcode.challenge75;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DecodeStringTest {

    @Test
    @DisplayName("Decode String '3[a]2[bc]' should return 'aaabcbc' ")
    public void decodeStringTest1(){
        DecodeString decodeString = new DecodeString();
        assertEquals("aaabcbc",decodeString.decodeString("3[a]2[bc]"));
    }

    @Test
    @DisplayName("Decode String '3[a2[c]]' should return 'accaccacc' ")
    public void decodeStringTest2(){
        DecodeString decodeString = new DecodeString();
        assertEquals("accaccacc",decodeString.decodeString("3[a2[c]]"));
    }
  
}