package app.return_something;

import app.Interfaces.Converting;

public class Transformation implements Converting {

    public long stringToNumberLong(String text) {
        return Long.parseLong(text);
    }

    public byte stringToNumberByte(String text) {
        return Byte.parseByte(text);
    }

    public String removeTheFirstMinus(String text) {
        return text.replaceFirst("-", "");
    }

    public String replaceDotWithComma(String text) {
        return text.replaceFirst("\\.", ",");
    }
}
