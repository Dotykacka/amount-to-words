package com.dotypos.amounttowords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IntegerToWordsConverter implements IntegerToStringConverter {

    private final NumberChunking numberChunking = new NumberChunking();

    protected final IntegerToStringConverter hundredsToWordsConverter;
    private final List<PluralForms> pluralForms;

    public IntegerToWordsConverter(IntegerToStringConverter hundredsToWordsConverter, List<PluralForms> pluralForms) {
        this.hundredsToWordsConverter = hundredsToWordsConverter;
        this.pluralForms = pluralForms;
    }

    @Override
    public String asWords(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("can't convert negative numbers for value %d", value));
        }

        List<Integer> valueChunks = numberChunking.chunk(value);
        List<PluralForms> formsToUse = pluralForms.subList(0, valueChunks.size());
        Collections.reverse(formsToUse);

        return joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
    }

    protected String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        List<String> result = new ArrayList<>();

        while (chunks.hasNext() && formsToUse.hasNext()) {
            Integer currentChunkValue = chunks.next();
            PluralForms currentForms = formsToUse.next();

            if (currentChunkValue > 0) {
                result.add(hundredsToWordsConverter.asWords(currentChunkValue));
                result.add(currentForms.formFor(currentChunkValue));
            }
        }

        return joinParts(result);
    }

    protected String joinParts(List<String> result) {
        if (result.size() == 0) {
            return hundredsToWordsConverter.asWords(0);
        }

        StringBuilder builder = new StringBuilder();
        Iterator<String> iter = result.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
            if (iter.hasNext()) {
                builder.append(" ");
            }
        }
        return builder.toString().trim();
    }
}