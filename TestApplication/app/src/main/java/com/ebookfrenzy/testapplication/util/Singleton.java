package com.ebookfrenzy.testapplication.util;

import com.ebookfrenzy.testapplication.MainActivity;

/**
 * Created by 신원찬 on 2016-10-30.
 */
public class Singleton {

    private static volatile Singleton instance = null;

    private MainActivity mainActivity;

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void SetMainActivity(MainActivity _mainActivity) {
        mainActivity = _mainActivity;
    }

    public MainActivity GetMainActivity(){
        return mainActivity;
    }
}
