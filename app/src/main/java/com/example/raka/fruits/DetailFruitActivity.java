package com.example.raka.fruits;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFruitActivity extends AppCompatActivity {

   /* @BindView(R.id.iv_image_detail)
    ImageView ivImageDetail;
    @BindView(R.id.tv_title_detail)
    TextView tvTitleDetail;*/

    public static final String FRUIT_NAME = "FRUIT_NAME";
    public static final String FRUIT_PICTURE = "FRUIT_PICTURE";
    public static final String FRUIT_SOUND = "FRUIT_SOUND";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fruit);
        /*ButterKnife.bind(this);*/
        TextView tvTitleDetail = (TextView) findViewById(R.id.tv_title_detail);
        ImageView ivImageDetail = (ImageView) findViewById(R.id.iv_image_detail);
        tvTitleDetail.setText(getIntent().getStringExtra(FRUIT_NAME));
        ivImageDetail.setImageResource(getIntent().getIntExtra(FRUIT_PICTURE,0));

        MediaPlayer mPlayer = new MediaPlayer();
        Uri location = Uri.parse("android.resource://"+getPackageName()+"/"+getIntent().getIntExtra(FRUIT_SOUND,0));

        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mPlayer.setDataSource(this,location);
            mPlayer.prepare();
            mPlayer.start();
            Log.e("error",String.valueOf(location));
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
