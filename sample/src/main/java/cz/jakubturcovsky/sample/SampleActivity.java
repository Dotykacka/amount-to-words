package cz.jakubturcovsky.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.math.BigDecimal;

import cz.jakubturcovsky.amounttowords.MoneyConverter;

public class SampleActivity
        extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        TextView text = findViewById(R.id.text);
        text.setText(MoneyConverter.POLISH_BANKING_MONEY_VALUE.asWords(new BigDecimal("1234567.12")));
    }
}
