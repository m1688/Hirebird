

package com.recruit.app.ui;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.FROYO;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;

import com.github.kevinsawicki.http.HttpRequest;
import com.recruit.app.db.RecruitSQLiteOpenHelper;
import com.recruit.app.ui.main.SampleDatas;

/**
 * Android Bootstrap application
 */
public class HireBirdApplication extends Application {

    private static HireBirdApplication instance;

    /**
     * Create main application
     */
    public HireBirdApplication() {

        // Disable http.keepAlive on Froyo and below
        if (SDK_INT <= FROYO)
            HttpRequest.keepAlive(false);
    }

    /**
     * Create main application
     *
     * @param context
     */
    public HireBirdApplication(final Context context) {
        this();
        attachBaseContext(context);

    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        // Perform injection
        Injector.init(getRootModule(), this);

        RecruitSQLiteOpenHelper.init(getApplicationContext());
        SampleDatas.init();	//去掉注释生成例子数据，只需要生成一次即可，除非手动将数据库文件删掉了才需要再次生成

    }

    private Object getRootModule() {
        return new RootModule();
    }


    /**
     * Create main application
     *
     * @param instrumentation
     */
    public HireBirdApplication(final Instrumentation instrumentation) {
        this();
        attachBaseContext(instrumentation.getTargetContext());
    }

    public static HireBirdApplication getInstance() {
        return instance;
    }
}
