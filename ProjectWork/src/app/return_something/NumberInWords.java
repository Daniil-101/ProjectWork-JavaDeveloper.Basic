package app.return_something;

import app.input_output.IOStreamsService;

public class NumberInWords {
    private String[][] units = {
            {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"}};

    private String[] str10 = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят",
            "восемьдесят", "девяносто"};

    private String[] str11 = {"", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать"};

    private String[] str100 = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот",
            "девятьсот"};

    private String[][] arrayThousandExponent = {
            {"квадролион", "квадролиона", "квадралионов"},
            {"триллион", "триллиона", "триллионов"},
            {"миллиард", "миллиарда", "миллиардов"},
            {"миллион", "миллиона", "миллионов"},
            {"тысяча", "тысячи", "тысяч"},
            {"", "", ""}
    };

    private IOStreamsService ioStreamsService;
    private Separation separation;
    private FormQualifier formQualifier;
    private CheckUp checkUp;


    public int getArrayLengthThousandExponent() {
        return arrayThousandExponent.length;
    }

    public NumberInWords(IOStreamsService ioStreamsService, Separation separation,
                         CheckUp checkUp, FormQualifier formQualifier) {
        this.ioStreamsService = ioStreamsService;
        this.separation = separation;
        this.formQualifier = formQualifier;
        this.checkUp = checkUp;
    }

    private String threeDigitNumberInWords(int thousandExponent, int number) {
        String numberInWords = "";

        byte row = 0;
        byte one = separation.firstNumberOfThreeDigitSegment(number);
        byte two = separation.secondNumberOfThreeDigitSegment(number);
        byte three = separation.thirdNumberOfThreeDigitSegment(number);
        byte twoAndThree = separation.secondAndThirdNumberOfThreeDigitSegment(number);

        if (thousandExponent == getArrayLengthThousandExponent() - 2) {
            row = 1;
        }
        if (number > 99 && twoAndThree == 0) {
            numberInWords += str100[one];
        } else {
            numberInWords += str100[one] + " ";
        }
        if (twoAndThree > 20) {
            numberInWords += str10[two] + " " + units[row][three];
        } else if (twoAndThree > 0 && twoAndThree <= 20) {
            if (twoAndThree > 9) {
                numberInWords += str11[twoAndThree - 9];
            } else {
                numberInWords += units[row][three];
            }
        }
        return numberInWords.toUpperCase();
    }

    public String run(long userNumber) {
        int[] arrayThreeDigitSegment = separation.divideANumberIntoAThreeDigitSegment(userNumber);
        String numberToText = "";

        if (checkUp.lessThanAThousand(userNumber)) {
            numberToText += threeDigitNumberInWords(getArrayLengthThousandExponent() - 1, (int) userNumber);
        } else {
            for (int i = 0; i < arrayThreeDigitSegment.length; i++) {
                byte twoAndThree = separation.secondAndThirdNumberOfThreeDigitSegment(arrayThreeDigitSegment[i]);
                byte formQualifier = this.formQualifier.getDeterminantOfTheWordForm(twoAndThree);

                if (arrayThreeDigitSegment[i] != 0) {
                    numberToText += ioStreamsService.getOutputStringFormat("%s %s ",
                            (threeDigitNumberInWords(i, arrayThreeDigitSegment[i])).toUpperCase(),
                            arrayThousandExponent[i][formQualifier]);
                }
            }
        }
        return numberToText.trim();
    }
}
