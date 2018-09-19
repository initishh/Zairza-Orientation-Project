package com.example.initish.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    int chance=0;
    int score1=0;
    int score2=0;
    int check=1;
    int state[]={2,2,2,2,2,2,2,2,2};
    int winstates [][]= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};



    public void reset(View view)
    {

        LinearLayout layout = (LinearLayout) findViewById(R.id.playagain);
        layout.setVisibility(View.INVISIBLE);
        chance =0;
        check=1;
        for(int i=0; i<state.length;i++)
            state[i]=2;
        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid);
        for(int i=0; i<gridLayout.getChildCount();i++)
        {
            ImageView img= (ImageView)gridLayout.getChildAt(i);
            img.setImageResource(0);
        }
    }

    public void ingame(View view) {
        // true == tick   false == cross
        TextView player1=(TextView) findViewById(R.id.player1);
        TextView player2=(TextView) findViewById(R.id.player2);

        if (check<=9) {
            ImageView game = (ImageView) view;
            if (state[Integer.parseInt(String.valueOf(game.getTag()))] == 2) {


                state[Integer.parseInt(String.valueOf(game.getTag()))] = chance;
                if (chance == 0) {
                    game.setImageResource(R.drawable.tick);
                    chance = 1;
                } else {
                    game.setImageResource(R.drawable.cross);
                    chance = 0;
                }
                game.setScaleX(0f);
                game.setScaleY(0f);
                game.setRotation(0f);
                game.animate().rotation(360)
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(500);
            } else {
                check--;
                Toast.makeText(this, "box already filled !!!! ", Toast.LENGTH_SHORT).show();
            }

            for (int gamestate[] : winstates) {
                if (state[gamestate[0]] == state[gamestate[1]] && state[gamestate[1]] == state[gamestate[2]]
                        && state[gamestate[0]] != 2) {
                    TextView winnermessage = (TextView) findViewById(R.id.winnermessage);
                    if (state[gamestate[0]] == 0) {
                        Toast.makeText(this, "Player 1 striked player 2!!!!!", Toast.LENGTH_LONG).show();
                        winnermessage.setText("Player 1 won !!!!");
                        score1++;
                    } else {
                        Toast.makeText(this, "Player 2 circled Player 1!!!!!", Toast.LENGTH_LONG).show();
                        winnermessage.setText("Player 2 won !!!!");
                        score2++;
                    }
                    player1.setText("PLAYER 1 :"+ score1);
                    player2.setText("PLAYER 2 :"+ score2);
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playagain);
                    layout.setVisibility(View.VISIBLE);
                    check=11;
                }

            }

            check++;
            if(check==10) {
                LinearLayout layout = (LinearLayout) findViewById(R.id.playagain);
                TextView winnermessage =(TextView) findViewById(R.id.winnermessage);
                winnermessage.setText("Match Draw !!!!");
                layout.setVisibility(View.VISIBLE);
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(this, "1st to play gets tick sign", Toast.LENGTH_LONG).show();

    }
}
