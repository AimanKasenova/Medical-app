package com.applerao.medicine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.applerao.medicine.initial.TabsInitializtion;

/**
 * Created by junxue.rao on 2016/2/15.
 * 选课中心
 */
public class ClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
    }

    @Override
    protected void onPause() {
        super.onPause();
        TabsInitializtion.clearTabs();//清空Tabs
    }
}
