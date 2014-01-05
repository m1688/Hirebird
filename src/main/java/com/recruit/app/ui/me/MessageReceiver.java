package com.recruit.app.ui.me;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.recruit.R;
import com.recruit.app.domain.model.Message;
import com.recruit.app.service.factory.ServiceFactory;
import com.recruit.app.ui.Injector;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * jyu - 1/5/14.
 */
public class MessageReceiver extends BroadcastReceiver {

    @Inject
    NotificationManager notificationManager;

    public static final int MESSAGE_NOTIFICATION_ID = 1000;

    private List<Long> notifiedMessages = new ArrayList<Long>();

    public MessageReceiver() {
        Injector.inject(this);
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        List<Message> messages = ServiceFactory.getInstance().getMessageService().queryMessageByReceiverId(1000L);

        if (notificationManager != null) {
            for (Message message : messages) {
                if (!notifiedMessages.contains(message.getId())) {
                    notificationManager.notify(MESSAGE_NOTIFICATION_ID, getNotification(context, message));
                    notifiedMessages.add(message.getId());
                }
            }
        }

    }

    private Notification getNotification(Context context, Message message) {
        final Intent i = new Intent(context, MessageActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, MESSAGE_NOTIFICATION_ID, i, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle(message.getTitle())
                .setSmallIcon(R.drawable.ic_stat_ab_notification)
                .setContentText(message.getContent())
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setOngoing(true)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent).build();

        return notification;
    }
}
