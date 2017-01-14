package com.test.fingerguessing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/12/13.
 */
public class PlayActivity extends Activity implements View.OnClickListener {
    static public String Rock = "Rock";
    static public String Paper = "Paper";
    static public String Scissors = "Scissors";

    int pnum;
    int turn;
    String mode;
    List<String> guess;
    StringBuilder result;
    Button rockButton, paperButton, scissorsButton;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guess = new ArrayList<>();
        result = new StringBuilder();

        text = (TextView)findViewById(R.id.textView);
        rockButton = (Button)findViewById(R.id.rockButton);
        paperButton = (Button)findViewById(R.id.paperButton);
        scissorsButton = (Button)findViewById(R.id.scissorsButton);

        rockButton.setOnClickListener(this);
        paperButton.setOnClickListener(this);
        scissorsButton.setOnClickListener(this);

        mode = getIntent().getExtras().getString("mode");
        if (mode.equals("pvp")) {
            pnum = getIntent().getExtras().getInt("playerNum");
        }
        else if (mode.equals("pve")) {
            pnum = 2;
        }
        turn = 0;

        text.setText("User" + String.valueOf(turn + 1) + "'s turn to choose");
    }

    @Override
    public void onClick(View v) {
        if (v == rockButton) {
            guess.add(Rock);
            if (!result.toString().equals("")) {
                result.append((";" + Rock));
            }
            else {
                result.append(Rock);
            }
        }
        else if (v == paperButton) {
            guess.add(Paper);
            if (!result.toString().equals("")) {
                result.append((";" + Paper));
            }
            else {
                result.append(Paper);
            }
        }
        else if (v == scissorsButton) {
            guess.add(Scissors);
            if (!result.toString().equals("")) {
                result.append((";" + Scissors));
            }
            else {
                result.append(Scissors);
            }
        }

        if (mode.equals("pve")) {
            String ai = AI.intelligentGuess();
            AI.train(guess.get(0), ai);
            guess.add(ai);
            if (!result.toString().equals("")) {
                result.append((";" + ai));
            }
            else {
                result.append(ai);
            }
            turn++;
        }

        turn++;
        if (turn < pnum) {
            text.setText("User" + String.valueOf(turn + 1) + "'s turn to choose");
        }
        else {
            String winner = Judge.judge(guess);
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("winner", winner);
            i.putExtra("result", result.toString());
            i.putExtra("mode", mode);
            startActivity(i);
        }
    }
}
