package com.applerao.medicine.initial;

import android.app.Activity;
import android.widget.LinearLayout;

import com.applerao.medicine.ClassActivity;
import com.applerao.medicine.R;
import com.applerao.medicine.TrialActivity;

/**
 * Created by junxue.rao on 2016/2/15.
 * Button初始化
 */
public class ButtonsInitializtion {


    /**
     * 试听课程按钮
     */
    public static LinearLayout trialArea;

    /**
     * 选课中心按钮
     */
    public static LinearLayout classArea;

    /**
     * 初始化首页按钮，在activity的onResume时初始化，确保各种情况都会初始化
     */
    public static void initButtons(Activity activity) {
        if (trialArea == null) {
            trialArea = (LinearLayout) activity.findViewById(R.id.trial_area);
            classArea = (LinearLayout) activity.findViewById(R.id.class_area);
            //找不到则退出初始化
            if (trialArea == null || classArea == null)
                return;
            trialArea.setOnClickListener(ActivityJumpClickListener.getInstance(activity, activity.getString(R.string.trial_class), TrialActivity.class,null));
            classArea.setOnClickListener(ActivityJumpClickListener.getInstance(activity, activity.getString(R.string.class_center), ClassActivity.class,null));
        }
    }

    /**
     * 在activity的onPause时清空
     */
    public static void clearButtons() {
        trialArea = null;
        classArea = null;
    }

}
