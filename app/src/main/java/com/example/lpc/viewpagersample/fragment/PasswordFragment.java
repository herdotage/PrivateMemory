package com.example.lpc.viewpagersample.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.lpc.viewpagersample.R;
import com.example.lpc.viewpagersample.activity.NewPassword;
import com.example.lpc.viewpagersample.activity.PasswordDetails;
import com.example.lpc.viewpagersample.adapter.RecyclerAdapter;
import com.example.lpc.viewpagersample.entities.PasswordInfo;

import java.util.ArrayList;

/**
 * Created by lpc on 2016/7/18.
 */
public class PasswordFragment extends Fragment {

    private String mTitle ;
    private TextView mTextView ;
    public RecyclerView passwordRecyclerView ;
    public ArrayList<PasswordInfo> mPasswordInfos ;
    public FloatingActionButton fab ;
    public  RecyclerAdapter adapter ;

    public static PasswordFragment newInstance(String title) {
        PasswordFragment fragment = new PasswordFragment();
//        Bundle args = new Bundle() ;
//        args.putString("home_fragment_title",title);
//        fragment.setArguments(args);
        return fragment ;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mTitle = getArguments().getString("home_fragment_title") ;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_password,container,false) ;
        passwordRecyclerView = (RecyclerView) v.findViewById(R.id.rv_password) ;
        mPasswordInfos = new ArrayList<PasswordInfo>() ;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher) ;
        for (int i = 0 ; i < 25 ; i ++) {
            PasswordInfo info = new PasswordInfo();
            info.setObjectId("123 of "+ i);
            info.setSiteName("网站 " + i);
            info.setWebImg(bitmap);
            info.setSiteAddress("http://www.baidu.com/");
            mPasswordInfos.add(i,info);
        }
         adapter = new RecyclerAdapter(getActivity(),mPasswordInfos) ;
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), PasswordDetails.class) ;
                intent.putExtra("siteId",mPasswordInfos.get(position).getObjectId()) ;
//                Log.d("LPC","siteId:------>" + mPasswordInfos.get(position).getObjectId()) ;
                getActivity().startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, final int position) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final Dialog dialog = builder.create();
                final RecyclerAdapter tempAdapter = adapter ;
                builder.setTitle("确定要删除这条密码记录吗？") ;
                builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        removeItem(position);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });


        passwordRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        passwordRecyclerView.setAdapter(adapter);

        fab = (FloatingActionButton) v.findViewById(R.id.fab_password) ;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewPassword.class) ;
                getActivity().startActivity(intent);
            }
        });

        return v ;
    }



  /*  @Override
    public void fetchData() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher) ;
        for (int i = 0 ; i < 15 ; i ++) {
            PasswordInfo info = new PasswordInfo();
            info.setObjectId("1235");
            info.setSiteName("网站12345");
            info.setWebImg(bitmap);
            info.setSiteAddress("http://www.baidu.com/");
            mPasswordInfos.add(i,info);
        }
        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(),mPasswordInfos) ;

        passwordRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        passwordRecyclerView.setAdapter(adapter);
    }*/

    public void removeItem(int pos) {
        mPasswordInfos.remove(pos) ;
        adapter.notifyItemRemoved(pos);
    }

    public void newItem(PasswordInfo passwordInfo) {
        int size = mPasswordInfos.size() ;
        mPasswordInfos.add(size,passwordInfo);
        adapter.notifyItemInserted(size);
    }
}
