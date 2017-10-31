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
        Log.d(TAG, "onCreate: Starting Mouth Puzzle Game.");

        Button backButton = (Button) findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClicked: Clicked backButton.");

                finish();   //kill Game Menu activity, back to Main Activity

                //back to Game Menu
                Intent intentBack3 = new Intent(Game3.this, GameMenu.class);
                startActivity(intentBack3);
            }
        });
    }
}
