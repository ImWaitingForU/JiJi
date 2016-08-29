package com.iwfu.jiji.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iwfu.jiji.R;
import com.iwfu.jiji.bean.NoteBean;

import java.util.List;

/**
 * Created by Iwfu on 2016/8/8.
 * <p/>
 * 主界面的RecyclerView Adapter
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context mContext;
    private List<NoteBean> noteBeanList;
    private LayoutInflater mInflater;

    public MainAdapter (List<NoteBean> noteBeanList) {
        this.noteBeanList = noteBeanList;
        mInflater = LayoutInflater.from (mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder (mInflater.inflate (R.layout.item_mainadapter, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, int position) {
        holder.tvTitle.setText (noteBeanList.get (position).getTitle ());
        holder.tvContent.setText (noteBeanList.get (position).getContent ());
        holder.tvDate.setText (noteBeanList.get (position).getDate ());
        holder.ivLock.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Toast.makeText (mContext, "加密该笔记", Toast.LENGTH_SHORT).show ();
            }
        });
    }

    @Override
    public int getItemCount () {
        return noteBeanList.size ();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvContent;
        private TextView tvDate;
        private ImageView ivLock;

        public MyViewHolder (View itemView) {
            super (itemView);
            tvTitle = (TextView) itemView.findViewById (R.id.tvTitle);
            tvDate = (TextView) itemView.findViewById (R.id.tvDate);
            tvContent = (TextView) itemView.findViewById (R.id.tvContent);
            ivLock = (ImageView) itemView.findViewById (R.id.ivLock);
        }
    }

}
