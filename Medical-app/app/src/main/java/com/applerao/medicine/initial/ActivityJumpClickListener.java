package com.applerao.medicine.initial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.HashMap;

/**
 * Created by junxue.rao on 2016/2/15.
 * 页面跳转点击监听器
 */
public class ActivityJumpClickListener implements View.OnClickListener,AdapterView.OnItemClickListener{

    /**
     * 当前的activity对象
     */
    private Activity activity;

    /**
     * Toast提示
     */
    private String toast;

    /**
     * 传参
     */
    private Bundle extras;

    /**
     * 跳转到的activity页面
     */
    private Class<? extends Activity> toActivityClass;

    public static ActivityJumpClickListener getInstance(Activity activity,String toast,Class<? extends Activity> toActivityClass,Bundle extras){
        ActivityJumpClickListener listener = new ActivityJumpClickListener();
        listener.activity = activity;
        listener.toast = toast;
        listener.toActivityClass = toActivityClass;
        listener.extras = extras;
        return listener;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if(extras != null && !extras.isEmpty()){
            intent.putExtras(extras);
        }
        intent.setClass(activity,toActivityClass);
        activity.startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListView listView = (ListView)parent;
        HashMap<String,String> map = (HashMap<String, String>) listView.getItemAtPosition(position);
        String positionId = map.get("id");
        String title = map.get("title");
        Intent intent = new Intent();
        if(extras != null && !extras.isEmpty()){
            intent.putExtras(extras);
        }
        intent.putExtra("id", positionId);
        intent.putExtra("title", title);
        intent.setClass(activity, toActivityClass);
        activity.startActivity(intent);
    }
}
