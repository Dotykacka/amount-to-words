package cz.jakubturcovsky.amounttowords;

import android.util.SparseArray;

import java.util.List;

public interface BaseValues {

    SparseArray<String> baseNumbers();

    List<PluralForms> pluralForms();

    String currency();

    char twoDigitsNumberSeparator();
}
