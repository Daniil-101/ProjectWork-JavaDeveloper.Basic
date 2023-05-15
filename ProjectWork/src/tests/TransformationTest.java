package tests;

import app.return_something.Transformation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransformationTest {

    static Transformation transformation;

    @BeforeAll
    static void prepareDate(){
        transformation = new Transformation();
    }

    @Test
    void testStringToNumberLong() {
        assertEquals(123456789123456789L, transformation.stringToNumberLong("123456789123456789"));
    }

    @Test
    void testStringToNumberByte() {
        assertEquals(54, transformation.stringToNumberByte("54"));
    }

    @Test
    void testRemoveTheFirstMinus1() {
        assertEquals("5643", transformation.removeTheFirstMinus("-5643"));
    }

    @Test
    void testRemoveTheFirstMinus2() {
        assertEquals("56-43", transformation.removeTheFirstMinus("-56-43"));
    }

    @Test
    void testRemoveTheFirstMinus3() {
        assertEquals("5643", transformation.removeTheFirstMinus("5643"));
    }

    @Test
    void testReplaceDotWithComma1() {
        assertEquals("vdfv,dfsv", transformation.replaceDotWithComma("vdfv.dfsv"));
    }

    @Test
    void testReplaceDotWithComma2() {
        assertEquals("vdfvdfsv", transformation.replaceDotWithComma("vdfvdfsv"));
    }
}