package com.bawei.Recycleview.apdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.Recycleview.R;

public class Main4Activity extends AppCompatActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        re = (RecyclerView) findViewById(R.id.RecyclerView3);
        More mm=new More(this,"哈哈哈");
        re.setLayoutManager(new LinearLayoutManager(this));
        re.setAdapter(mm);

    }
}
