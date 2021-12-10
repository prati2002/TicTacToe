package com.example.clone;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int p=0;
    int t=0;
    public void DropIn(View view){
        ImageView counter=(ImageView) view;
        //counter.getTag().toString();
        int tappedCounter=Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter]==2) {
            gameState[tappedCounter]=p;
            t++;
            counter.setVisibility(View.VISIBLE);
            if (p == 0) {
                counter.setImageResource(R.drawable.dot);
                p = 1;
            } else {
                counter.setImageResource(R.drawable.cir);
                p = 0;
            }
        }
        for(int[] winningPostion:win) {
            if ((gameState[winningPostion[0]] == gameState[winningPostion[1]] && gameState[winningPostion[1]] == gameState[winningPostion[2]] && gameState[winningPostion[0]] != 2) || t==9) {
                //winner
                TextView winnerMessage=(TextView) findViewById(R.id.winner);
                if(t==9){
                    winnerMessage.setText("Draw");
                }
                else {
                    if (p == 1) {
                        winnerMessage.setText("Player 1 won");
                    } else {
                        winnerMessage.setText("Player 2 won");
                    }
                }
                LinearLayout layout=(LinearLayout) findViewById(R.id.linear);
                if(layout.getVisibility()==View.INVISIBLE){
                    layout.setVisibility(View.VISIBLE);
                }
                ImageView grid=(ImageView) findViewById(R.id.Grid);
                ImageView counter1=(ImageView) findViewById(R.id.cir11);
                ImageView counter2=(ImageView) findViewById(R.id.cir12);
                ImageView counter3=(ImageView) findViewById(R.id.cir13);
                ImageView counter4=(ImageView) findViewById(R.id.cir21);
                ImageView counter5=(ImageView) findViewById(R.id.cir22);
                ImageView counter6=(ImageView) findViewById(R.id.cir23);
                ImageView counter7=(ImageView) findViewById(R.id.cir31);
                ImageView counter8=(ImageView) findViewById(R.id.cir32);
                ImageView counter9=(ImageView) findViewById(R.id.cir33);
                grid.setImageDrawable(null);
                counter1.setImageDrawable(null);
                counter2.setImageDrawable(null);
                counter3.setImageDrawable(null);
                counter4.setImageDrawable(null);
                counter5.setImageDrawable(null);
                counter6.setImageDrawable(null);
                counter7.setImageDrawable(null);
                counter8.setImageDrawable(null);
                counter9.setImageDrawable(null);
            }
        }
    }
    public void PlayAgain(View view){
        LinearLayout layout=(LinearLayout) findViewById(R.id.linear);
        if(layout.getVisibility()==View.VISIBLE) {
            layout.setVisibility(View.INVISIBLE);
        }
        for(int i=0;i<9;i++){
            gameState[i]=2;
        }
        ImageView grid=(ImageView) findViewById(R.id.Grid);
        grid.setImageResource(R.drawable.box);
        p=0;t=0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}