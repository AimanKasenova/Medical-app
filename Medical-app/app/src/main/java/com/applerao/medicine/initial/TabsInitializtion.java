package com.applerao.medicine.initial;

import android.app.Activity;
import android.widget.LinearLayout;

import com.applerao.medicine.FaqsActivity;
import com.applerao.medicine.FindsActivity;
import com.applerao.medicine.MainActivity;
import com.applerao.medicine.PersonalActivity;
import com.applerao.medicine.R;

/**
 * Created by junxue.rao on 2016/2/15.
 * Tab初始化
 */
public class TabsInitializtion {


    public static LinearLayout classesTab;

    public static LinearLayout faqsTab;

    public static LinearLayout findsTab;

    public static LinearLayout personalTab;

    /**
     * 初始化底部菜单栏，在activity的onResume时初始化，确保各种情况都会初始化
     */
    public static void initTabs(Activity activity){
        if(classesTab == null){
            classesTab = (LinearLayout)activity.findViewById(R.id.classes_tab);
            faqsTab = (LinearLayout)activity.findViewById(R.id.faqs_tab);
            findsTab = (LinearLayout)activity.findViewById(R.id.finds_tab);
            personalTab = (LinearLayout)activity.findViewById(R.id.personal_tab);
            //找不到则退出初始化
            if(classesTab == null || faqsTab == null || findsTab == null || personalTab == null)
                return;
            classesTab.setOnClickListener(ActivityJumpClickListener.getInstance(activity, activity.getString(R.string.classes), MainActivity.class,null));
            faqsTab.setOnClickListener(ActivityJumpClickListener.getInstance(activity, activity.getString(R.string.faqs), FaqsActivity.class,null));
            findsTab.setOnClickListener(ActivityJumpClickListener.getInstance(activity, activity.getString(R.string.finds), FindsActivity.class,null));
            personalTab.setOnClickListener(ActivityJumpClickListener.getInstance(activity, activity.getString(R.string.personal), PersonalActivity.class,null));
        }
    }

    /**
     * 在activity的onPause时清空
     */
    public static void clearTabs(){
        classesTab = null;
        faqsTab = null;
        findsTab = null;
        personalTab = null;
    }

}
