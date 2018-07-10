package cz.jakubturcovsky.amounttowords;

public class PluralForms {

    private final String singularForm;
    private final String pluralForm;
    private final String genitivePluralForm;

    public PluralForms(String singularForm, String pluralForm, String genitivePluralForm) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genitivePluralForm = genitivePluralForm;
    }

    public String formFor(Integer value) {
        if (value == 1) {
            return singularForm;
        } else if (usePluralForm(value)) {
            return pluralForm;
        }
        return genitivePluralForm;
    }

    private boolean usePluralForm(Integer value) {
        int tens = value % 10;
        int hundreds = value % 100;
        return (tens >= 2 && tens <= 4) && !(hundreds >= 12 && hundreds <= 14);
    }
}