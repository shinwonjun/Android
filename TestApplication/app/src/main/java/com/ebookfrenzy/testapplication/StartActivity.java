package com.ebookfrenzy.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class StartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ImageView imgHomeView = (ImageView)findViewById(R.id.HomeImageView);
        if(imgHomeView == null) {
            Log.d("testLog", "imgHomeView = null");
        }
        Glide.with(this).load("http://cfile5.uf.tistory.com/image/2615BF4F52B3E5CF08532E").diskCacheStrategy(DiskCacheStrategy.ALL).into(imgHomeView);

        imgHomeView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("TestLog", " StartActivity _ 1");
                    IntentMainActivity();
                    Log.d("TestLog", " StartActivity _ 2");
                }
                return false;
            }
        });
    }

    public void IntentMainActivity(){
        Intent intents = new Intent(this, MainActivity.class);
        if(intents == null){
            Log.d("TestLog", "intents = null");
            return;
        }
        startActivity(intents);
        finish();
    }
}


//http://cfile5.uf.tistory.com/image/2615BF4F52B3E5CF08532E