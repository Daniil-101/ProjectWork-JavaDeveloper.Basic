import app.*;
import app.currency.Currency;
import app.currency.Ruble;
import app.input_output.IOStreamsService;
import app.print.Request;
import app.print.UserError;
import app.return_something.*;

public class Main {
    public static void main(String[] args) {

        IOStreamsService ioService = new IOStreamsService(System.out, System.in);
        UserError userError = new UserError(ioService);
        Request request = new Request(ioService);
        Separation separation = new Separation();
        FormQualifier formQualifier = new FormQualifier(separation);
        Currency ruble = new Ruble(separation, formQualifier);
        CheckUp checkUp = new CheckUp(request);
        Transformation transformation = new Transformation();
        NumberInWords numberInWords = new NumberInWords(ioService, separation, checkUp, formQualifier);
        PriceInWords priceInWords = new PriceInWords(ioService, numberInWords,
                ruble, request, separation, transformation, checkUp, userError);
        priceInWords.run();
    }
}


