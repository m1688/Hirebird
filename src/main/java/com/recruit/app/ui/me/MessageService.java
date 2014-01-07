package com.recruit.app.ui.me;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.recruit.app.domain.model.Message;
import com.recruit.app.service.factory.ServiceFactory;
import com.recruit.app.ui.Injector;
import com.recruit.app.util.Ln;
import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * jyu - 1/5/14.
 */
public class MessageService extends Service {

    @Inject
    protected Bus BUS;
    @Inject
    NotificationManager notificationManager;

    public static final int MESSAGE_NOTIFICATION_ID = 1000;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Injector.inject(this);

        // Register the bus so we can send notifications.
        BUS.register(this);
    }

    @Override
    public void onDestroy() {

        // Unregister bus, since its not longer needed as the service is shutting down
        BUS.unregister(this);

        notificationManager.cancel(MESSAGE_NOTIFICATION_ID);

        Ln.d("Service has been destroyed");

        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent.getExtras() != null) {
            Message message = (Message) intent.getExtras().get("message");
            long id = ServiceFactory.getInstance().getMessageService().addMessage(message);
            if (id <= 0) {
                //TODO
            }
        }

        return START_NOT_STICKY;
    }


}
