package app.print;

import app.input_output.IOStreamsService;

public class UserError {
    private IOStreamsService ioStreamsService;
    private final String[][] userError = {{"Некорректный ввод.", "Число не входит в диапазон.",
            "Эта функция все еще находится в стадии разработки."},
            {"Попробуйте еще раз."}};

    public UserError(){};
    public UserError(IOStreamsService ioStreamsService) {
        this.ioStreamsService = ioStreamsService;
    }

    public void printIncorrectInput() {
        ioStreamsService.outputStringWithWrap(userError[0][0] + " " + userError[1][0]);
    }

    public void printThisFeatureIsStillUnderDevelopment() {
        ioStreamsService.outputStringWithWrap(userError[0][2] + " " + userError[1][0]);
    }

}
