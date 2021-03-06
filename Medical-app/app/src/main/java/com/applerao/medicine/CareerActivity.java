package com.applerao.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.applerao.medicine.initial.ListInitializtion;
import com.applerao.medicine.initial.TabsInitializtion;

/**
 * Created by junxue.rao on 2016/2/15.
 * 职业班级列表
 */
public class CareerActivity extends AppCompatActivity {

    private String id;

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career);
        Intent intent = getIntent();
        this.id = intent.getStringExtra("id");
        this.title = intent.getStringExtra("title");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        setTitle(this.title);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(this,R.string.action_settings_cn,Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_login:
                Toast.makeText(this,R.string.action_login_cn,Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TabsInitializtion.initTabs(this);//初始化Tabs
        ListInitializtion.initCareerList(this);//初始化列表
    }

    @Override
    protected void onPause() {
        super.onPause();
        TabsInitializtion.clearTabs();//清空Tabs
        ListInitializtion.clearCareerList();//清空列表
    }
}
