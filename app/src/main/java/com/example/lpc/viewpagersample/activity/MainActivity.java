package com.example.lpc.viewpagersample.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lpc.viewpagersample.R;
import com.example.lpc.viewpagersample.adapter.FragmentAdapter;
import com.example.lpc.viewpagersample.fragment.PasswordFragment;
import com.example.lpc.viewpagersample.fragment.AccountFragment;
import com.example.lpc.viewpagersample.fragment.PersonFragment;
import com.example.lpc.viewpagersample.fragment.DiaryFragment;
import com.example.lpc.viewpagersample.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public MyViewPager mViewPager ;
    public FragmentAdapter mAdapter ;
    public FragmentManager mManager ;

    public List<Fragment> mDatas ;

    public PasswordFragment passwordFragment;
    public DiaryFragment diaryFragment;
    public AccountFragment accountFragment;
    public PersonFragment personFragment ;

    /**
     *
     * @param savedInstanceState
     */

    public LinearLayout llHome, llSearch, llInterest, llPerson ;
    public ImageView ivHome, ivSearch, ivInterest, ivPerson ;
    public TextView tvHome, tvSearch, tvInterest, tvPerson ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE) ;
        setContentView(R.layout.activity_main);

//        initDatas() ;
        initView() ;
    }

    public void initView() {


         /*
        * set click events for bottom menu layouts
        * */

        llHome = (LinearLayout) findViewById(R.id.ll_home);
        llSearch = (LinearLayout) findViewById(R.id.ll_search) ;
        llInterest = (LinearLayout) findViewById(R.id.ll_interest) ;
        llPerson = (LinearLayout) findViewById(R.id.ll_person) ;
        llHome.setOnClickListener(this);
        llSearch.setOnClickListener(this);
        llInterest.setOnClickListener(this);
        llPerson.setOnClickListener(this);

        /*
        * set icon changes when menu item selected
        * */
        ivHome = (ImageView) findViewById(R.id.iv_home) ;
        ivSearch = (ImageView) findViewById(R.id.iv_search) ;
        ivInterest = (ImageView) findViewById(R.id.iv_interest) ;
        ivPerson = (ImageView) findViewById(R.id.iv_person) ;

        tvHome = (TextView) findViewById(R.id.tv_home) ;
        tvSearch = (TextView) findViewById(R.id.tv_search) ;
        tvInterest = (TextView) findViewById(R.id.tv_interest) ;
        tvPerson = (TextView) findViewById(R.id.tv_person) ;

        mDatas = new ArrayList<Fragment>() ;

        passwordFragment = new PasswordFragment();
        diaryFragment = new DiaryFragment() ;
        accountFragment = new AccountFragment() ;
        personFragment = new PersonFragment() ;

        mDatas.add(passwordFragment);
        mDatas.add(diaryFragment);
        mDatas.add(accountFragment);
        mDatas.add(personFragment);

        mViewPager = (MyViewPager) findViewById(R.id.vp_home);
        mManager = getSupportFragmentManager() ;
        mAdapter = new FragmentAdapter(mManager,mDatas) ;

        mViewPager.setAdapter(mAdapter);
        setCurrent(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setCurrent(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                setCurrent(0);
                break;
            case R.id.ll_search:
                setCurrent(1);
                break;
            case R.id.ll_interest:
                setCurrent(2);
                break;
            case R.id.ll_person:
                setCurrent(3);
                break;
        }
    }

    public void resetMenu() {
        ivHome.setImageResource(R.drawable.password);
        tvHome.setTextColor(Color.parseColor("#999999"));

        ivSearch.setImageResource(R.drawable.diary);
        tvSearch.setTextColor(Color.parseColor("#999999"));

        ivInterest.setImageResource(R.drawable.account);
        tvInterest.setTextColor(Color.parseColor("#999999"));

        ivPerson.setImageResource(R.drawable.person);
        tvPerson.setTextColor(Color.parseColor("#999999"));
    }
    public void setCurrent(int pos) {
        resetMenu();
        switch (pos) {
            case 0:
                mViewPager.setCurrentItem(0);
                ivHome.setImageResource(R.drawable.password_sel);
                tvHome.setTextColor(Color.parseColor("#FF0000"));
                break;
            case 1:
                mViewPager.setCurrentItem(1);
                ivSearch.setImageResource(R.drawable.diary_sel);
                tvSearch.setTextColor(Color.parseColor("#FF0000"));
                break;
            case 2:
                mViewPager.setCurrentItem(2);
                ivInterest.setImageResource(R.drawable.account_sel);
                tvInterest.setTextColor(Color.parseColor("#FF0000"));
                break;
            case 3:
                mViewPager.setCurrentItem(3);
                ivPerson.setImageResource(R.drawable.person_sel);
                tvPerson.setTextColor(Color.parseColor("#FF0000"));
                break;
            default:
                break;
        }
    }

}
