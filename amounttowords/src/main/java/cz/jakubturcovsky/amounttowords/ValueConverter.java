package cz.jakubturcovsky.amounttowords;

import static cz.jakubturcovsky.amounttowords.Container.polishContainer;

public enum ValueConverter {

    POLISH_INTEGER(polishContainer().getNumbersConverter());

    private final IntegerToStringConverter converter;

    ValueConverter(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        if (value == null) {
            return "";
        }

        return converter.asWords(value);
    }
}