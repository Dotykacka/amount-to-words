package com.dotypos.amounttowords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolishValues implements BaseValues {

    @Override
    public Map<Integer, String> baseNumbers() {
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(0, "zero");
        numbers.put(1, "jeden");
        numbers.put(2, "dwa");
        numbers.put(3, "trzy");
        numbers.put(4, "cztery");
        numbers.put(5, "pięć");
        numbers.put(6, "sześć");
        numbers.put(7, "siedem");
        numbers.put(8, "osiem");
        numbers.put(9, "dziewięć");
        numbers.put(10, "dziesięć");
        numbers.put(11, "jedenaście");
        numbers.put(12, "dwanaście");
        numbers.put(13, "trzynaście");
        numbers.put(14, "czternaście");
        numbers.put(15, "piętnaście");
        numbers.put(16, "szesnaście");
        numbers.put(17, "siedemnaście");
        numbers.put(18, "osiemnaście");
        numbers.put(19, "dziewiętnaście");
        numbers.put(20, "dwadzieścia");
        numbers.put(30, "trzydzieści");
        numbers.put(40, "czterdzieści");
        numbers.put(50, "pięćdziesiąt");
        numbers.put(60, "sześćdziesiąt");
        numbers.put(70, "siedemdziesiąt");
        numbers.put(80, "osiemdziesiąt");
        numbers.put(90, "dziewięćdziesiąt");
        numbers.put(100, "sto");
        numbers.put(200, "dwieście");
        numbers.put(300, "trzysta");
        numbers.put(400, "czterysta");
        numbers.put(500, "pięćset");
        numbers.put(600, "sześćset");
        numbers.put(700, "siedemset");
        numbers.put(800, "osiemset");
        numbers.put(900, "dziewięćset");

        return numbers;
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new PluralForms("", "", ""),
                new PluralForms("tysiąc", "tysiące", "tysięcy"),
                new PluralForms("milion", "miliony", "milionów"),
                new PluralForms("miliard", "miliardy", "miliardów"));
    }

    @Override
    public String currency() {
        return "PLN";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}