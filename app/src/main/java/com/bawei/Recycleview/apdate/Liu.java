package com.bawei.Recycleview.apdate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.bawei.Recycleview.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 1 on 2017/3/21.
 */
public class Liu extends RecyclerView.Adapter<MyViwHodle>
{
    private Context context;
   private List<String> list;
  private List<Integer> heightlist;
    public interface  onItemoncl{
        public void dandian(int position);
        public void changan(int position);
    }
    public onItemoncl onItemoncl;



    public void setOnItemoncl(Liu.onItemoncl onItemoncl) {
        this.onItemoncl = onItemoncl;
    }

    public Liu(Context context, List<String> list)
    {
        this.context = context;
        this.list = list;
        heightlist =new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            heightlist.add((int) (100+200*Math.random()));
        }
    }


    public MyViwHodle onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyViwHodle my=new MyViwHodle(view);


        return my;
    }


    public void onBindViewHolder(MyViwHodle holder,final int position)
    {
        ViewGroup.LayoutParams layoutParams = holder.tt.getLayoutParams();
        layoutParams.height =heightlist.get(position);
        holder.tt.setLayoutParams(layoutParams);
        holder.tt.setText(list.get(position));
        if(onItemoncl!=null)
        {
            holder.tt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    onItemoncl.dandian(position);
                }
            });
            holder.tt.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v)
                {

                    onItemoncl.changan(position);

                    return true;
                }
            });
        }

    }
public void onMove(int oldposition,int newposition)
{
    Collections.swap(list,oldposition,newposition);
    this.notifyItemMoved(oldposition,newposition);
}
    public void ondelete(int position)
    {
list.remove(position);
        this.notifyItemRemoved(position);
    }

    public int getItemCount() {
        return list.size();
    }
}
class MyViwHodle extends RecyclerView.ViewHolder{
    TextView tt;
    public MyViwHodle(View itemView) {
        super(itemView);
        tt =  (TextView) itemView.findViewById(R.id.TextView);
    }
}
