package com.dotypos.amounttowords;

import java.math.BigDecimal;

import static com.dotypos.amounttowords.Container.polishContainer;

public enum MoneyConverter {

    POLISH_BANKING_MONEY_VALUE(polishContainer().getBankingMoneyConverter());

    private final BigDecimalToStringConverter converter;

    MoneyConverter(BigDecimalToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(BigDecimal value) {
        if (value == null) {
            return "";
        }

        return converter.asWords(value);
    }
}