package com.test.fingerguessing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by dell on 2016/12/13.
 */
public class PlayerChooseActivity extends Activity implements View.OnClickListener {
    Button p2Button, p4Button, p6Button, backButton;
    int pnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_choose);

        p2Button = (Button)findViewById(R.id.cp2Button);
        p4Button = (Button)findViewById(R.id.cp4Button);
        p6Button = (Button)findViewById(R.id.cp6Button);
        pnum = 0;
        backButton = (Button)findViewById(R.id.cpCancelButton);

        p2Button.setOnClickListener(this);
        p4Button.setOnClickListener(this);
        p6Button.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == backButton) {
            startActivity(new Intent(this, MainActivity.class));
            return;
        }
        if (v == p2Button) {
            pnum = 2;
        }
        else if (v == p4Button) {
            pnum = 4;
        }
        else if (v == p6Button) {
            pnum = 6;
        }
        Intent i = new Intent(this, PlayActivity.class);
        i.putExtra("mode", "pvp");
        i.putExtra("playerNum", pnum);
        startActivity(i);
    }
}
