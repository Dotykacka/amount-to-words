package com.dotypos.amounttowords;

import java.math.BigDecimal;

public interface BigDecimalToStringConverter {
    String asWords(BigDecimal value);
}