package com.dotypos.amounttowords;

import java.util.Map;

public class HundredsToWordsConverter implements IntegerToStringConverter {

    private final Map<Integer, String> baseValues;
    private final char twoDigitsNumberSeparator;

    public HundredsToWordsConverter(Map<Integer, String> baseValues, char twoDigitsNumberSeparator) {
        this.baseValues = baseValues;
        this.twoDigitsNumberSeparator = twoDigitsNumberSeparator;
    }

    @Override
    public String asWords(Integer value) {
        if (baseValues.get(value) != null) {
            return baseValues.get(value);
        } else if (value >= 21 && value <= 99) {
            return twoDigitsNumberAsString(value);
        } else if (value >= 101 && value <= 999) {
            return threeDigitsNumberAsString(value);
        }

        throw new IllegalArgumentException(String.format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value) {
        Integer units = value % 10;
        Integer tens = value - units;
        return String.format("%s%c%s", asWords(tens), twoDigitsNumberSeparator, asWords(units));
    }

    private String threeDigitsNumberAsString(Integer value) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        return String.format("%s %s", asWords(hundreds), asWords(tensWithUnits));
    }
}