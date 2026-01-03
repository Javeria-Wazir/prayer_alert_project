package com.example.prayer_alert;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import java.util.Calendar;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            SharedPreferences prefs = context.getSharedPreferences("PrayerAlarmPrefs", Context.MODE_PRIVATE);

            // Re-schedule all alarms that were previously set
            if (prefs.getBoolean("alarm_1", false)) setAlarm(context, "Fajr", 5, 10, 1);
            if (prefs.getBoolean("alarm_2", false)) setAlarm(context, "Dhuhr", 12, 15, 2);
            if (prefs.getBoolean("alarm_3", false)) setAlarm(context, "Asr", 16, 30, 3);
            if (prefs.getBoolean("alarm_4", false)) setAlarm(context, "Maghrib", 18, 40, 4);
            if (prefs.getBoolean("alarm_5", false)) setAlarm(context, "Isha", 20, 0, 5);
        }
    }

    private void setAlarm(Context context, String prayerName, int hour, int minute, int requestCode) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra("PRAYER_NAME", prayerName);
        intent.putExtra("NOTIFICATION_ID", requestCode);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT | (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M ? PendingIntent.FLAG_IMMUTABLE : 0));

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTimeInMillis() <= System.currentTimeMillis()) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
}
