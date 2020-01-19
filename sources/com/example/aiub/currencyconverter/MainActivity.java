package com.example.aiub.currencyconverter;

import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button button;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0272R.layout.activity_main);
        this.button = (Button) findViewById(C0272R.C0274id.buttonId);
    }

    public void CurrencyConverter(View view) {
        EditText editText = (EditText) findViewById(C0272R.C0274id.editTextId);
        Button button2 = (Button) findViewById(C0272R.C0274id.buttonId);
        TextView textViewDoller = (TextView) findViewById(C0272R.C0274id.textViewDollerId);
        TextView textViewRuppe = (TextView) findViewById(C0272R.C0274id.textViewRuppeId);
        TextView textViewEuro = (TextView) findViewById(C0272R.C0274id.textVieweuroId);
        TextView textViewPound = (TextView) findViewById(C0272R.C0274id.textViewpoundId);
        TextView textViewRiyal = (TextView) findViewById(C0272R.C0274id.textViewrialId);
        double editTexD = Double.parseDouble(editText.getText().toString());
        double doller = 0.012d * editTexD;
        StringBuilder sb = new StringBuilder();
        sb.append("Doller ");
        sb.append(doller);
        textViewDoller.setText(sb.toString());
        double ruppe = 0.84d * editTexD;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ruppe ");
        sb2.append(ruppe);
        textViewRuppe.setText(sb2.toString());
        EditText editText2 = editText;
        double euro = editTexD * 0.011d;
        StringBuilder sb3 = new StringBuilder();
        Button button3 = button2;
        sb3.append("Euro ");
        sb3.append(euro);
        textViewEuro.setText(sb3.toString());
        double d = euro;
        double pound = editTexD * 0.0088d;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Pound ");
        sb4.append(pound);
        textViewPound.setText(sb4.toString());
        double d2 = pound;
        double riyal = editTexD * 0.044d;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Riyal ");
        sb5.append(riyal);
        textViewRiyal.setText(sb5.toString());
    }

    public void onClick(View v) {
    }

    public void Abc(View view) {
    }
}
