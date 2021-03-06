package com.example.android.rngfun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HeadsOrTailsFair extends AppCompatActivity {
    //Integers that will count the number of heals, tails, and totalNumberOfFlips number of flips
    int heads = 0;
    int tails = 0;
    int totalNumberOfFlips =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Gets rid of the window title
        this.requestWindowFeature(1);
        setContentView(R.layout.activity_heads_or_tails_fair);

        //Assigning textviews/imageviews and buttons to associated ids
        final TextView whichIsIt = (TextView) findViewById(R.id.heaers_or_tails);
        final TextView counter = (TextView) findViewById(R.id.title_of_rng_game);
        final ImageView decisionOfCoin = (ImageView) findViewById(R.id.decisionOfCoin);
        final Button headsOrNot = (Button) findViewById(R.id.random_winner);
        //Create an setOnClick for the hearts or tails button
        headsOrNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sets up the RNG
                double rand =Math.random();
                //Give it a range of 1 - 2
                rand = rand*2+1;
                //Cast it to make it only an integer
                int randomNumberCasted = (int) rand;
                //randomNumberCasted represents the random number and 1 will mean heads
                if(randomNumberCasted == 1){
                    //Update the text and image + increase the heads counter
                    whichIsIt.setText("Heads");
                    decisionOfCoin.setImageResource(R.drawable.headofcoin);
                    heads+=1;
                }
                //Otherwise the coin "shows" tails
                else{
                    //Will set the textView to show tails, update the tails picture, and finally increase the tails counter
                    whichIsIt.setText("Tails");
                    tails+=1;
                    decisionOfCoin.setImageResource(R.drawable.tailsofcoin);
                }
                //Increase the total number of flips and display the counter of each heads, tails, and total
                totalNumberOfFlips +=1;counter.setText("Heads or Tails? Total Tries: " + totalNumberOfFlips + '\n' + "Tails: " + tails + '\n' + "Heads: " + heads);

            }
        });
    }

}
