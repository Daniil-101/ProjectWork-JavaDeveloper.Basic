package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.spies.IOStreamServiceSpies;
import tests.fake.UserErrorFake;

import static org.junit.jupiter.api.Assertions.*;

class UserErrorTest {
    IOStreamServiceSpies ioStreamServiceSpies = new IOStreamServiceSpies();
    UserErrorFake userErrorFake;

    @BeforeEach
    void prepareData(){
        userErrorFake = new UserErrorFake(ioStreamServiceSpies);
    }

    @Test
    void printIncorrectInput() {
        userErrorFake.printIncorrectInput();
        assertEquals("Некорректный ввод. Попробуйте еще раз.\n", userErrorFake.resultOfChecking);
    }

    @Test
    void printThisFeatureIsStillUnderDevelopment() {
        userErrorFake.printThisFeatureIsStillUnderDevelopment();
        assertEquals("Эта функция все еще находится в стадии разработки. Попробуйте еще раз.\n",
                userErrorFake.resultOfChecking);
    }
}