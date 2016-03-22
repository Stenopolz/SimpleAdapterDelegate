package com.stenopolz.adapterdelegate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.stenopolz.adapterdelegate.adapter.MainAdapter;
import com.stenopolz.adapterdelegate.models.Ads;
import com.stenopolz.adapterdelegate.models.Colored;
import com.stenopolz.adapterdelegate.models.Green;
import com.stenopolz.adapterdelegate.models.Header;
import com.stenopolz.adapterdelegate.models.Red;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Pavel Shchors on 16.03.2016.
 * <p/>
 * Main activity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Random random = new Random();
        List<Colored> coloredList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (random.nextBoolean()) {
                coloredList.add(new Red());
            } else {
                coloredList.add(new Green());
            }
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler);

        MainAdapter adapter = new MainAdapter();
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
            adapter.setData(coloredList, new Ads(), new Header());
        }
    }
}
