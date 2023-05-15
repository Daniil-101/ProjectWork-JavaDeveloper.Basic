package tests.fake;

import app.print.UserError;
import tests.spies.IOStreamServiceSpies;

public class UserErrorFake extends UserError {

    public String resultOfChecking = "";
    IOStreamServiceSpies ioStreamServiceSpies;

    private final String[][] userError = {{"Некорректный ввод.", "Число не входит в диапазон.",
            "Эта функция все еще находится в стадии разработки."},
            {"Попробуйте еще раз."}};

    public UserErrorFake(IOStreamServiceSpies ioStreamServiceSpies) {
        super();
        this.ioStreamServiceSpies = ioStreamServiceSpies;
    }

    public void printIncorrectInput() {
        ioStreamServiceSpies.outputStringWithWrap(userError[0][0] + " " + userError[1][0]);
        resultOfChecking = ioStreamServiceSpies.resultOfChecking;
    }

    public void printThisFeatureIsStillUnderDevelopment() {
        ioStreamServiceSpies.outputStringWithWrap(userError[0][2] + " " + userError[1][0]);
        resultOfChecking = ioStreamServiceSpies.resultOfChecking;
    }
}
