package com.example.initish.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {

    public void convert(View view) {

        EditText dollarAmountEditText = (EditText) findViewById(R.id.dollarAmountEditText);
        Double dollarAmountDouble = Double.parseDouble(dollarAmountEditText.getText().toString());
        Double rupeeAmount = dollarAmountDouble * 71.97;
        Toast.makeText(Main7Activity.this,"Rs. " + rupeeAmount.toString(), Toast.LENGTH_SHORT).show();
        Log.i("amount",dollarAmountEditText.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
    }
}
