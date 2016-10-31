package com.ebookfrenzy.testapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ebookfrenzy.testapplication.util.Singleton;

import java.util.ArrayList;

/**
 * Created by 신원찬 on 2016-10-30.
 */
public class MessageAdapter extends BaseAdapter {

    private Context mContext = null;
    private ArrayList<Item> list = new ArrayList<Item>();

    public MessageAdapter(Context mContext){
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if( convertView == null ){

            return null;
        }
        else {
            //TextView message = new TextView(Singleton.getInstance().GetMainActivity());
           // message.setText(list.get(position).GetMessage());
            return convertView;
        }
    }
}
