package com.example.lpc.viewpagersample.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lpc.viewpagersample.R;
import com.example.lpc.viewpagersample.activity.PasswordDetails;
import com.example.lpc.viewpagersample.entities.PasswordInfo;
import com.example.lpc.viewpagersample.entities.PersonInfo;

import java.util.ArrayList;

/**
 * Created by lpc on 2016/7/19.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PasswordViewHolder> {

    private Context mContext ;
    public  ArrayList<PasswordInfo> mDatas ;
    public OnItemClickListener itemClickListener ;
    public AdapterView.OnItemLongClickListener itemLongClickListener ;

    public RecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public RecyclerAdapter(Context context, ArrayList<PasswordInfo> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public PasswordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.password_item,parent,false);
        return new PasswordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PasswordViewHolder holder, final int position) {
        holder.ivSiteIcon.setImageBitmap(mDatas.get(position).getWebImg());
        holder.tvSiteName.setText(mDatas.get(position).getSiteName());

        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (itemClickListener != null) {
                    itemClickListener.onItemClick(view,position);
                }

            }
        });
        holder.llItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                itemClickListener.onItemLongClick(view,position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class PasswordViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivSiteIcon ;
        public TextView tvSiteName ;
        public LinearLayout llItem ;

        public PasswordViewHolder(View itemView) {
            super(itemView);
            llItem = (LinearLayout) itemView.findViewById(R.id.ll_item) ;
            ivSiteIcon = (ImageView) itemView.findViewById(R.id.iv_site_icon);
            tvSiteName = (TextView) itemView.findViewById(R.id.tv_site_name) ;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view,int position) ;
        void onItemLongClick(View view, int position) ;
    }
    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener ;
    }
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener ;
    }


}



