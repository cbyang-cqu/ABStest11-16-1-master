package com.patac.abstest;
import android.app.Activity;
import android.app.ActionBar;
import android.app.FragmentTransaction;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TabActivity extends Activity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup rpTab;
    private RadioButton rbDeal,rbPoi,rbMore,rbUser;
    private MyFragment fg1,fg2,fg3,fg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        bindView();
    }
    private void bindView() {
        rpTab = (RadioGroup)findViewById(R.id.rd_group);
        rpTab.setOnCheckedChangeListener(this);

        rbDeal = (RadioButton)findViewById(R.id.rd_menu_deal);
        rbPoi = (RadioButton)findViewById(R.id.rd_menu_poi);
        rbMore = (RadioButton)findViewById(R.id.rd_menu_more);
        rbUser = (RadioButton)findViewById(R.id.rd_menu_user);

        rbDeal.setChecked(true);
    }

    public void hideAllFragment(FragmentTransaction transaction){
        if(fg1!=null){
            transaction.hide(fg1);
        }
        if(fg2!=null){
            transaction.hide(fg2);
        }
        if(fg3!=null){
            transaction.hide(fg3);
        }
        if(fg4!=null){
            transaction.hide(fg4);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (checkedId){
            case R.id.rd_menu_deal:
                if(fg1==null){
                    fg1 = new MyFragment("第一个Fragment");
                    transaction.add(R.id.fragment_container,fg1);
                }else{
                    transaction.show(fg1);
                }
                break;
            case R.id.rd_menu_poi:
                if(fg2==null){
                    fg2 = new MyFragment("第二个Fragment");
                    transaction.add(R.id.fragment_container,fg2);
                }else{
                    transaction.show(fg2);
                }
                break;
            case R.id.rd_menu_more:
                if(fg3==null){
                    fg3 = new MyFragment("第三个Fragment");
                    transaction.add(R.id.fragment_container,fg3);
                }else{
                    transaction.show(fg3);
                }
                break;
            case R.id.rd_menu_user:
                if(fg4==null){
                    fg4 = new MyFragment("第四个Fragment");
                    transaction.add(R.id.fragment_container,fg4);
                }else{
                    transaction.show(fg4);
                }
                break;
        }
        transaction.commit();
    }
}
