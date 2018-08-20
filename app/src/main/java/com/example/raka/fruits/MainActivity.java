package com.example.raka.fruits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_buah)
    ListView rvBuah;
    String fruitName[] = {"Apel","Alpukat","Ceri","Durian","Jambu Air","Manggis","Strawberry"};
    int fruitPicture[] = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri,R.drawable.durian,R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};
    int fruitSound[] = {R.raw.alpukat, R.raw.apel, R.raw.ceri,R.raw.durian,R.raw.jambuair, R.raw.manggis, R.raw.strawberry};
    Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CustomListAdapter mAdapter = new CustomListAdapter(getApplicationContext(), fruitName, fruitPicture);
        rvBuah.setAdapter(mAdapter);
        rvBuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mIntent = new Intent(getApplicationContext(),DetailFruitActivity.class);
                mIntent.putExtra(DetailFruitActivity.FRUIT_NAME,fruitName[i]);
                mIntent.putExtra(DetailFruitActivity.FRUIT_PICTURE,fruitPicture[i]);
                mIntent.putExtra(DetailFruitActivity.FRUIT_SOUND,fruitSound[i]);
                startActivity(mIntent);
            }
        });


    }
}
