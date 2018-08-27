package com.example.whichnumberisbigger;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //instance variables for the widgets we need to
    //access programatically
    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private int score;
    private int leftNum;
    private int rightNum;

    public static final int MAX_NUM = 10000;
    public static final int MIN_NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        randomizeAndUpdateDisplay();
    }

    @SuppressLint("SetTextIl8n")
    private void randomizeAndUpdateDisplay() {
        //access the string resources using getResources()
        textViewScore.setText((String)getResources().getText(R.string.main_score) +score);
        randomizeNUmbers();
        buttonLeft.setText(String.valueOf(leftNum));
        buttonRight.setText(String.valueOf(rightNum));
        //todo set the button values

    }

    private void randomizeNUmbers() {
        //generate a random number for the left
        leftNum = generateNum();
        rightNum = generateNum();
        //generate a random number for the right
        //make sure leftnum and rightnum are not the same
        //
    }

    private int generateNum(){
         int range = MAX_NUM - MIN_NUM +1;
                 return MIN_NUM +(int)(Math.random() * range);
    }  

    private void wireWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.textview_main_score);
    }


    public void onLeftClick(View view){
        boolean checkAnswer = true;
    }
    public void onRightClick(View view) {
        boolean checkAnswer = false;
    }
    public void checkAnswer(boolean leftPressed) {
        String message;
        if (leftNum > rightNum && leftPressed || rightNum > leftNum && !leftPressed){
            score++;
            message = "Wow, what a star.";
        }
        else {
            score--;
            message = "Yikes, what a bummer.";
        }
        randomizeAndUpdateDisplay();
        Toast.makeText(this, "message" , Toast.LENGTH_SHORT).show();
    }


}
