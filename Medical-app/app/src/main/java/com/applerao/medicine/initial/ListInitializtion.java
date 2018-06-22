package com.applerao.medicine.initial;

import android.app.Activity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.applerao.medicine.CareerActivity;
import com.applerao.medicine.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by junxue.rao on 2016/2/15.
 * ListView初始化
 */
public class ListInitializtion {

    private static final List<String> TITLE_LIST = new ArrayList<>();

    static{
        TITLE_LIST.add("临床执业医师");
        TITLE_LIST.add("临床助理医师");
        TITLE_LIST.add("中医执业医师");
        TITLE_LIST.add("中医助理医师");
        TITLE_LIST.add("中西医职业医师");
        TITLE_LIST.add("中西医助理医师");
        TITLE_LIST.add("口腔职业医师");
        TITLE_LIST.add("口腔助理医师");
        TITLE_LIST.add("医师职业资格面授");
        TITLE_LIST.add("医师实践技能");
    }

    private static final List<String> CAREER_LIST = new ArrayList<>();

    static{
        CAREER_LIST.add("基础班");
        CAREER_LIST.add("冲刺班");
        CAREER_LIST.add("特色班");
    }

    private static final List<String> TEACHER_LIST = new ArrayList<>();

    static{
        TEACHER_LIST.add("闫静之");
        TEACHER_LIST.add("高晓松");
        TEACHER_LIST.add("杜敏镐");
    }

    private static final List<String> STATUS_LIST = new ArrayList<>();

    static{
        STATUS_LIST.add("3课时/23人在学");
        STATUS_LIST.add("3课时/23人在学");
        STATUS_LIST.add("3课时/23人在学");
    }


    /**
     * 试听课程列表
     */
    public static ListView trialList;

    /**
     * 职业班级列表
     */
    public static ListView careerList;

    /**
     * 选课中心列表
     */
    public static ListView classList;

    /**
     * 初始化trialList列表，在activity的onResume时初始化，确保各种情况都会初始化
     */
    public static void initTrialList(final Activity activity) {
        if (trialList == null) {
            trialList = (ListView) activity.findViewById(R.id.trial_list);
            //找不到则退出初始化
            if (trialList == null)
                return;
            List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
            for (int i = 0; i < 10; i++) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("title", TITLE_LIST.get(new Random().nextInt(10)));
                map.put("id", String.valueOf(i));
                data.add(map);
            }
            SimpleAdapter simpleAdapter = new SimpleAdapter(activity, data, R.layout.trial_list_item, new String[]{"title"}, new int[]{R.id.trial_title});
            trialList.setAdapter(simpleAdapter);
            trialList.setOnItemClickListener(ActivityJumpClickListener.getInstance(activity,activity.getString(R.string.career_classes),CareerActivity.class,null));
        }
    }

    /**
     * 在activity的onPause时清空trialList
     */
    public static void clearTrialList() {
        trialList = null;
    }

    /**
     * 初始化careerList列表，在activity的onResume时初始化，确保各种情况都会初始化
     */
    public static void initCareerList(final Activity activity) {
        if (careerList == null) {
            careerList = (ListView) activity.findViewById(R.id.career_list);
            //找不到则退出初始化
            if (careerList == null)
                return;
            List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
            for (int i = 0; i < 3; i++) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("name", CAREER_LIST.get(new Random().nextInt(3)));
                map.put("teacher", TEACHER_LIST.get(new Random().nextInt(3)));
                map.put("status", STATUS_LIST.get(new Random().nextInt(3)));
                map.put("id", String.valueOf(i));
                data.add(map);
            }
            SimpleAdapter simpleAdapter = new SimpleAdapter(activity, data, R.layout.career_list_item, new String[]{"name","teacher","status"}, new int[]{R.id.class_name,R.id.class_teacher,R.id.class_status});
            careerList.setAdapter(simpleAdapter);
            careerList.setOnItemClickListener(ActivityJumpClickListener.getInstance(activity, activity.getString(R.string.career_classes), CareerActivity.class, null));
        }
    }

    /**
     * 在activity的onPause时清空careerList
     */
    public static void clearCareerList() {
        careerList = null;
    }

}
