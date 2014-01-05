package com.recruit.app.ui.me;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;

import com.recruit.app.ui.Injector;
import com.recruit.app.util.Ln;

/**
 * jyu - 1/5/14.
 */
public class PullMessageService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Injector.inject(this);

        AlarmManager alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(), MessageReceiver.class);
        int requestCode = 0;
        PendingIntent pendIntent = PendingIntent.getBroadcast(this,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        long triggerAtTime = SystemClock.elapsedRealtime() + 5 * 1000;
        alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME, triggerAtTime, 5 * 1000, pendIntent);
    }


    @Override
    public void onDestroy() {

        Ln.d("Service has been destroyed");

        AlarmManager alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(), MessageReceiver.class);
        PendingIntent pendIntent = PendingIntent.getBroadcast(this,
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmMgr.cancel(pendIntent);


        super.onDestroy();
    }


}
