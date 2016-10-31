package com.ebookfrenzy.testapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by 신원찬 on 2016-10-09.
 */
public class SubActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }
}
