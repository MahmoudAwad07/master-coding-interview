package com.awadinhoo.code.mastercodinginterview.designgurus.codingpatterns.warmup;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainsDuplicateTest {

    @Test
    @DisplayName("Contains Duplicate v1 [1,2,3,4] return false")
    public void containsDuplicateTest1(){
        //assertEquals(true, ContainsDuplicateSolution.containsDuplicate_v1(new int[]{1,2,3,4}));
        assertFalse(ContainsDuplicateSolution.containsDuplicate_v1(new int[]{1,2,3,4}));
    }

    @Test
    @DisplayName("Contains Duplicate v1 [1,2,3,4,2] return true")
    public void containsDuplicateTest2(){
        assertTrue(ContainsDuplicateSolution.containsDuplicate_v1(new int[]{1,2,3,4,2}));
    }


    @Test
    @DisplayName("Contains Duplicate v2 [1,2,3,4] return false")
    public void containsDuplicateTest3(){
        assertFalse(ContainsDuplicateSolution.containsDuplicate_v2(new int[]{1,2,3,4}));
    }

    @Test
    @DisplayName("Contains Duplicate v2 [1,2,3,4,2] return true")
    public void containsDuplicateTest4(){
        assertTrue(ContainsDuplicateSolution.containsDuplicate_v2(new int[]{1,2,3,4,2}));
    }

}
