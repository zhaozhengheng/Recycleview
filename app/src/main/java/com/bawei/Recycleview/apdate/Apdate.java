package com.bawei.Recycleview.apdate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.Recycleview.R;

import java.util.List;

/**
 * Created by 1 on 2017/3/21.
 */
public class Apdate extends RecyclerView.Adapter<myViewHodle>
{
    private List<String> list;
    private Context context;

    public Apdate(List<String> list, Context context)
    {
        this.list = list;
        this.context = context;
    }
//关联ViewHodle并找布局
    @Override
    public myViewHodle onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        myViewHodle mViewHodle = new myViewHodle(inflate);
        return mViewHodle;
    }

//复值
    @Override
    public void onBindViewHolder(myViewHodle holder, int position)
    {
        holder.te.setText(list.get(position));

    }


    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
//优化找控件
class myViewHodle extends RecyclerView.ViewHolder{

    TextView te;

    public myViewHodle(View itemView) {
        super(itemView);
        te = (TextView) itemView.findViewById(R.id.TextView);
    }
}

