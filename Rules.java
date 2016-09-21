package com.example.naghmeh.memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Rules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        TextView textHolder = (TextView) findViewById(R.id.rulesView);
        String theRules = getResources().getString(R.string.rules);
        textHolder.setText(theRules);


    }

}
