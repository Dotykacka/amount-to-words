package com.dotypos.amounttowords;

import java.util.List;
import java.util.Map;

public interface BaseValues {

    Map<Integer, String> baseNumbers();

    List<PluralForms> pluralForms();

    String currency();

    char twoDigitsNumberSeparator();
}
