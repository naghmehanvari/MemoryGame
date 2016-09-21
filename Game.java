package com.example.naghmeh.memorygame;


import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Game extends AppCompatActivity {

    int turn = 0;
    Object[] tagStack = new Object[2];
    Stack<ImageButton> idStack = new Stack<ImageButton>();
    int scoreCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setImages();
    }
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("score", scoreCount + "");

    }
    public void setImages()
    {
        String imgName;
        String imgButtonName;

        ArrayList imgCount = new ArrayList<>();
        int count = 0;
        Integer counter = 1;
        for(int i = 1; i <= 2; i++)
        {
            for(; count < 10 * i; count++)
            {
                imgCount.add(counter);
                counter++;
            }
            counter = 1;
            count = 10;
        }

        Collections.shuffle(imgCount);

        for(int i = 1; i <= imgCount.size(); i++)
        {
            imgButtonName = "img"+ i;
            imgName = "img" + imgCount.get(i-1);
            int identifier = getResources().getIdentifier(imgName, "drawable", getPackageName());
            int id = getResources().getIdentifier(imgButtonName, "id", getPackageName());

            ImageButton ib = (ImageButton) findViewById(id);
            ib.setBackgroundResource(identifier);
            ib.setImageResource(android.R.color.white);
            ib.setTag(identifier);


        }

    }

    public void clicked(View view) throws InterruptedException {
        if(turn!= 2)
        {
            turn++;
            tagStack[turn - 1] = view.getTag();
            ImageButton ii = (ImageButton) findViewById(view.getId());


            ii.setImageResource(android.R.color.transparent);

            idStack.push(ii);

            if(turn == 2)
            {
                if(tagStack[0].equals(tagStack[1])) {

                    TextView score = (TextView) findViewById(R.id.scoreHolder);
                    scoreCount++;
                    score.setText(" " + scoreCount);
                    //ii.setForeground(draw);
                    ii.setImageResource(android.R.color.transparent);

                }
                else{
                    ImageButton first = idStack.pop();
                    first.setImageResource(android.R.color.white);
                    ImageButton second = idStack.pop();
                    second.setImageResource(android.R.color.white);

                }
                turn = 0;


            }
        }
        if (isGameOver()){
            Intent gameoverIntent = new Intent(this, Gameover.class);
            startActivity(gameoverIntent);
        }

    }

    public void Reset(View view) {
        turn = 0;
        scoreCount = 0;

        while(!idStack.isEmpty())
        {

            idStack.pop().setImageResource(android.R.color.white);
        }
        TextView score = (TextView) findViewById(R.id.scoreHolder);
        score.setText("");
        setImages();

    }
    public boolean isGameOver(){

        if(scoreCount == 10)
            return true;
        else
            return false;
    }
}
