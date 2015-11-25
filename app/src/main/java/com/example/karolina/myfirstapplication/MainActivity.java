package com.example.karolina.myfirstapplication;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private Map<Integer, Integer> state = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        state.put(1, R.id.flowers);
        state.put(2,R.id.tree);
        state.put(3,R.id.water);
        state.put(4, R.id.cat);

        final MainActivity mainActivity = this;


        ImageButton imageButton = (ImageButton)this.findViewById(R.id.imageButton);


        imageButton.setOnClickListener(new View.OnClickListener() {

            private int counter = 1;
            private View imageView;

            @Override
            public void onClick(View v) {
                if(imageView != null){
                    AnimationDrawable background = (AnimationDrawable) imageView.getBackground();
                    background.stop();
                    imageView.setBackgroundColor(Color.WHITE);
                }

                imageView = mainActivity.findViewById(state.get(counter));

                counter++;
                if (counter > 4){
                    counter = 1;
                }

                imageView.setBackgroundResource(R.drawable.spin_animation);
                AnimationDrawable frameAnimation = (AnimationDrawable) imageView.getBackground();
                frameAnimation.start();


            }
        });


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        //    }
        //});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }
}

