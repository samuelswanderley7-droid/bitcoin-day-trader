package com.bitcoindaytrader.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class NotificationManagerUtil {
    private static final String CHANNEL_ID = "BitcoinTraderChannel";

    public static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Bitcoin Trader Notifications", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Notifications for Bitcoin trading updates.");
            NotificationManager manager = context.getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    public static void sendNotification(Context context, String title, String message) {
        Notification notification = new Notification.Builder(context, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(android.R.drawable.ic_notify)
                .setPriority(Notification.PRIORITY_HIGH)
                .build();

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(1, notification);
        }
    }
}