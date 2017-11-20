package com.example.shajjad.convertcurrency;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextBDT, editTextResult;
    RadioButton radioButtonUSD, radioButtonCAD, radioButtonEUR;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBDT = (EditText) findViewById(R.id.editTextBDT);
        radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonUSD = (RadioButton) findViewById(R.id.radioButtonUSD);
        radioButtonCAD = (RadioButton) findViewById(R.id.radioButtonCAD);
        radioButtonEUR = (RadioButton) findViewById(R.id.radioButtonEUR);
        editTextResult = (EditText) findViewById(R.id.editTextResult);
    }

    public void convert(View view) {
        String tempInput = editTextBDT.getText().toString();

        if (tempInput.isEmpty()) {
            editTextBDT.setError("Enter an amount!");
        }

        else {
            Double input = Double.parseDouble(tempInput);

            if (radioButtonUSD.isChecked()) {
                Double result = input / 80;
                editTextResult.setText(String.valueOf(result));
            }

            if (radioButtonCAD.isChecked()) {
                Double result = input / 63;
                editTextResult.setText(String.valueOf(result));
            }
            if (radioButtonEUR.isChecked()) {
                Double result = input / 97;
                editTextResult.setText(String.valueOf(result));
            }
        }


    }

    public void clear(View view) {
        editTextResult.setText("");
        editTextBDT.setText("");
        radioGroup.clearCheck();
    }

    public  void test(){

    }

    public void viceVersa(View view) {
        String tempInput = editTextResult.getText().toString();

        if (tempInput.isEmpty()) {
            editTextResult.setError("Enter an amount!");
        } else {
            Double input = Double.parseDouble(tempInput);

            if (radioButtonUSD.isChecked()) {
                Double result = input * 80;
                editTextBDT.setText(String.valueOf(result));
            }

            if (radioButtonCAD.isChecked()) {
                Double result = input * 63;
                editTextBDT.setText(String.valueOf(result));
            }
            if (radioButtonEUR.isChecked()) {
                Double result = input * 97;
                editTextBDT.setText(String.valueOf(result));
            }
        }
    }
}
