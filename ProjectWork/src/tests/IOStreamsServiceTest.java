package tests;

import org.junit.jupiter.api.BeforeEach;
import tests.spies.IOStreamServiceSpies;

import static org.junit.jupiter.api.Assertions.*;

class IOStreamsServiceTest {
    IOStreamServiceSpies ioStreamServiceSpies;

    @BeforeEach
    void prepareData(){
        ioStreamServiceSpies = new IOStreamServiceSpies(9223372036854775807L,"Hello world");
    }

    @org.junit.jupiter.api.Test
    void testingOutputStringFormat() {
        ioStreamServiceSpies.outputString("Hello %s", "world");
        assertEquals("Hello world", ioStreamServiceSpies.resultOfChecking);
    }

    @org.junit.jupiter.api.Test
    void testGetOutputStringFormat() {
        assertEquals("Hello world", ioStreamServiceSpies.getOutputStringFormat("Hello %s", "world"));
    }

    @org.junit.jupiter.api.Test
    void testOutputStringMessage() {
        ioStreamServiceSpies.outputString("Hello world");
        assertEquals("Hello world", ioStreamServiceSpies.resultOfChecking);
    }

    @org.junit.jupiter.api.Test
    void testOutputStringWithWrap() {
        ioStreamServiceSpies.outputStringWithWrap("Hello world");
        assertEquals("Hello world\n", ioStreamServiceSpies.resultOfChecking);
    }

    @org.junit.jupiter.api.Test
    void testInputString() {
        assertEquals("Hello world", ioStreamServiceSpies.inputString());
    }

    @org.junit.jupiter.api.Test
    void testInputLong() {
        assertEquals(9223372036854775807L, ioStreamServiceSpies.inputLong());
    }


    @org.junit.jupiter.api.Test
    void outputArrayInt() {
        ioStreamServiceSpies.outputArrayInt(new int[]{1, 2, 3, 4});
        assertEquals("1\n" + "2\n" + "3\n" + "4\n", ioStreamServiceSpies.resultOfChecking);
    }

    @org.junit.jupiter.api.Test
    void outputArrayString() {
        ioStreamServiceSpies.outputArrayString(new String[]{"Hello", "world", ",", "my", "name", "is", "Duo"});
        assertEquals("Hello\n" + "world\n" + ",\n" + "my\n" + "name\n" + "is\n" +
                "Duo\n", ioStreamServiceSpies.resultOfChecking);
    }
}