package com.test.fingerguessing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button playAgainBtn;
        TextView resutltv;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        playAgainBtn = (Button)findViewById(R.id.playAgainButton);
        playAgainBtn.setOnClickListener(this);
        resutltv = (TextView)findViewById(R.id.resultTextView);
        String winner = this.getIntent().getExtras().getString("winner");
        String res = this.getIntent().getExtras().getString("result");
        String mode = this.getIntent().getExtras().getString("mode");

        if (mode.equals("pvp")) {
            String uc = "";
            String win = "";
            int count = 0;
            for (String sub : res.split(";")) {
                count++;
                uc += " User" + count + "(" + sub + ") ";
            }
            if (!winner.equals("")) {
                for (String sub : winner.split(";")) {
                    win += " User" + sub;
                }
            }
            if (win.length() > 0) {
                resutltv.setText(uc + "\nWinners are:" + win);
            } else {
                resutltv.setText(uc + "\nThere is no winner");
            }
        }
        else if (mode.equals("pve")) {
            String uc = "";
            String win = "";

            String[] subs = res.split(";");
            uc = "User(" + subs[0] + ") AI(" + subs[1] + ")";

            if (winner.equals("1")) {
                win = "User";
            }
            else if (winner.equals("2")){
                win = "AI";
            }
            else {
                win = "";
            }
            if (win.length() > 0) {
                resutltv.setText(uc + "\nWinner is:" + win);
            } else {
                resutltv.setText(uc + "\nThere is no winner");
            }
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
