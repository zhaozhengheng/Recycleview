package com.bawei.Recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.bawei.Recycleview.apdate.Liu;
import com.bawei.Recycleview.apdate.Main4Activity;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<String> list;
    private Liu liu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RecyclerView re= (RecyclerView) findViewById(R.id.RecyclerView1);

        initDate();
        liu = new Liu(this,list);
        re.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));
        re.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL_LIST));
        re.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        re.setAdapter(liu);
liu.setOnItemoncl(new Liu.onItemoncl() {
    @Override
    public void dandian(int position)
    {
        Toast.makeText(Main2Activity.this, "短按了"+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changan(int position)
    {
        Toast.makeText(Main2Activity.this, "长按了"+position, Toast.LENGTH_SHORT).show();
    }
});
    }
    private void initDate()
    {
        list = new ArrayList<>();
        for (int i = 0; i <1000 ; i++)
        {
            list.add("第"+i+"条数据");
        }
    }

    public void deleteItem(View view)
    {
        list.remove(5);
        liu.notifyItemInserted(5);
    }

    public void addItem(View view)
    {

        list.add(0,"新加的");
        liu.notifyItemRemoved(0);
    }

    public void duotiaomu(View view)
    {
        Intent intent=new Intent(this,Main4Activity.class);
        startActivity(intent);
    }

    public void shuaxin(View view)
    {
        Intent intent=new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
}
