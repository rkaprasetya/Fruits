package com.example.raka.fruits;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

public class CustomListAdapter extends BaseAdapter {


    Context mContext;
    String[] fruitName;
    int[] fruitPicture;
    LayoutInflater mInflater;

    public CustomListAdapter(Context mContext, String[] fruitName, int[] fruitPicture) {
        this.mContext = mContext;
        this.fruitName = fruitName;
        this.fruitPicture = fruitPicture;
    }

    @Override
    public int getCount() {
        return fruitName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = mInflater.inflate(R.layout.list_fruit,null);
       /* @BindView(R.id.iv_img_list)
        ImageView ivImgList;
        @BindView(R.id.tv_img_list)
        TextView tvImgList;*/
       ImageView ivImgList = (ImageView) view.findViewById(R.id.iv_img_list);
       TextView tvImgList = (TextView) view.findViewById(R.id.tv_img_list);
        ivImgList.setImageResource(fruitPicture[i]);
        tvImgList.setText(fruitName[i]);
        return view;
    }
}
