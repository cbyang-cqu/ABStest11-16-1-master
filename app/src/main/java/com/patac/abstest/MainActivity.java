package com.patac.abstest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {
        /*设置spinner系统自带的字体颜色，预设变量*/
        private Spinner mSpinner;
        private Spinner mSpinner1;
        private Spinner mSpinner2;
        private ArrayAdapter<String> mAdapter ;
        private ArrayAdapter<String> mAdapter1 ;
        private ArrayAdapter<String> mAdapter2 ;
        private String [] mStringArray;
        private String [] mStringArray1;
        private String [] mStringArray2;
        private String str1;
        private String str2;
        private EditText strFill1;
        private EditText strFill2;
        private EditText strFill3;
        private EditText strFill4;
        private EditText strFill5;
        private EditText strFill6;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            /*引用activity_mian布局*/
            setContentView(R.layout.activity_main);
            /*调用下拉事件*/
            init11();/*车辆型号-， 选择品牌*/
            init12();/*车辆型号-， 选择型号*/
            init21();/*测试地点-， 选择地点*/
            init31();/*测试日期1-，选择年份*/
            init32();/*测试日期2-，选择月份*/
            init33();/*测试日期3-，选择天*/
            init41();/*测试规范1-，选择规范1*/
            init42();/*测试规范2-，选择规范2*/
        }

        /*初始化，引入相关*/
        private void init11(){
            mSpinner=(Spinner) findViewById(R.id.spinner_carBrand);
            mStringArray=getResources().getStringArray(R.array.carBrand_array);
            //使用自定义的ArrayAdapter
            mAdapter = new TestArrayAdapter(MainActivity.this,mStringArray);

            //设置下拉列表风格(这句不些也行)
            mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSpinner.setAdapter(mAdapter);

            //监听Item选中事件
            mSpinner.setOnItemSelectedListener(new ItemSelectedListenerImpl());

        }
        /*定义如下多个下拉事件*/
        private void init12(){
            mSpinner=(Spinner) findViewById(R.id.spinner_carNum);
            mStringArray=getResources().getStringArray(R.array.carBrand_num);
            //使用自定义的ArrayAdapter
            mAdapter = new TestArrayAdapter(MainActivity.this,mStringArray);

            //设置下拉列表风格(这句不些也行)
            mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSpinner.setAdapter(mAdapter);

            //监听Item选中事件
            mSpinner.setOnItemSelectedListener(new ItemSelectedListenerImpl());

        }
        private void init21(){
            mSpinner=(Spinner) findViewById(R.id.spinner_place);
            mStringArray=getResources().getStringArray(R.array.place);
            //使用自定义的ArrayAdapter
            mAdapter = new TestArrayAdapter(MainActivity.this,mStringArray);

            //设置下拉列表风格(这句不些也行)
            mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSpinner.setAdapter(mAdapter);

            //监听Item选中事件
            mSpinner.setOnItemSelectedListener(new ItemSelectedListenerImpl());

        }
        private void init31(){
            mSpinner=(Spinner) findViewById(R.id.spinner_year);
            mStringArray=getResources().getStringArray(R.array.year);
            //使用自定义的ArrayAdapter
            mAdapter = new TestArrayAdapter(MainActivity.this,mStringArray);

            //设置下拉列表风格(这句不些也行)
            mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSpinner.setAdapter(mAdapter);

            //监听Item选中事件
            mSpinner.setOnItemSelectedListener(new ItemSelectedListenerImpl());

        }
        private void init32(){
            mSpinner=(Spinner) findViewById(R.id.spinner_month);
            mStringArray=getResources().getStringArray(R.array.month);
            //使用自定义的ArrayAdapter
            mAdapter = new TestArrayAdapter(MainActivity.this,mStringArray);

            //设置下拉列表风格(这句不些也行)
            mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSpinner.setAdapter(mAdapter);

            //监听Item选中事件
            mSpinner.setOnItemSelectedListener(new ItemSelectedListenerImpl());

        }
        private void init33(){
            mSpinner=(Spinner) findViewById(R.id.spinner_day);
            mStringArray=getResources().getStringArray(R.array.day);
            //使用自定义的ArrayAdapter
            mAdapter = new TestArrayAdapter(MainActivity.this,mStringArray);

            //设置下拉列表风格(这句不些也行)
            mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSpinner.setAdapter(mAdapter);

            //监听Item选中事件
            mSpinner.setOnItemSelectedListener(new ItemSelectedListenerImpl());

        }
        private void init41(){
            mSpinner1=(Spinner) findViewById(R.id.spinner_testtype);
            mStringArray1=getResources().getStringArray(R.array.testtype);
            //使用自定义的ArrayAdapter
            mAdapter1 = new TestArrayAdapter(MainActivity.this,mStringArray1);
            //设置下拉列表风格(这句不些也行)
            mAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSpinner1.setAdapter(mAdapter1);
            //监听Item选中事件
            mSpinner1.setOnItemSelectedListener(new ItemSelectedListenerImpl());
            //监听测试规范中选中的字符串并以Str2存储
            str1 = (String) mSpinner1.getSelectedItem();
            mSpinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                //有监听到选中一个选项，执行该事件
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    //存储被选择项的值到str1
                    str1 = (String)mSpinner1.getSelectedItem();
                    //每次监听后都执行一次int42()，根据选项改变后面一个下拉框
                    init42();
                }

                @Override
                //没有监听到选中一个选项，执行该事件
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });
        }
        private void init42(){
            mSpinner2=(Spinner) findViewById(R.id.spinner_testname);
            /*根据规范1的选择实时变更规范二的选项的值*/
            switch(str1){
                case "TCS":
                    /*调用下拉框的选项列表*/
                    mStringArray2=getResources().getStringArray(R.array.testname_TCS);
                    break;
                case "ABS":
                    mStringArray2=getResources().getStringArray(R.array.testname_ABS);
                    break;
                default :
                    mStringArray2=getResources().getStringArray(R.array.testname_ECS);
            }
            //使用自定义的ArrayAdapter
            mAdapter2 = new TestArrayAdapter(MainActivity.this,mStringArray2);
            //设置样式
            mAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //加载适配器
            mSpinner2.setAdapter(mAdapter2);

            //监听Item选中事件
            mSpinner2.setOnItemSelectedListener(new ItemSelectedListenerImpl());
            //监听测试规范中选中的字符串并以Str2存储
            str2 = (String) mSpinner2.getSelectedItem();
            mSpinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    //拿到被选择项的值
                    str2 = (String)mSpinner2.getSelectedItem();
                    /*//把该值传给 TextView
                    tv.setText(str);*/
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });

        }

        /*定义监听事件*/
        private class ItemSelectedListenerImpl implements OnItemSelectedListener{
            @Override
            /*定义终端选中打印事件*/
            public void onItemSelected(AdapterView<?> parent, View view, int position,long arg3) {
                System.out.println("选中了:"+mStringArray[position]);
            }
            @Override
            /*定义终端无选中打印事件*/
            public void onNothingSelected(AdapterView<?> parent) {}

        }

    /* 点击阅读按钮，填写完毕跳转至阅读操作指南界面，否则错误提示*/
    public void OnNext(View v){
        //startActivity(new Intent(MainActivity.this,ReadActivity.class));
        strFill1=(EditText) findViewById(R.id.edit_project);
        strFill2=(EditText) findViewById(R.id.edit_driver);
        strFill3=(EditText) findViewById(R.id.edit_engineer);
        strFill4=(EditText) findViewById(R.id.edit_gooster);
        strFill5=(EditText) findViewById(R.id.edit_gearbox);
        strFill6=(EditText) findViewById(R.id.edit_tyre);

        //如果填写信息完毕，点击跳转下一个页面，并传值到下个页面
        /*判断是否所有的填写已经完成？*/
        if((! TextUtils.isEmpty(strFill1.getText()) ) && (! TextUtils.isEmpty(strFill2.getText()) ) &&(! TextUtils.isEmpty(strFill3.getText()) ) &&
                (! TextUtils.isEmpty(strFill4.getText()) ) &&(! TextUtils.isEmpty(strFill5.getText()) ) &&(! TextUtils.isEmpty(strFill6.getText()) ) ) {
            Intent intent = new Intent(this, ReadActivity.class);
            /*界面跳转时候传值*/
            intent.putExtra("norm", str1 + " " + str2 + "试验操作指南");
            startActivity(intent);
        }
        //如果填写不全或者出错，弹出提示框
        else{
            View view = getLayoutInflater().inflate(R.layout.dialog_main_tip, null);
            //这里一定要用final,不然内部无法访问；设置提示框的样式和交互事件
            final MainActivityTipDialog mMyDialog = new MainActivityTipDialog(this, 0, 0, view, R.style.DialogTheme);
            mMyDialog.setCancelable(true);  //对话框弹出后点击或按返回键消失;
            mMyDialog.show();
            /*点击确认按钮*/
            mMyDialog.getWindow().findViewById(R.id.textViewPositive).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMyDialog.dismiss(); //取消对话框
                }
            });
            /*点击取消按钮*/
            mMyDialog.getWindow().findViewById(R.id.textViewCancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //退出登录
                    mMyDialog.dismiss(); //取消对话框
                    finish();
                }
            });
         }
        }
    }
