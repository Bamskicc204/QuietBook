package com.ceui.quietbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ibam on 24/10/2017.
 */

public class Game3 extends AppCompatActivity{

    private static final String TAG = "MouthPuzzle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_3);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        Log.d(TAG, "onCreate: Starting Mouth Puzzle Game.");

        Button backButton3 = (Button) findViewById(R.id.back_button);

        backButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClicked: Clicked backButton.");

                finish();   //kill Game Menu activity, back to Main Activity

                //back to Game Menu
                Intent intentBack = new Intent(Game3.this, GameMenu.class);
                startActivity(intentBack);
            }
        });
    }
}
