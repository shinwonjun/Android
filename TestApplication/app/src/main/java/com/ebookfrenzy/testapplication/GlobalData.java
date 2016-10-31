package com.ebookfrenzy.testapplication;

import com.ebookfrenzy.testapplication.util.Singleton;

/**
 * Created by 신원찬 on 2016-10-30.
 */
public class GlobalData extends Singleton{
    public MainActivity mainActivity;

    public void SetMainActivity( MainActivity _mainActivbity ) { mainActivity = _mainActivbity;}
    public MainActivity getMainActivbity() { return mainActivity;}
}
