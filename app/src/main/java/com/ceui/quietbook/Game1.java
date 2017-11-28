package com.ceui.quietbook;

import android.content.ClipData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Ibam on 24/10/2017.
 * Drag and Drop by Asri
 */

public class Game1 extends AppCompatActivity{

    ImageView shape01, shape02, shape03, shape04, shape05, shape06, shape07, shape08, shape09;
    LinearLayout place01, place02, place03, place04, place05, place06, place07, place08, place09;

    RelativeLayout left_layout;
    LinearLayout right_layout;

    int count = 9;

    private static final String TAG = "ToysCleanup";
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_1);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        Log.d(TAG, "onCreate: Starting Toys Cleanup Game.");

        /*Button backButton1 = (Button) findViewById(R.id.back_button);

        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClicked: Clicked backButton.");

                finish();   //kill Game Menu activity, back to Main Activity

                //back to Game Menu
                Intent intentBack = new Intent(Game1.this, GameMenu.class);
                startActivity(intentBack);
            }
        });*/

        shape01 = (ImageView) findViewById(R.id.shape01);
        shape02 = (ImageView) findViewById(R.id.shape02);
        shape03 = (ImageView) findViewById(R.id.shape03);
        shape04 = (ImageView) findViewById(R.id.shape04);
        shape05 = (ImageView) findViewById(R.id.shape05);
        shape06 = (ImageView) findViewById(R.id.shape06);
        shape07 = (ImageView) findViewById(R.id.shape07);
        shape08 = (ImageView) findViewById(R.id.shape08);
        shape09 = (ImageView) findViewById(R.id.shape09);

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

        shape01.setOnTouchListener(myTouchListener);
        shape02.setOnTouchListener(myTouchListener);
        shape03.setOnTouchListener(myTouchListener);
        shape04.setOnTouchListener(myTouchListener);
        shape05.setOnTouchListener(myTouchListener);
        shape06.setOnTouchListener(myTouchListener);
        shape07.setOnTouchListener(myTouchListener);
        shape08.setOnTouchListener(myTouchListener);
        shape09.setOnTouchListener(myTouchListener);

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
                Toast toast = Toast.makeText(getApplicationContext(), "no shape selected", Toast.LENGTH_SHORT);
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
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data,myShadowBuilder,view,0);
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
                    if ((startView == shape01 && view == place01) ||
                            (startView == shape02 && view == place02) ||
                            (startView == shape03 && view == place03) ||
                            (startView == shape04 && view == place04) ||
                            (startView == shape05 && view == place05) ||
                            (startView == shape06 && view == place06) ||
                            (startView == shape07 && view == place07) ||
                            (startView == shape08 && view == place08) ||
                            (startView == shape09 && view == place09))
                    {
                        View endView = (View) dragEvent.getLocalState();
                        ViewGroup owner = (ViewGroup) endView.getParent();
                        owner.removeView(endView);
                        LinearLayout container = (LinearLayout) view;
                        container.addView(endView);
                        layoutParams.setMargins(0,0,0,0);
                        endView.setLayoutParams(layoutParams);
                        endView.setVisibility(View.VISIBLE);
                        count--;
                        if(count == 0){
                            Toast toast = Toast.makeText(getApplicationContext(),"Yeay! All shape is found!",Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                        }
                        else{
                            Toast toast = Toast.makeText(getApplicationContext(),count + " shape(s) remaining",Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                        }
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(),"wrong place", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                        startView.setVisibility(View.VISIBLE);
                    }
                    return  true;
                //break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //view.invalidate();
                    if(!dragEvent.getResult()){
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
