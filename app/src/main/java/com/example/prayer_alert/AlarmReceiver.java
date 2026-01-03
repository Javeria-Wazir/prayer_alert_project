package com.example.prayer_alert;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    private static final String CHANNEL_ID = "PRAYER_ALARM_CHANNEL";

    @Override
    public void onReceive(Context context, Intent intent) {
        String prayerName = intent.getStringExtra("PRAYER_NAME");
        int notificationId = intent.getIntExtra("NOTIFICATION_ID", 0);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Create notification channel for Android Oreo and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID, 
                    "Prayer Time Alerts", 
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Notifications for prayer time reminders");
            notificationManager.createNotificationChannel(channel);
        }

        // Build the notification
        Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_alarm) // Make sure you have this icon
                .setContentTitle("Prayer Time!")
                .setContentText("It's time for " + prayerName)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true)
                .build();

        // Show the notification
        notificationManager.notify(notificationId, notification);
    }
}
