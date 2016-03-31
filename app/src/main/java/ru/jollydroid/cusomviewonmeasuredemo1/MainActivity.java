package ru.jollydroid.cusomviewonmeasuredemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Item[] data;
    private RecyclerView list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new Item[100];
        Random generator = new Random();
        for (int i = 0; i < data.length; i++) {
            float a = generator.nextFloat() * 100;
            float b = a * (generator.nextFloat() * 3 + 1) / 2;
            data[i] = new Item(Math.round(a) + 1, Math.round(b) + 1);
        }

        list = (RecyclerView)findViewById(R.id.list);
        list.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
//        list.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(data);
        list.setAdapter(adapter);

    }
}
