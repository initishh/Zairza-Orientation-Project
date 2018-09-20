package com.example.initish.android;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
public class Main4Activity extends AppCompatActivity {
    SeekBar seekBar;
    TextView textView;
    Button button,stopButton;
    MediaPlayer mediaPlayer;
    Boolean counterisactive=false;
    CountDownTimer countDownTimer;
    ImageView egg,hatched;
    private int flag=0;
    @Override
    public void onBackPressed() {
        if(flag==1)
         mediaPlayer.stop();
        super.onBackPressed();
    }

    public void resetTimer(){
        flag=1;
        textView.setText("0:10");
        seekBar.setProgress(10);
        countDownTimer.cancel();
        button.setText("GO");
        counterisactive=false;

        stopButton.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.bong);
        mediaPlayer.start();
        flag=1;
        egg.setVisibility(View.GONE);
        hatched.setVisibility(View.VISIBLE);
    }
    public void stopTimer(View view){
        mediaPlayer.stop();
        egg.setVisibility(View.VISIBLE);
        hatched.setVisibility(View.INVISIBLE);
        seekBar.setEnabled(true);
        stopButton.setVisibility(View.GONE);
        button.setVisibility(View.VISIBLE);

    }
    public void controlTimer(View view) {
        if (counterisactive == false) {
            counterisactive = true;
            seekBar.setEnabled(false);
            button.setText("STOP");
            countDownTimer=new CountDownTimer(seekBar.getProgress() * 1000+100, 1000) {
                @Override
                public void onTick(long l) {
                    updateTimer((int) l / 1000);
                }
                @Override
                public void onFinish() {
                    resetTimer();


                }
            }.start();
        }
        else{
            resetTimer();
        }
    }
    public void updateTimer(int sec){
        int min=sec/60;
        int seconds=sec-min*60;
        String second=Integer.toString(seconds);
        String minute=Integer.toString(min);
        if(min<=9)
            minute="0"+minute;
        if(seconds<=9)
            second="0"+second;
        textView.setText(minute+":"+second);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Egg Timer");
        }

        seekBar=(SeekBar)findViewById(R.id.seekBar);
        egg=findViewById(R.id.egg);
        hatched=findViewById(R.id.hatched);
        textView=(TextView)findViewById(R.id.textView);
        stopButton=findViewById(R.id.stopButton);
        button=(Button)findViewById(R.id.button);
        seekBar.setMax(600);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b){
                updateTimer(i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


}
