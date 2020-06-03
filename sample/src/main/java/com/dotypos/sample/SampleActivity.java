package com.dotypos.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dotypos.amounttowords.MoneyConverter;

import java.math.BigDecimal;

public class SampleActivity
        extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        final EditText input = findViewById(R.id.input);
        Button convert = findViewById(R.id.convert);
        final TextView result = findViewById(R.id.result);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = input.getText().toString();
                try {
                    result.setText(MoneyConverter.POLISH_BANKING_MONEY_VALUE.asWords(new BigDecimal(number)));
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(SampleActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
