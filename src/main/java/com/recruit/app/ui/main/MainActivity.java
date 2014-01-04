package com.recruit.app.ui.main;

import android.os.Bundle;

import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.ui.common.SlidingMenuActivity;

public class MainActivity extends SlidingMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecruitSQLiteOpenHelper.init(getApplicationContext());
    }

}
