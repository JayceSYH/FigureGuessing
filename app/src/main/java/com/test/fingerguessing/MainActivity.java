package com.test.fingerguessing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;


public class MainActivity extends Activity implements View.OnClickListener {

    Button pveButton, pvpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode_choose);

        try {
            PredictionEngine.initEngine(readTextFromSDcard(getResources().openRawResource(R.raw.openings)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        pveButton = (Button)findViewById(R.id.mode_pveButton);
        pvpButton = (Button)findViewById(R.id.mode_pvpButton);

        pveButton.setOnClickListener(this);
        pvpButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View buttonChosen) {
        //Handle click action and convert to another activity
        if (buttonChosen == pveButton) {
            Intent i = new Intent(this, PlayActivity.class);
            i.putExtra("mode", "pve");
            startActivity(i);
        }
        if (buttonChosen == pvpButton) {
            startActivity(new Intent(this, PlayerChooseActivity.class));
        }
    }

    private String readTextFromSDcard(InputStream is) throws Exception {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
            buffer.append("\n");
        }
        return buffer.toString();
    }

}
