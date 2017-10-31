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

public class GameMenu extends AppCompatActivity{

    private static final String TAG = "GameMenu"; //Controller Game Menu

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        Log.d(TAG, "onCreate: Starting Game Menu.");

        Button backButton = (Button) findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClicked: Clicked backButton.");

                finish();   //kill Game Menu activity, back to Main Activity

                //method move to Main Activity
                Intent intent = new Intent(GameMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button game1Button = (Button) findViewById(R.id.game1_button);
        Button game2Button = (Button) findViewById(R.id.game2_button);
        Button game3Button = (Button) findViewById(R.id.game3_button);

        game1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked game1Button.");

                finish();
                Intent intentGame1 = new Intent(GameMenu.this, Game1.class);
                startActivity(intentGame1);
            }
        });

        game2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked game2Button.");

                finish();
                Intent intentGame2 = new Intent(GameMenu.this, Game2.class);
                startActivity(intentGame2);
            }
        });

        game3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked game3Button.");

                finish();
                Intent intentGame3 = new Intent(GameMenu.this, Game3.class);
                startActivity(intentGame3);
            }
        });



    }
}
