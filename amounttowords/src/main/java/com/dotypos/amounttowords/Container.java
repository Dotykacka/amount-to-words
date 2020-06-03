package com.dotypos.amounttowords;

public final class Container {

    public static Container polishContainer() {
        return new Container(new PolishValues());
    }

    private final IntegerToStringConverter integerConverter;
    private final BigDecimalToStringConverter bigDecimalConverter;

    private Container(BaseValues baseValues) {
        HundredsToWordsConverter hundredsToStringConverter = new HundredsToWordsConverter(baseValues.baseNumbers(),
                baseValues.twoDigitsNumberSeparator());

        integerConverter = new IntegerToWordsConverter(hundredsToStringConverter, baseValues.pluralForms());
        bigDecimalConverter = new BigDecimalToBankingMoneyConverter(integerConverter, baseValues.currency());
    }

    private Container(IntegerToStringConverter integerConverter, BigDecimalToStringConverter bigDecimalConverter) {
        this.integerConverter = integerConverter;
        this.bigDecimalConverter = bigDecimalConverter;
    }

    public IntegerToStringConverter getNumbersConverter() {
        return integerConverter;
    }

    public BigDecimalToStringConverter getBankingMoneyConverter() {
        return bigDecimalConverter;
    }
}