package com.bawei.Recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.Recycleview.apdate.Apdate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private List<String> list;
    private RecyclerView re;
    private Apdate aa;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        re = (RecyclerView) findViewById(R.id.RecyclerView);

        initDate();
        aa = new Apdate(list,this);
        re.setAdapter(aa);


    }


    private void initDate()
    {
        list = new ArrayList<>();
        for (int i = 0; i <1000 ; i++)
        {
            list.add("第"+i+"条数据");
        }
    }
    public void danxing(View view)
    {

       re.setLayoutManager(new LinearLayoutManager(this));

        re.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        aa.notifyDataSetChanged();




    }

    public void duoxing(View view)
    {
        re.setLayoutManager(new GridLayoutManager(this,3));
        re.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        aa.notifyDataSetChanged();
    }

    public void danheng(View view)
    {
        re.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        aa.notifyDataSetChanged();
    }

    public void duoheng(View view)
    {
        re.setLayoutManager(new GridLayoutManager(this,5,RecyclerView.HORIZONTAL,false));
        aa.notifyDataSetChanged();
    }

    public void pubuliu(View view)
    {
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
