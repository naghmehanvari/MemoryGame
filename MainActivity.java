package com.example.naghmeh.memorygame;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void displayRules(View view)
    {
        Intent rulesIntent = new Intent(this, Rules.class);
        startActivity(rulesIntent);
    }

    public void play(View view)
    {
        Intent gameIntent = new Intent(this, Game.class);
        startActivity(gameIntent);
    }


}
