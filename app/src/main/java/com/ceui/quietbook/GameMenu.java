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
        Log.d(TAG, "onCreate: Starting.");

        Button backButton = (Button) findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClicked: Clicked Back.");

                //finish();   //kill Game Menu activity, back to Main Activity

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

            }
        });

        game2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        game3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}
