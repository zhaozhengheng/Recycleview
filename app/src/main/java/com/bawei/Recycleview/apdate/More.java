package com.bawei.Recycleview.apdate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.bawei.Recycleview.R;

/**
 * Created by 1 on 2017/3/22.
 */
public class More extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
private Context context;
    private String somda;
    private static final int A=0;
    private static final int B=1;
    private static final int C=2;
    private int type=A;

    public More(Context context, String somda)
    {
        this.context = context;
        this.somda = somda;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder=null;
        switch (viewType)
        {
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
                viewHolder=new fistHodle(view);
                break;
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);
                viewHolder=new sencode(view1);
                break;
            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
                viewHolder=new san(view2);
                break;
        }
        return viewHolder;
    }


    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        int type = getItemViewType(position);
        switch (type)
        {
            case 0:
                fistHodle ff= (fistHodle) holder;
                ff.tt.setText(somda);
                break;
            case 1:

                break;
            case 2:
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position)
        {
            case 0:
                type=A;
                break;
            case 1:
                type=B;
                break;
            case 2:
                type=C;
                break;
        }


        return type;
    }

    public int getItemCount() {
        return 3;
    }
    public class fistHodle extends RecyclerView.ViewHolder{
        TextView tt;
        public fistHodle(View itemView) {
            super(itemView);
             tt= (TextView) itemView.findViewById(R.id.TextView);
        }

    }
    class sencode extends RecyclerView.ViewHolder{

        public sencode(View itemView) {
            super(itemView);
        }
    }
    class san extends RecyclerView.ViewHolder
    {

        public san(View itemView) {
            super(itemView);
        }
    }
}
