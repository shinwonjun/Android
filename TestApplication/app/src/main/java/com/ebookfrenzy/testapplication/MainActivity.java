package com.ebookfrenzy.testapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ebookfrenzy.testapplication.object.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("TestLog", " MainActivity _ 1");
        setContentView(R.layout.activity_main);
        Log.d("TestLog", " MainActivity _ 2");

        mListView = (ListView) findViewById(R.id.listView);
        if(mListView == null) {
            Log.d("TestLog", "mListView = null");
            return;
        }
        mAdapter = new ListViewAdapter(this);
        if (mAdapter == null) {
            Log.d("TestLog", "mAdapter = null");
            return;
        }

        mListView.setAdapter(mAdapter);
        mAdapter.addItem("https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Coraz%C3%B3n.svg/220px-Coraz%C3%B3n.svg.png", "123", "ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ");


        // Intent intent = new Intent(this, SubActivity.class);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        // client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private class ViewHolder {
        public ImageView mIcon;
        public TextView mText;
        public TextView mDate;
    }

    private class ListViewAdapter extends BaseAdapter {
        private Context mContext = null;
        private ArrayList<Item> mListData = new ArrayList<Item>();

        public ListViewAdapter(Context mContext) {
            super();
            if(mContext == null){
                Log.d("TestLog", "mContext = null");
                return;
            }
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void addItem(String strImage, String strTitle, String strDate) {

            Item addInfo = null;
            addInfo = new Item();

            if(addInfo == null) {
                Log.d("TestLog", "addInfo = null");
            }

            addInfo.mIcon = strImage;
            addInfo.mTitle = strTitle;
            addInfo.mDate = strDate;
            mListData.add(addInfo);
          }

        public void remove(int position) {
            mListData.remove(position);
            dataChange();
        }

        public void dataChange() {
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listview_item, null);

                holder.mIcon = (ImageView) convertView.findViewById(R.id.mImage);
                holder.mText = (TextView) convertView.findViewById(R.id.mText);
                holder.mDate = (TextView) convertView.findViewById(R.id.mDate);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Item mData = mListData.get(position);
            Glide.with(this.mContext).load(mData.mIcon).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.mIcon);
            holder.mText.setText(mData.mTitle);
            holder.mDate.setText(mData.mDate);

            return convertView;
        }
    }
}
