package com.ceui.quietbook;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Ibam on 24/10/2017.
 */

public class Game3 extends AppCompatActivity {

    ImageView puzzle01, puzzle02, puzzle03, puzzle04, puzzle05, puzzle06, puzzle07, puzzle08, puzzle09;
    LinearLayout place01, place02, place03, place04, place05, place06, place07, place08, place09;

    RelativeLayout left_layout;
    LinearLayout right_layout;

    int count = 9;

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

        /*Button backButton3 = (Button) findViewById(R.id.back_button);

        backButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClicked: Clicked backButton.");

                finish();   //kill Game Menu activity, back to Main Activity

                //back to Game Menu
                Intent intentBack = new Intent(Game3.this, GameMenu.class);
                startActivity(intentBack);
            }
        });*/

        puzzle01 = (ImageView) findViewById(R.id.puzzle01);
        puzzle02 = (ImageView) findViewById(R.id.puzzle02);
        puzzle03 = (ImageView) findViewById(R.id.puzzle03);
        puzzle04 = (ImageView) findViewById(R.id.puzzle04);
        puzzle05 = (ImageView) findViewById(R.id.puzzle05);
        puzzle06 = (ImageView) findViewById(R.id.puzzle06);
        puzzle07 = (ImageView) findViewById(R.id.puzzle07);
        puzzle08 = (ImageView) findViewById(R.id.puzzle08);
        puzzle09 = (ImageView) findViewById(R.id.puzzle09);

        place01 = (LinearLayout) findViewById(R.id.place01_layout);
        place02 = (LinearLayout) findViewById(R.id.place02_layout);
        place03 = (LinearLayout) findViewById(R.id.place03_layout);
        place04 = (LinearLayout) findViewById(R.id.place04_layout);
        place05 = (LinearLayout) findViewById(R.id.place05_layout);
        place06 = (LinearLayout) findViewById(R.id.place06_layout);
        place07 = (LinearLayout) findViewById(R.id.place07_layout);
        place08 = (LinearLayout) findViewById(R.id.place08_layout);
        place09 = (LinearLayout) findViewById(R.id.place09_layout);

        left_layout = (RelativeLayout) findViewById(R.id.left_layout);
        right_layout = (LinearLayout) findViewById(R.id.right_layout);

        puzzle01.setOnTouchListener(myTouchListener);
        puzzle02.setOnTouchListener(myTouchListener);
        puzzle03.setOnTouchListener(myTouchListener);
        puzzle04.setOnTouchListener(myTouchListener);
        puzzle05.setOnTouchListener(myTouchListener);
        puzzle06.setOnTouchListener(myTouchListener);
        puzzle07.setOnTouchListener(myTouchListener);
        puzzle08.setOnTouchListener(myTouchListener);
        puzzle09.setOnTouchListener(myTouchListener);

        place01.setOnDragListener(myDragListener);
        place02.setOnDragListener(myDragListener);
        place03.setOnDragListener(myDragListener);
        place04.setOnDragListener(myDragListener);
        place05.setOnDragListener(myDragListener);
        place06.setOnDragListener(myDragListener);
        place07.setOnDragListener(myDragListener);
        place08.setOnDragListener(myDragListener);
        place09.setOnDragListener(myDragListener);

        left_layout.setOnTouchListener(frameTouchListener);
        right_layout.setOnTouchListener(frameTouchListener);
    }

    View.OnTouchListener frameTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                Toast toast = Toast.makeText(getApplicationContext(), "no puzzle selected", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return true;
            } else
                return false;
        }
    };

    View.OnTouchListener myTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, myShadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else
                return false;
        }
    };

    View.OnDragListener myDragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            View startView = (View) dragEvent.getLocalState();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            int action = dragEvent.getAction();
            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:
                    return true;
                //break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    return true;
                //break;
                case DragEvent.ACTION_DRAG_EXITED:
                    return true;
                //break;
                case DragEvent.ACTION_DROP:
                    //view.invalidate();
                    if ((startView == puzzle01 && view == place01) ||
                            (startView == puzzle02 && view == place02) ||
                            (startView == puzzle03 && view == place03) ||
                            (startView == puzzle04 && view == place04) ||
                            (startView == puzzle05 && view == place05) ||
                            (startView == puzzle06 && view == place06) ||
                            (startView == puzzle07 && view == place07) ||
                            (startView == puzzle08 && view == place08) ||
                            (startView == puzzle09 && view == place09)) {
                        View endView = (View) dragEvent.getLocalState();
                        ViewGroup owner = (ViewGroup) endView.getParent();
                        owner.removeView(endView);
                        LinearLayout container = (LinearLayout) view;
                        container.addView(endView);
                        layoutParams.setMargins(0, 0, 0, 0);
                        endView.setLayoutParams(layoutParams);
                        endView.setVisibility(View.VISIBLE);
                        count--;
                        if (count == 0) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Yeay! All puzzles are set at the place!", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            finish();

                            Intent intent = new Intent(Game3.this, GameMenu.class);
                            startActivity(intent);
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(), count + " puzzle(s) remaining", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        }
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "wrong place", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        startView.setVisibility(View.VISIBLE);
                    }
                    return true;
                //break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //view.invalidate();
                    if (!dragEvent.getResult()) {
                        startView.setVisibility(View.VISIBLE);
                    }
                    return true;
                //break;
                default:
                    break;
            }
            return false;

        }
    };
}
