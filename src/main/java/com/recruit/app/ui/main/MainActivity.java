package com.recruit.app.ui.main;

import android.os.Bundle;

import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.ui.common.SlidingMenuActivity;

public class MainActivity extends SlidingMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecruitSQLiteOpenHelper.init(getApplicationContext());
//		SampleDatas.init();	//去掉注释生成例子数据，只需要生成一次即可，除非手动将数据库文件删掉了才需要再次生成
//		setContentView(R.layout.activity_main);
    }

}
