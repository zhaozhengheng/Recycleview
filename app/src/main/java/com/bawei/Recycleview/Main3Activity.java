package com.bawei.Recycleview;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.bawei.Recycleview.apdate.Liu;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity  implements SwipeRefreshLayout.OnRefreshListener
{

    private SwipeRefreshLayout sw;
    private RecyclerView re;
    private List<String> list;
    Handler han=new Handler();
    private Liu liu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        sw = (SwipeRefreshLayout) findViewById(R.id.SwipeRefreshLayout);
        re = (RecyclerView) findViewById(R.id.RecyclerView2);
        initDate();
        re.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));
        liu = new Liu(this,list);
        re.setAdapter(liu);
        sw.setColorSchemeColors(Color.RED,Color.BLACK,Color.BLUE);
        sw.setOnRefreshListener(this);
    }

    private void initDate()
    {
        list = new ArrayList<String>();
        for (int i = 0; i <1000 ; i++)
        {
            list.add("滴"+i+"条数据");
        }
    }


    public void onRefresh()
    {
      han.postDelayed(new Runnable() {
          @Override
          public void run() {
              list.add(0,"新家的");
              liu.notifyDataSetChanged();
              sw.setRefreshing(false);

          }
      },2000);
    }

    public void pubu(View view)
    {

        Intent intent=new Intent(this,Main5Activity.class);
         startActivity(intent);
    }
}
