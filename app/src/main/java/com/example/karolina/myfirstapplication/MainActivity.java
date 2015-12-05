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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private class Data{
        public Integer counter = 1;
        public View imageView;
    }


    private final Map<Integer, Integer> state = new HashMap<>();
    private final Map<Integer, Integer> answers = new HashMap<>();
    private Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainActivity mainActivity = this;
        data.imageView = mainActivity.findViewById(R.id.flowers);
        data.imageView.setBackgroundResource(R.drawable.spin_animation);
        AnimationDrawable frameAnimation = (AnimationDrawable) data.imageView.getBackground();
        frameAnimation.start();

        state.put(1, R.id.flowers);
        state.put(3, R.id.tree);
        state.put(2, R.id.water);
        state.put(4, R.id.cat);

        answers.put(1, R.id.imageButton);
        answers.put(2, R.id.imageButton3);
        answers.put(3, R.id.imageButton2);
        answers.put(4, R.id.imageButton4);

        final ImageButton imageButton = (ImageButton)this.findViewById(R.id.imageButton);
        ImageButton imageButton2 = (ImageButton)this.findViewById(R.id.imageButton2);
        ImageButton imageButton3 = (ImageButton)this.findViewById(R.id.imageButton3);
        ImageButton imageButton4 = (ImageButton)this.findViewById(R.id.imageButton4);

        ImageButton [] images = new ImageButton[4];
        for(int i=0; i<4; i++)
        {
            if(i==0)
            {
                images[i]=imageButton;
            }
            else if(i==1)
            {
                images[i]=imageButton2;
            }
            else if(i==2)
            {
                images[i]=imageButton3;
            }
            else if(i==3)
            {
                images[i]=imageButton4;
            }
        }

        View.OnClickListener clickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if(answers.get(data.counter) == v.getId())
                {
                    System.out.println("Poprawnie");
                    if(data.imageView != null)
                    {
                        AnimationDrawable background = (AnimationDrawable) data.imageView.getBackground();
                        background.stop();
                        data.imageView.setBackgroundColor(Color.WHITE);
                        data.imageView.setBackgroundResource(R.drawable.woda);


                    }

                    data.counter++;
                    if (data.counter > 4){
                        data.counter = 1;
                    }


                    data.imageView = mainActivity.findViewById(state.get(data.counter));


                    data.imageView.setBackgroundResource(R.drawable.spin_animation);
                    AnimationDrawable frameAnimation = (AnimationDrawable) data.imageView.getBackground();
                    frameAnimation.start();

                } else {
                    System.out.println("niepoprawnie");
                }





            }
        };

        imageButton.setOnClickListener(clickListener);
        imageButton2.setOnClickListener(clickListener);
        imageButton3.setOnClickListener(clickListener);
        imageButton4.setOnClickListener(clickListener);

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

