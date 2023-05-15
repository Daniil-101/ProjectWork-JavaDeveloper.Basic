package tests;

import app.return_something.FormQualifier;
import app.return_something.Separation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormQualifierTest {
    static Separation separation;
    static FormQualifier formQualifier;

    @BeforeAll
    static void prepareData(){
        separation = new Separation();
        formQualifier = new FormQualifier(separation);
    }

    @Test
    void testGetDeterminantOfTheWordForm0_1() {
        assertEquals(0,formQualifier.getDeterminantOfTheWordForm((byte) 1));
    }

    @Test
    void testGetDeterminantOfTheWordForm0_11() {
        assertNotEquals(0,formQualifier.getDeterminantOfTheWordForm((byte) 11));
    }

    @Test
    void testGetDeterminantOfTheWordForm1_3() {
        assertEquals(1,formQualifier.getDeterminantOfTheWordForm((byte) 3));
    }

    @Test
    void testGetDeterminantOfTheWordForm1_1() {
        assertNotEquals(1,formQualifier.getDeterminantOfTheWordForm((byte) 1));
    }

    @Test
    void testGetDeterminantOfTheWordForm1_5() {
        assertNotEquals(1,formQualifier.getDeterminantOfTheWordForm((byte) 5));
    }

    @Test
    void testGetDeterminantOfTheWordForm2_7() {
        assertEquals(2,formQualifier.getDeterminantOfTheWordForm((byte) 7));
    }

    @Test
    void testGetDeterminantOfTheWordForm2_15() {
        assertEquals(2,formQualifier.getDeterminantOfTheWordForm((byte) 15));
    }
}