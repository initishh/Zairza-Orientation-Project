package com.example.initish.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button button1,button2,button3,button4,button5,button6;

    public void click(View view){

        switch (Integer.parseInt(view.getTag().toString())){

            case 1:
                startActivity(new Intent(getApplicationContext(),Main3Activity.class));
                break;
            case 2:
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                break;
            case 3:
                startActivity(new Intent(getApplicationContext(), Main4Activity.class));
                break;
            case 4:
                startActivity(new Intent(getApplicationContext(), Main5Activity.class));
                break;
            case 5:
                startActivity(new Intent(getApplicationContext(), Main6Activity.class));
                break;
            case 6:
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
        }
        Log.i("Button Tapped", view.getTag().toString());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
    }
}
