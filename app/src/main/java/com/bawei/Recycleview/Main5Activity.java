package com.bawei.Recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.bawei.Recycleview.apdate.Liu;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    private List<String> list;
    private Liu liu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        RecyclerView re= (RecyclerView) findViewById(R.id.RecyclerView5);
          initDate();
        re.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));
        liu = new Liu(this,list);
        re.setAdapter(liu);

        ItemTouchHelper helper =new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                int swipeFlag = ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;



                return makeMovementFlags(dragFlag,swipeFlag);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int oldPosition = viewHolder.getAdapterPosition();
                int newPosition = target.getAdapterPosition();
                liu.onMove(oldPosition,newPosition);


                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                liu.ondelete(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(re);

    }

    private void initDate()
    {
        list = new ArrayList<>();
        for (int i = 0; i <1000 ; i++)
        {
            list.add("滴"+i+"条数据");
        }
    }
}
